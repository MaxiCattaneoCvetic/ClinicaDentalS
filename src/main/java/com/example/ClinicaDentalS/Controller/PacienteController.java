package com.example.ClinicaDentalS.Controller;

import com.example.ClinicaDentalS.Entity.DTO.PacienteDTO;
import com.example.ClinicaDentalS.Service.PacienteService;
import com.example.ClinicaDentalS.exception.BadRequestException;
import com.example.ClinicaDentalS.exception.ResourceNotFoundException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


// usamos controller ya que restController es cuando trabajamos con una api

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    @Autowired
    private PacienteService pacienteService;
    Logger logger = Logger.getLogger(PacienteController.class);
    // Con el AutoWired hago que el servicio se instancie cuando
    // Es necesario que los servicios tengan el @Service para que spring los reconozca






    //GETS

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPacientePorId(@PathVariable Long id ){
        PacienteDTO pacienteDTObuscado = pacienteService.buscarPacientePorID(id);
        if(pacienteDTObuscado != null){
            return ResponseEntity.ok(pacienteDTObuscado);
        }
        else{
            return ResponseEntity.notFound().build();
        }

    }



    @GetMapping("/buscar/correo/{email}")
    public ResponseEntity<?> buscarPacientePorCorreo(@PathVariable String email){
        PacienteDTO pacienteDTOBuscado = pacienteService.buscarPacientePorCorreo(email);

        if(pacienteDTOBuscado != null){
            return ResponseEntity.ok().body(pacienteDTOBuscado);
        }else{
            return ResponseEntity.notFound().build();
        }



    }


    @GetMapping("/")
    public ResponseEntity<Collection<PacienteDTO>> listarTodosLosPacientes(){
        return ResponseEntity.ok(pacienteService.buscarTodos());

    }

    //POST

    @PostMapping("/add")
    //todo lo que venga por el cuerpo del JSON
    public ResponseEntity<?> registrarPaciente(@RequestBody PacienteDTO pacienteDTO ) throws BadRequestException {
        PacienteDTO pacienteDTO1 = pacienteService.buscarPacientePorCorreo(pacienteDTO.getEmail());
        if (pacienteDTO1 == null){
            pacienteService.crear(pacienteDTO);
            return ResponseEntity.ok(HttpStatus.OK);
        }else {
            throw new BadRequestException("No se pudo crear el  paciente..");
        }

    }


    //PUT

    @PutMapping("/update")
    public ResponseEntity<?> actualizarPaciente(@RequestBody PacienteDTO pacienteDTO){
        PacienteDTO  pacienteDTObuscado = pacienteService.buscarPacientePorID(pacienteDTO.getId());
        if (pacienteDTObuscado != null){
            logger.info("Paciente " + pacienteDTObuscado.getNombre() + " Modificado con exito");
            pacienteService.modificarPaciente(pacienteDTO);
            return ResponseEntity.ok(HttpStatus.OK);
        }else {
            logger.error("No se pudo modificar el  paciente..");
            return ResponseEntity.badRequest().build();
        }
    }


    //DELETE

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarPacientePorId(@PathVariable Long id) throws ResourceNotFoundException {
        PacienteDTO  pacienteDTObuscado = pacienteService.buscarPacientePorID(id);
        if (pacienteDTObuscado != null){
            logger.info("Paciente id: " + id +"Nombre: " +pacienteDTObuscado.getNombre()+ " Eliminado");
            pacienteService.eliminar(id);
            return ResponseEntity.ok(HttpStatus.OK);
        }else {
            throw new ResourceNotFoundException("No se pudo eliminar el  paciente..");

        }

    }




}
