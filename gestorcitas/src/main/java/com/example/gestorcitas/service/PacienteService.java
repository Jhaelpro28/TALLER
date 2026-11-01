package com.example.gestorcitas.service;
import com.example.gestorcitas.Modelo.Paciente;
import com.example.gestorcitas.Repositorio.PacienteRepository;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;;

@Service 
public class PacienteService {
    public final PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository){
        this.pacienteRepository = pacienteRepository;

    }
    public List<Paciente> listar(){
        return pacienteRepository.findAll();
    }
    public Paciente buscarPorId(Long id){
        return pacienteRepository.findById(id).orElse(null);
    }
    public Paciente guardar(Paciente paciente){
        return pacienteRepository.save(paciente);
    }
}
