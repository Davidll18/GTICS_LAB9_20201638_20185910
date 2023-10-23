package com.example.lab9.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "participante")
@Getter
@Setter
public class Participante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idparticipante", nullable = false)
    private Integer id;

    @Column(name = "Equipo")
    private Integer equipo;

    @Column(name = "Carrera")
    private String carrera;

    @Column(name = "Codigo")
    private String codigo;

    @Column(name = "TipoParticipante")
    private String tipo;
}
