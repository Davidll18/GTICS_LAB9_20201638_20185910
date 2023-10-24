package com.example.lab9.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
@Getter
@Setter
@Entity
@Table(name = "historialpartidos")
@JsonIgnoreProperties(value = {"horaFecha"})
public class HistorialPartido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idhistorialPartidos", nullable = false)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "partido_idpartido", nullable = false)
    private Partido partidoIdpartido;

    @ManyToOne(optional = false)
    @JoinColumn(name = "deporte_iddeporte", nullable = false)
    private Deporte deporteIddeporte;

    @Column(name = "horaFecha", nullable = false)
    private Instant horaFecha;
}
