package com.example.ClinicaDentalS.Service.ServiceInterface;

import com.example.ClinicaDentalS.Entity.DTO.PacienteDTO;
import com.example.ClinicaDentalS.Entity.Paciente;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface IPacienteService {
    void crear(PacienteDTO pacienteDTO);
    void eliminar(Long id);
    PacienteDTO buscarPacientePorID(Long id);
    void modificarPaciente (PacienteDTO pacienteDTO);
    Set<PacienteDTO> buscarTodos();
    PacienteDTO buscarPacientePorCorreo(String email);



}
