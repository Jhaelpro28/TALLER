package com.example.gestorcitas.Controlador;

import com.example.gestorcitas.Modelo.Cita;
import com.example.gestorcitas.service.CitaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/citas")
public class CitaRestControlador {
    private final CitaService citaService;

    public CitaRestControlador(CitaService citaService) {
        this.citaService = citaService;
    }

    @GetMapping
    public List<Cita> listar() {
        return citaService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cita> obtener(@PathVariable Long id) {
        Cita cita = citaService.buscarPorId(id);
        return cita != null ? ResponseEntity.ok(cita) : ResponseEntity.notFound().build();
    }
}