package com.example.ClinicaDentalS.TestUnitario;
import org.junit.Test;
import com.example.ClinicaDentalS.Entity.DTO.OdontologoDTO;
import com.example.ClinicaDentalS.Entity.DTO.PacienteDTO;
import com.example.ClinicaDentalS.Entity.Domicilio;
import com.example.ClinicaDentalS.Service.OdontologoService;
import com.example.ClinicaDentalS.Service.PacienteService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestUnitario {

    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private OdontologoService odontologoService;





    //creacion del paciente + buscar
    @Test
    public void pacienteTest (){
        Domicilio domicilio = new Domicilio("Buen pastor",30,"Buenos Aires","Buenos Aires");

        //DTO
        PacienteDTO pacienteDTO = new PacienteDTO("Maxi","cvetic",4545, LocalDate.of(2023,10,10),domicilio,"anc@gmail.com");
        pacienteService.crear(pacienteDTO);

        Set<PacienteDTO> listaPacientes = pacienteService.buscarTodos();

        int valorEsperado = 1;

        assertEquals(valorEsperado,listaPacientes.size());

    }

    @Test
    public void Odontologo (){

        //DTO
        OdontologoDTO odontologoDTO = new OdontologoDTO(444,"Juan","Perez");
        odontologoService.crearOdontologo(odontologoDTO);

        Set<OdontologoDTO> listaOdontologos = odontologoService.buscarTodos();

        int valorEsperado = 1;

        assertEquals(valorEsperado,listaOdontologos.size());

    }


    @Test
    public void delete(){
        //DTO
        OdontologoDTO odontologoDTO = new OdontologoDTO(444,"Juan","Perez");
        odontologoService.crearOdontologo(odontologoDTO);

        OdontologoDTO odontologoBuscado =   odontologoService.buscarOdontologo(1L);
        Long id = odontologoBuscado.getId();
        odontologoService.eliminarOdontologo(id);

        assertNull(odontologoService.buscarOdontologo(1L));

    }










}
