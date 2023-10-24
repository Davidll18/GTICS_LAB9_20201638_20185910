package com.example.lab9.controller;
import com.example.lab9.entity.Participante;
import com.example.lab9.repository.ParticipanteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("sdci/participante")
public class ParticipanteController {
    final ParticipanteRepository participanteRepository;

    public ParticipanteController(ParticipanteRepository participanteRepository) {
        this.participanteRepository = participanteRepository;
    }
    @PostMapping("/registro")
    public ResponseEntity<HashMap<String, Object>> registrarDeporte(
            @RequestBody Participante participante,
            @RequestParam(value = "fetchId", required = false) boolean fetchId) {
        HashMap<String, Object> responseJson = new HashMap<>();

        try {
            participanteRepository.save(participante);
            responseJson.put("estado", "creado");
            if (fetchId) {
                responseJson.put("id", participante.getId());
            }
            return ResponseEntity.ok(responseJson);
        } catch (Exception e) {
            responseJson.put("error", "Error al registrar");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseJson);
        }
    }

}
