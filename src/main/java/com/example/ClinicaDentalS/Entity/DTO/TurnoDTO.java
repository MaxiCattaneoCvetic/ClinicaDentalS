package com.example.ClinicaDentalS.Entity.DTO;

import com.example.ClinicaDentalS.Entity.Odontologo;
import com.example.ClinicaDentalS.Entity.Paciente;

import java.time.LocalDate;
import java.time.LocalTime;


public class TurnoDTO {

    private Long id;

    private Paciente paciente;

    private Odontologo odontologo;

    private LocalDate fechaTurno;

    private LocalTime horaTurno;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Odontologo getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(Odontologo odontologo) {
        this.odontologo = odontologo;
    }

    public LocalDate getFechaTurno() {
        return fechaTurno;
    }

    public void setFechaTurno(LocalDate fechaTurno) {
        this.fechaTurno = fechaTurno;
    }

    public LocalTime getHoraTurno() {
        return horaTurno;
    }

    public void setHoraTurno(LocalTime horaTurno) {
        this.horaTurno = horaTurno;
    }

    public TurnoDTO() {
    }

    public TurnoDTO(Paciente paciente, Odontologo odontologo, LocalDate fechaTurno, LocalTime horaTurno) {
        this.paciente = paciente;
        this.odontologo = odontologo;
        this.fechaTurno = fechaTurno;
        this.horaTurno = horaTurno;
    }

    public TurnoDTO(Long id, Paciente paciente, Odontologo odontologo, LocalDate fechaTurno, LocalTime horaTurno) {
        this.id = id;
        this.paciente = paciente;
        this.odontologo = odontologo;
        this.fechaTurno = fechaTurno;
        this.horaTurno = horaTurno;
    }
}
