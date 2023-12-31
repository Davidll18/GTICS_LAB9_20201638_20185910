package com.example.lab9.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "equipo")
@Getter
@Setter
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idequipo", nullable = false)
    private Integer id;

    @Column(name = "nombreEquipo")
    private String nombreEquipo;

    @Column(name = "colorEquipo")
    private String colorEquipo;

    @Column(name = "mascota")
    private String mascota;
}
