package com.example.lab9.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.text.DecimalFormat;

@Entity
@Table(name = "participante")
@Getter
@Setter
public class Participante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idparticipante", nullable = false)
    private Integer id;

    @Column(name = "equipo")
    private Integer equipo;

    @Column(name = "carrera")
    private String carrera;

    @Column(name = "codigo")
    private Double  codigo;

    @Column(name = "TipoParticipante")
    private String tipoParticipante;
}
