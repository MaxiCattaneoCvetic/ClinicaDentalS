//package com.example.ClinicaDentalS.Test;

import com.example.ClinicaDentalS.Entity.Paciente;

import java.time.LocalDate;
//
//public class MainTest {
//    public static void main(String[] args) {
////
//        //cracion tablas
//        BDconnectionH2.crearTablas();
//
//        //Creando servicios
//        PacienteService pacienteService = new PacienteService();
//        TurnoService turnoService = new TurnoService();
//
//        //domicilios
//        Domicilio domicilio0 = new Domicilio("Santa fe ",123,"Capital","Buenos Aires");
//        Domicilio domicilio1 = new Domicilio("Cordoba ",2561,"Capital","Buenos Aires");
//        Domicilio domicilio2 = new Domicilio("Panama",444,"La plata","Buenos Aires");
//
//
//        //odontologos
//        Odontologo odontologo0 = new Odontologo(4455,"Juan","Perez");
//        Odontologo odontologo1 = new Odontologo(5544,"Manuel","Rodriguez");
//        Odontologo odontologo2 = new Odontologo(2315,"Alonso","Paez");
//
//
//        //pacientes
//        Paciente paciente0 = new Paciente("Maxi","Cvetic",38489185, LocalDate.of(2023,10,5),domicilio0,"email 1",odontologo0);
//        Paciente paciente1 = new Paciente("Pedro","Suarez",11248185,LocalDate.of(2023,5,20),domicilio1,"email 2",odontologo1);
//        Paciente paciente2 = new Paciente("Matias","Martel",48012581,LocalDate.of(2023,8,11),domicilio2,"email 3",odontologo2);
//
//        pacienteService.crear(paciente0);
//        pacienteService.crear(paciente1);
//        pacienteService.crear(paciente2);
//
//
//
//        //Turnos
//        Turno turno0= new Turno(paciente0,odontologo0,LocalDate.of(2023,10,5), LocalTime.of(15,10));
//        Turno turno1 = new Turno(paciente1,odontologo1,LocalDate.of(2023,12,10),LocalTime.of(10,10));
//        Turno turno2 = new Turno(paciente2,odontologo2,LocalDate.of(2023,5,20),LocalTime.of(20,10));
//
//        turnoService.crearTurno(turno0);
//        turnoService.crearTurno(turno1);
//        turnoService.crearTurno(turno2);
////
////        //turno sin bd
////        TurnoDaoSinBD turnoDaoSinBD = new TurnoDaoSinBD();
////        TurnoServiceOutBD turnoServiceOutBD = new TurnoServiceOutBD();
////        turnoDaoSinBD.crear(turno0);
//    }
//}
