package com.example.ClinicaDentalS.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

@Entity
@Table(name ="turnos")

public class Turno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false) // (cascade = CascadeType.ALL) // el cascada quiere decir, todo lo que yo agregue en paciente se agrega en docimicio y si quiero eliminar un paciente eliminno el domicilio
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "odontologo_id", nullable = false) // (cascade = CascadeType.ALL) // el cascada quiere decir, todo lo que yo agregue en paciente se agrega en docimicio y si quiero eliminar un paciente eliminno el domicilio
    private Odontologo odontologo;
    @Column
    private LocalDate fechaTurno;
    @Column
    private LocalTime horaTurno;

    public Turno() {
    }

    public Turno(Paciente paciente, Odontologo odontologo, LocalDate fechaTurno, LocalTime horaTurno) {
        this.paciente = paciente;
        this.odontologo = odontologo;
        this.fechaTurno = fechaTurno;
        this.horaTurno = horaTurno;
    }

    public Turno(Long id, Paciente paciente, Odontologo odontologo, LocalDate fechaTurno, LocalTime horaTurno) {
        this.id = id;
        this.paciente = paciente;
        this.odontologo = odontologo;
        this.fechaTurno = fechaTurno;
        this.horaTurno = horaTurno;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
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
}


