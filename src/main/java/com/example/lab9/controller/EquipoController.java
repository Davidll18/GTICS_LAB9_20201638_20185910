package com.example.lab9.controller;

import com.example.lab9.entity.Equipo;
import com.example.lab9.repository.EquipoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("sdci/equipo")
public class EquipoController {
    final EquipoRepository equipoRepository;

    public EquipoController(EquipoRepository equipoRepository) {
        this.equipoRepository = equipoRepository;
    }

    @GetMapping(value = {"/listar"})
    public List<Equipo> listaEquipo() {
        return equipoRepository.findAll();
    }
    // Registrar equipo
    @PostMapping("/registro")
    public ResponseEntity<HashMap<String, Object>> registrar(
            @RequestBody Equipo equipo,
            @RequestParam(value = "fetchId", required = false) boolean fetchId){
        HashMap<String, Object> responseJson = new HashMap<>();

        try {
            equipoRepository.save(equipo);
            responseJson.put("estado", "creado");
            if (fetchId) {
                responseJson.put("id", equipo.getId());
            }
            return ResponseEntity.ok(responseJson); // 200 OK en caso de éxito
        } catch (Exception e) {
            responseJson.put("error", "Error al registrar el equipo");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseJson); // Código de error en caso de fallo
        }
    }

}
