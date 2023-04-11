package com.example.ClinicaDentalS.Service;



import com.example.ClinicaDentalS.Entity.DTO.OdontologoDTO;
import com.example.ClinicaDentalS.Entity.DTO.PacienteDTO;
import com.example.ClinicaDentalS.Entity.DTO.TurnoDTO;
import com.example.ClinicaDentalS.Entity.Paciente;
import com.example.ClinicaDentalS.Entity.Turno;
import com.example.ClinicaDentalS.Repository.TurnoRepository;
import com.example.ClinicaDentalS.Service.ServiceInterface.IPacienteService;
import com.example.ClinicaDentalS.Service.ServiceInterface.ITurnoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
public class TurnoService  implements ITurnoService {



    @Autowired
    private TurnoRepository turnoRepository;

    @Autowired
    ObjectMapper mapper;

    public void createAll(TurnoDTO turnoDTO){
        Turno turno = mapper.convertValue(turnoDTO,Turno.class);
        turnoRepository.save(turno);

    }

    @Override
    public void crearTurno(TurnoDTO turnoDTO) {
        createAll(turnoDTO);
    }

    @Override
    public void eliminarTurno(Long id) {
        turnoRepository.deleteById(id);

    }

    @Override
    public TurnoDTO buscarTurnoPorID(Long id) {
        Optional<Turno> turnoBuscado = turnoRepository.findById(id);
        TurnoDTO turnoDTO = null;

        if(turnoBuscado.isPresent()){
            turnoDTO = mapper.convertValue(turnoBuscado, TurnoDTO.class);
        }

        return turnoDTO;



    }

    @Override
    public void modificarTurno(TurnoDTO turnoDTO) {
        createAll(turnoDTO);
    }

    @Override
    public Set<TurnoDTO> buscarTodos() {
        List<Turno> turnoList = turnoRepository.findAll();
        Set<TurnoDTO> turnoDTOS = new HashSet<>();

        for(Turno turno: turnoList){
            turnoDTOS.add(mapper.convertValue(turno, TurnoDTO.class));
        }
        return turnoDTOS;

    }
}
