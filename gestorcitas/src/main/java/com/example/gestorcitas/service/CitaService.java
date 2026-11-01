package com.example.gestorcitas.service;
import com.example.gestorcitas.Modelo.Cita;
import com.example.gestorcitas.Modelo.Doctor;
import com.example.gestorcitas.Modelo.EstadoCita;
import com.example.gestorcitas.Modelo.Paciente;
import com.example.gestorcitas.Repositorio.*;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

 
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Service 
public class CitaService {
    
    private final CitaRepository citaRepository;

    
    public CitaService(CitaRepository citaRepository){
        this.citaRepository = citaRepository;
    }
    @Transactional(readOnly = true)
    public List<Cita> listar(){
        return citaRepository.findAll();
    }
    public Cita buscarPorId(Long id){
        return citaRepository.findById(id).orElse(null);
    }
    @Transactional
    public Cita guardar(Cita cita){
        return citaRepository.save(cita);
    }
    @Transactional
    public void cambiarEstado(Long id, EstadoCita estado){
        Cita cita = buscarPorId(id);
        if(cita != null){
            cita.setEstado(estado);
            citaRepository.save(cita);
        }
    }
}

