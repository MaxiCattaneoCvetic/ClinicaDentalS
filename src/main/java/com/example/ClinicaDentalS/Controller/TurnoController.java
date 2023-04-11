package com.example.ClinicaDentalS.Controller;


import com.example.ClinicaDentalS.Entity.DTO.OdontologoDTO;
import com.example.ClinicaDentalS.Entity.DTO.PacienteDTO;
import com.example.ClinicaDentalS.Entity.DTO.TurnoDTO;
import com.example.ClinicaDentalS.Entity.Odontologo;
import com.example.ClinicaDentalS.Entity.Paciente;
import com.example.ClinicaDentalS.Entity.Turno;
import com.example.ClinicaDentalS.Service.OdontologoService;
import com.example.ClinicaDentalS.Service.PacienteService;
import com.example.ClinicaDentalS.Service.TurnoService;
import com.example.ClinicaDentalS.exception.ResourceNotFoundException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Collection;
import java.util.Optional;

@RestController()
@RequestMapping("/turnos")

public class TurnoController {
    @Autowired
    private TurnoService turnoService;
    @Autowired
    private OdontologoService odontologoService;
    @Autowired
    private PacienteService pacienteService;

    @Autowired
    ObjectMapper mapper;

    Logger loger = Logger.getLogger(TurnoController.class);



    // Con el AutoWired hago que el servicio se instancie cuando es necesario
    // Es necesario que los servicios tengan el @Service para que spring los reconozca




    @GetMapping("/{id}")
    public ResponseEntity<?> buscarTurno(@PathVariable Long id){
        loger.info("Buscando turno id: "+ id);
        TurnoDTO turnoDTOBuscado = turnoService.buscarTurnoPorID(id);

        if(turnoDTOBuscado !=null){
            loger.info("Turno encontrado, mostrando turno del dia: " + turnoDTOBuscado.getFechaTurno() + " Horario: " + turnoDTOBuscado.getHoraTurno());
            return ResponseEntity.ok(turnoDTOBuscado);
        }else{
            loger.error("No se encontro el turno ");
            return ResponseEntity.notFound().build();
        }

    }


    //usamos delete
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarTurno(@PathVariable Long id){
        loger.info("Eliminando turno id: "+ id);
        TurnoDTO turnoDTOBuscado = turnoService.buscarTurnoPorID(id);
        if (turnoDTOBuscado != null){
            loger.info("turno eliminado id: "+ id );
            turnoService.eliminarTurno(id);
            return ResponseEntity.ok().build();
        }else {
            loger.error("No se pudo eliminar el turno" );
            // enviamos un error 404
            return ResponseEntity.notFound().build();
        }

    }




    // METODO POST > CREAMOS UN TURNO
    @PostMapping
    //usamos responseEntity para retornar un codigo de error, de turnos
    public ResponseEntity<?> registarTurno(@RequestBody TurnoDTO turnoDTO){

        PacienteDTO pacienteDTOBuscado = pacienteService.buscarPacientePorID(turnoDTO.getPaciente().getId());
        OdontologoDTO odontologoDTOBuscado = odontologoService.buscarOdontologo(turnoDTO.getOdontologo().getId());

        if(pacienteDTOBuscado != null && odontologoDTOBuscado != null){
            loger.info("Creando turno..");
            turnoService.crearTurno(turnoDTO);
            return ResponseEntity.ok(HttpStatus.OK);
        }else{
            loger.error("El turno no se pudo crear");
            return ResponseEntity.notFound().build();
        }

    }

    @GetMapping("/")
    public ResponseEntity<Collection<TurnoDTO>> listarTodosLosTurnos(){
        return ResponseEntity.ok(turnoService.buscarTodos());

    }

    @PutMapping
    public ResponseEntity<?> actualizarTurno(@RequestBody TurnoDTO turnoDTO) throws ResourceNotFoundException {
        TurnoDTO turnoDTOBuscado= turnoService.buscarTurnoPorID(turnoDTO.getId());
        PacienteDTO pacienteDTOBuscado = pacienteService.buscarPacientePorID(turnoDTO.getPaciente().getId());
        OdontologoDTO odontologoDTOBuscado = odontologoService.buscarOdontologo(turnoDTO.getOdontologo().getId());


        if(pacienteDTOBuscado != null && odontologoDTOBuscado != null && turnoDTOBuscado != null){
            loger.info("Actualizando turno..");
            turnoService.modificarTurno(turnoDTO);
            return ResponseEntity.ok(HttpStatus.OK);
        }else{
            throw new ResourceNotFoundException("No se pudo actualizar el  turno..");

        }

    }

}
