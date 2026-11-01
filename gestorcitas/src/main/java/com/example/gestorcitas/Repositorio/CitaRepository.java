package com.example.gestorcitas.Repositorio;
import java.time.LocalDateTime;
import java.util.List;

import com.example.gestorcitas.Modelo.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CitaRepository extends JpaRepository<Cita, Long> {
    @Query("SELECT c FROM Cita c WHERE c.fechaHora BETWEEN :desde AND :hasta ORDER BY c.fechaHora")
    List<Cita> buscarEntreFechas(@Param("desde") LocalDateTime desde,
                                @Param("hasta") LocalDateTime hasta);   
}
