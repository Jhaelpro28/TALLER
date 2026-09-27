package com.example.gestorcitas.service;

import com.example.gestorcitas.Modelo.Doctor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service 
public class DoctorService {
     private List<Doctor> doctores = new ArrayList<>();

    public DoctorService() {
        doctores.add(new Doctor(1L, "Dra. Andrea Rios", "Medicina General"));
        doctores.add(new Doctor(2L, "Dr. Sergio gomez", "Cirujano"));
    }

//Mismo metodo que utilice en pacientes
    public List<Doctor> listar() {
        return doctores;
    }

    public Doctor buscarPorId(Long id) {
        for (Doctor d : doctores) {
            if (d.getId().equals(id)) {
                return d;
            }
        }
        return null;
    }
}

    

