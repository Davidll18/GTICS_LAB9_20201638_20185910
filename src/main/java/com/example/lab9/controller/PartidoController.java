package com.example.lab9.controller;
import com.example.lab9.entity.Partido;
import com.example.lab9.repository.PartidoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Optional;

@RestController
@RequestMapping("/partido")
public class PartidoController {

    final PartidoRepository partidoRepository;

    public PartidoController( PartidoRepository partidoRepository) {
        this.partidoRepository = partidoRepository;
    }

    @PostMapping("/registro")
    public ResponseEntity<HashMap<String, Object>> registrarPartido(
            @RequestBody Partido partido,
            @RequestParam(value = "fetchId", required = false) boolean fetchId) {

        HashMap<String, Object> responseJson = new HashMap<>();


        partidoRepository.save(partido);
        if (fetchId) {
            responseJson.put("id", partido.getId());
        }
        responseJson.put("estado", "creado");

        return ResponseEntity.status(HttpStatus.CREATED).body(responseJson);
    }


    @GetMapping(value = "/gethistorialpartidos")
    public ResponseEntity<HashMap<String, Object>> buscarPartido(@PathVariable("id") String idStr) {

        HashMap<String, Object> partido = new HashMap<>();

            HashMap<String, Object> respuesta2 = new HashMap<>();
            try {
                int id = Integer.parseInt(idStr);
                Optional<Partido> lista = partidoRepository.findById(id);

                HashMap<String, Object> respuesta = new HashMap<>();

                if (lista.isPresent()) {
                    respuesta.put("result", "ok");
                    respuesta.put("producto", lista.get());
                } else {
                    respuesta.put("result", "no existe");
                }
                return ResponseEntity.ok(respuesta);

            } catch (NumberFormatException e) {
                respuesta2.put("result", "error");
                respuesta2.put("msg", "El ID es incorrecto");
                return ResponseEntity.badRequest().body(respuesta2);
            }

    }


}
