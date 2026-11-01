package com.example.gestorcitas.service;
import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.gestorcitas.Modelo.Cita;
import com.example.gestorcitas.Modelo.Doctor;
import com.example.gestorcitas.Modelo.EstadoCita;
import com.example.gestorcitas.Modelo.Paciente;
import com.example.gestorcitas.Repositorio.CitaRepository;
import com.example.gestorcitas.Repositorio.DoctorRepository;
import com.example.gestorcitas.Repositorio.PacienteRepository;



@Configuration
public class DataLoader {
    

    @Bean
    CommandLineRunner cargarDatos(PacienteRepository pacientes, DoctorRepository doctor, CitaRepository citas){
        

        return args ->{
            if(pacientes.count()>0) return;
            
            Paciente carolina = pacientes.save(new Paciente("Carolina Cohen", "10002", "3046822041"));
            Paciente jhael = pacientes.save(new Paciente("Jhael Marin","10001","3044069247"));
            Doctor luis = doctor.save(new Doctor("Dr. Luis Agamez", "Neurocirujano"));
            Doctor yiceth = doctor.save(new Doctor("Dra. Yiceth Ortega", "Medicina General"));

            citas.save(new Cita(carolina, luis, LocalDateTime.of(2026, 10, 5, 9, 0), EstadoCita.PENDIENTE));
            citas.save(new Cita(jhael, yiceth, LocalDateTime.of(2026, 10, 6, 10, 30), EstadoCita.PENDIENTE));
        };
    }
    }

