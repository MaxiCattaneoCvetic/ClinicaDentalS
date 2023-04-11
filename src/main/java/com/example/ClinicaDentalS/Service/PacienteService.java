package com.example.ClinicaDentalS.Service;



import com.example.ClinicaDentalS.Entity.DTO.PacienteDTO;
import com.example.ClinicaDentalS.Entity.Paciente;
import com.example.ClinicaDentalS.Repository.PacienteRepository;
import com.example.ClinicaDentalS.Service.ServiceInterface.IPacienteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
public class PacienteService  implements IPacienteService {
    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    ObjectMapper mapper;

    Logger logger = Logger.getLogger(PacienteService.class);
    public void createAll(PacienteDTO pacienteDTO){
        Paciente paciente = mapper.convertValue(pacienteDTO,Paciente.class);
        pacienteRepository.save(paciente);

    }
    @Override
    public void crear(PacienteDTO pacienteDTO) {
        logger.info("Registrando paciente..");
        createAll(pacienteDTO);

    }

    @Override
    public void eliminar(Long id) {
        logger.info("Eliminando  paciente..");
        pacienteRepository.deleteById(id);
    }

    @Override
    public PacienteDTO buscarPacientePorID(Long id) {
        logger.info("Buscando  paciente..");
        Optional<Paciente> pacienteBuscado = pacienteRepository.findById(id);
        PacienteDTO  pacienteDTO = null;
        if (pacienteBuscado.isPresent()){
            logger.info("Paciente Encontrado");
            pacienteDTO = mapper.convertValue(pacienteBuscado,PacienteDTO.class);
            return pacienteDTO;
        }
        return pacienteDTO;
    }

    @Override
    public void modificarPaciente(PacienteDTO pacienteDTO) {
        logger.info("Modificando  paciente..");
        createAll(pacienteDTO);
    }

    @Override
    public Set<PacienteDTO> buscarTodos() {
        logger.info("Buscando todos los pacientes..");
        List<Paciente> pacientes = pacienteRepository.findAll();
        Set<PacienteDTO> pacienteDTOS = new HashSet<>();
        for(Paciente paciente:pacientes){
            pacienteDTOS.add(mapper.convertValue(paciente, PacienteDTO.class));

        }
        return pacienteDTOS;

    }

    @Override
    public PacienteDTO buscarPacientePorCorreo(String email) {
        logger.info("Buscando paciente por email..");
        Optional<Paciente> pacienteBuscado = pacienteRepository.findByEmail(email);
        PacienteDTO  pacienteDTO = null;
        if (pacienteBuscado.isPresent()){
            pacienteDTO = mapper.convertValue(pacienteBuscado,PacienteDTO.class);

        }
        return pacienteDTO;
    }
}
