package com.example.lab9.controller;

import com.example.lab9.entity.Deporte;
import com.example.lab9.repository.DeporteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("sdci/deporte")
public class DeporteController {
    final DeporteRepository deporteRepository;

    public DeporteController(DeporteRepository deporteRepository) {
        this.deporteRepository = deporteRepository;
    }

    @PostMapping("/registro")
    public ResponseEntity<HashMap<String, Object>> registrarDeporte(
            @RequestBody Deporte deporte,
            @RequestParam(value = "fetchId", required = false) boolean fetchId) {

        HashMap<String, Object> responseJson = new HashMap<>();

        try {
            deporteRepository.save(deporte);
            responseJson.put("estado", "creado");
            if (fetchId) {
                responseJson.put("id", deporte.getId());
            }
            return ResponseEntity.ok(responseJson);
        } catch (Exception e) {
            responseJson.put("error", "Error al registrar");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseJson);
        }
    }
}
