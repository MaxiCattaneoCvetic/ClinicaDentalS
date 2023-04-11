package com.example.ClinicaDentalS.TestIntegracion;

import static org.junit.jupiter.api.Assertions.assertFalse;
import com.example.ClinicaDentalS.Entity.DTO.OdontologoDTO;
import com.example.ClinicaDentalS.Entity.DTO.PacienteDTO;
import com.example.ClinicaDentalS.Entity.DTO.TurnoDTO;
import com.example.ClinicaDentalS.Entity.Domicilio;
import com.example.ClinicaDentalS.Entity.Odontologo;
import com.example.ClinicaDentalS.Entity.Paciente;
import com.example.ClinicaDentalS.Service.OdontologoService;
import com.example.ClinicaDentalS.Service.PacienteService;
import com.example.ClinicaDentalS.Service.TurnoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import java.time.LocalDate;
import java.time.LocalTime;

//primero indicamos que esto es una clase de tipo test
@SpringBootTest
//utilizamos el mook, le decimos que no usamos filtros
@AutoConfigureMockMvc(addFilters = false)
public class IntegracionTurnoTEST {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private OdontologoService odontologoService;
    @Autowired
    private TurnoService turnoService;


    @Autowired
    ObjectMapper mapper;
    //Ahora necesitamos un metodo para cargar los datos


    private void cargaDatos(){
        Domicilio domicilio = new Domicilio("Buen pastor",30,"Buenos Aires","Buenos Aires");

        //DTO
        PacienteDTO pacienteDTO = new PacienteDTO("Maxi","cvetic",4545,LocalDate.of(2023,10,10),domicilio,"anc@gmail.com");
        OdontologoDTO odontologoDTO = new OdontologoDTO(444,"Juan","Perez");
        pacienteService.crear(pacienteDTO);
        odontologoService.crearOdontologo(odontologoDTO);




        TurnoDTO turnoDTOTEST = new TurnoDTO();
        turnoDTOTEST.setFechaTurno(LocalDate.of(2023,10,10));
        turnoDTOTEST.setHoraTurno(LocalTime.of(10,20));
        //cambio de clase
        Odontologo odontologo = mapper.convertValue(odontologoDTO,Odontologo.class);
        Paciente paciente = mapper.convertValue(pacienteDTO,Paciente.class);
        //seteo
        turnoDTOTEST.setOdontologo(odontologo);
        turnoDTOTEST.setPaciente(paciente);





    }



    @Test
    public void listarTurnoTest() throws Exception {
        cargaDatos();
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/turnos/").accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
            assertFalse(result.getResponse().getContentAsString().isEmpty());

    }






}
