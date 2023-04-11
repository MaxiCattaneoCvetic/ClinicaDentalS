package com.example.ClinicaDentalS.Service.ServiceInterface;

import com.example.ClinicaDentalS.Entity.DTO.TurnoDTO;
import java.util.Optional;
import java.util.Set;

public interface ITurnoService {

    void crearTurno(TurnoDTO turnoDTO);
    void eliminarTurno(Long id);
    TurnoDTO buscarTurnoPorID(Long id);
    void modificarTurno (TurnoDTO turnoDTO);
    Set<TurnoDTO> buscarTodos();
}
