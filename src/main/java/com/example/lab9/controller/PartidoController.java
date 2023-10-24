package com.example.lab9.controller;
import com.example.lab9.entity.HistorialPartido;
import com.example.lab9.entity.Participante;
import com.example.lab9.entity.Partido;
import com.example.lab9.repository.ParticipanteRepository;
import com.example.lab9.repository.PartidoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("sdci/partido")
public class PartidoController {

    final PartidoRepository partidoRepository;

    final ParticipanteRepository participanteRepository;


    public PartidoController(PartidoRepository partidoRepository, ParticipanteRepository participanteRepository) {
        this.partidoRepository = partidoRepository;
        this.participanteRepository = participanteRepository;
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

    @GetMapping(value = {"/getparticipantes"})
    public List<Participante> listaPartido() {
        return participanteRepository.findAll();
    }

    @GetMapping(value = "/gethistorialpartidos")
    public  ResponseEntity<HashMap<String, Object>> buscarProducto(@PathVariable("id") String idStr) {
            HashMap<String, Object> respuesta = new HashMap<>();
            try {
                int id = Integer.parseInt(idStr);
                Optional<Partido> lista = partidoRepository.findById(id);



                if (lista.isPresent()) {
                    respuesta.put("result", "ok");
                    respuesta.put("producto", lista.get());
                } else {
                    respuesta.put("result", "no existe");
                }
                return ResponseEntity.ok(respuesta);
            } catch (NumberFormatException e) {
                respuesta.put("result", "error");

                return ResponseEntity.badRequest().body(respuesta);
            }

    }




}
