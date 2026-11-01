package com.example.gestorcitas.Repositorio;
import com.example.gestorcitas.Modelo.*;
import org.springframework.data.jpa.repository.JpaRepository;
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    
    
}
