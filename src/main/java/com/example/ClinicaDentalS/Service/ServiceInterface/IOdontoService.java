package com.example.ClinicaDentalS.Service.ServiceInterface;

import com.example.ClinicaDentalS.Entity.DTO.OdontologoDTO;

import java.util.Set;

public interface IOdontoService {

    void crearOdontologo(OdontologoDTO odontologtoDTO);
    OdontologoDTO buscarOdontologo(Long id);
    void modificar(OdontologoDTO odontologtoDTO);
    void eliminarOdontologo(Long id);
    Set<OdontologoDTO> buscarTodos();



}
