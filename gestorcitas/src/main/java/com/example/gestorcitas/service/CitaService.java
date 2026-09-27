package com.example.gestorcitas.service;
import com.example.gestorcitas.Modelo.Cita;
import com.example.gestorcitas.Modelo.Doctor;
import com.example.gestorcitas.Modelo.EstadoCita;
import com.example.gestorcitas.Modelo.Paciente;
 import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service 
public class CitaService {
    private List<Cita> citas = new ArrayList<>();

     public CitaService(PacienteService pacienteService, DoctorService doctorService) {
    Paciente Carolina = pacienteService.buscarPorId(1L);
    Paciente Jhael = pacienteService.buscarPorId(2L);
     Doctor Andrea = doctorService.buscarPorId(1L);
     Doctor Sergio = doctorService.buscarPorId(2L);

    citas.add(new Cita(1L, Carolina, Andrea, LocalDateTime.of(2026, 10, 5, 9, 0), EstadoCita.PENDIENTE));
    citas.add(new Cita(2L, Jhael, Sergio, LocalDateTime.of(2026, 10, 6, 10, 30), EstadoCita.PENDIENTE));
    }


   public List<Cita> listar() {
        return citas;
    }


    public Cita buscarPorId(Long id) {
     for (Cita c : citas) {
       if (c.getId().equals(id)) {
        return c;}
    }
        return null;
    }
}

