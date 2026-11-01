package com.example.gestorcitas.Repositorio;
import com.example.gestorcitas.Modelo.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    
}
