package com.example.ClinicaDentalS.Controller;

import com.example.ClinicaDentalS.Entity.DTO.OdontologoDTO;
import com.example.ClinicaDentalS.Entity.Odontologo;
import com.example.ClinicaDentalS.Service.OdontologoService;
import com.example.ClinicaDentalS.exception.ResourceNotFoundException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;



@RestController()
@RequestMapping("/odontologos")

public class OdontologoController {

    @Autowired
    private OdontologoService odontologoService;
    Logger logger = Logger.getLogger(OdontologoController.class);

    // Con el AutoWired hago que el servicio se instancie cuando
    // Es necesario que los servicios tengan el @Service para que spring los reconozca



    //GETS

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarOdontologoPorId(@PathVariable Long id ){
           OdontologoDTO  odontologoDTOBuscado = odontologoService.buscarOdontologo(id);
           if(odontologoDTOBuscado != null){
               return ResponseEntity.ok(odontologoDTOBuscado);
           }
           else{
              return ResponseEntity.notFound().build();
           }

    }



    @GetMapping("")
        public ResponseEntity<Collection<OdontologoDTO>> buscarTodosLosOdontologos(){
        return ResponseEntity.ok(odontologoService.buscarTodos());

    }




    //POST

    @PostMapping()// nos permite poder crear o registrar un nuevo odontologo
    //todo lo que venga por el cuerpo del JSON
    public ResponseEntity<?> registrarOdontologo(@RequestBody OdontologoDTO odontologoDTO ) {
        odontologoService.crearOdontologo(odontologoDTO);
        return ResponseEntity.ok(HttpStatus.OK);


    }


    //PUT

    @PutMapping
    //hacemos un logger aca para que postman vea
    public ResponseEntity<?>  actualizarOdontologo(@RequestBody OdontologoDTO odontologoDTO){
        //primero hay que preguntar si el odontolog existe
        OdontologoDTO  odontologoDTOBuscado = odontologoService.buscarOdontologo(odontologoDTO.getId());
        if (odontologoDTOBuscado != null){
            odontologoService.modificar(odontologoDTO);
            return ResponseEntity.ok(HttpStatus.OK);
        }else {
            return ResponseEntity.badRequest().build();
        }



    }


    //DELETE

    @DeleteMapping("/{id}")
    public ResponseEntity<Odontologo> eliminarOdontologoPorId(@PathVariable Long id) throws ResourceNotFoundException {
        OdontologoDTO  odontologoDTOBuscado = odontologoService.buscarOdontologo(id);

        if(odontologoDTOBuscado != null){
            logger.info("Odontologo ID: " + id + " eliminado");
            odontologoService.eliminarOdontologo(id);
            return ResponseEntity.ok().build();
        }
        else {
            throw new ResourceNotFoundException("No se pudo eliminar el  odontologo..");
        }



    }











}
