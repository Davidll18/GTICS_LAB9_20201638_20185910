package com.example.lab9.controller;

import com.example.lab9.entity.Equipo;
import com.example.lab9.repository.EquipoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/SDCI")
public class EquipoController {
    final EquipoRepository equipoRepository;

    public EquipoController(EquipoRepository equipoRepository) {
        this.equipoRepository = equipoRepository;
    }

    @GetMapping(value = {"/EQUIPO"})
    public List<Equipo> listaEquipo() {
        return equipoRepository.findAll();
    }



}
