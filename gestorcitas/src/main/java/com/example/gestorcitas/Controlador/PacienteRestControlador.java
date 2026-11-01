package com.example.gestorcitas.Controlador;
import com.example.gestorcitas.service.*;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import com.example.gestorcitas.Modelo.*;

@RestController 
@RequestMapping("/api/pacientes")
public class PacienteRestControlador {
    private final PacienteService pacienteService;

    public PacienteRestControlador(PacienteService pacienteService){
        this.pacienteService = pacienteService;
    }
    @GetMapping
    public List<Paciente> listar(){
        return pacienteService.listar();
    }
    @PostMapping
    public Paciente crear(@RequestBody Paciente paciente){
        return pacienteService.guardar(paciente);
    }

}
