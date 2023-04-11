package com.example.ClinicaDentalS.Service;





import com.example.ClinicaDentalS.Controller.OdontologoController;
import com.example.ClinicaDentalS.Entity.DTO.OdontologoDTO;
import com.example.ClinicaDentalS.Entity.DTO.PacienteDTO;
import com.example.ClinicaDentalS.Entity.Odontologo;
import com.example.ClinicaDentalS.Entity.Paciente;
import com.example.ClinicaDentalS.Repository.OdontologoRepository;
import com.example.ClinicaDentalS.Repository.PacienteRepository;
import com.example.ClinicaDentalS.Service.ServiceInterface.IOdontoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
public class OdontologoService implements IOdontoService {
    @Autowired
    private OdontologoRepository odontologoRepository;
    @Autowired
    ObjectMapper mapper;

    Logger logger = Logger.getLogger(OdontologoService.class);



    public void createAll(OdontologoDTO odontologoDTO){
        Odontologo odontologo = mapper.convertValue(odontologoDTO,Odontologo.class);
        odontologoRepository.save(odontologo);

    }


    @Override
    public void crearOdontologo(OdontologoDTO odontologtoDTO) {
        logger.info("Registrando Odontologo...");
        createAll(odontologtoDTO);
    }
    @Override
    public void modificar(OdontologoDTO odontologoDTO) {
        logger.info("Modificando Odontologo...");
        Odontologo odontologo = mapper.convertValue(odontologoDTO,Odontologo.class);
        Optional<Odontologo> odoBuscado = odontologoRepository.findById(odontologo.getId());
        if(odoBuscado.isPresent()){
            createAll(odontologoDTO);
            logger.info("Odontologo " + odontologo.getNombre() + " modificado con exito");
        }
        else {
            logger.error("No se puede modificar el odontologo ya que no existe el id");
        }





    }

    @Override
    public OdontologoDTO buscarOdontologo(Long id) {
        logger.info("Buscando Odontologo...");
        Optional<Odontologo> odontologoBuscado = odontologoRepository.findById(id);
        OdontologoDTO  odontologoDTO = null;
        if (odontologoBuscado.isPresent()){
            odontologoDTO = mapper.convertValue(odontologoBuscado,OdontologoDTO.class);
            logger.info("Odontologo encontrado "+ odontologoDTO.getNombre() + " con id: "  + id);
        }else{
            logger.error("El odontologo ID: "+ id + " No se encuentra registrado en nuestra base de datos");
        }
        return odontologoDTO;

    }


    @Override
    public void eliminarOdontologo(Long id) {
        logger.info("Eliminando Odontologo...");
        odontologoRepository.deleteById(id);

    }

    @Override
    public Set<OdontologoDTO> buscarTodos() {
        logger.info("<<<<<<<<<<<Buscando todos los odontologos>>>>>>>>");
        List<Odontologo> odontologosList = odontologoRepository.findAll();
        Set<OdontologoDTO> odontologoDTOS = new HashSet<>();
        for(Odontologo odontologo:odontologosList){
            odontologoDTOS.add(mapper.convertValue(odontologo, OdontologoDTO.class));

        }
        return odontologoDTOS;
    }
}
