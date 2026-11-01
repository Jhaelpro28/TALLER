package com.example.gestorcitas.service;

import com.example.gestorcitas.Modelo.Doctor;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import com.example.gestorcitas.Repositorio.DoctorRepository;

@Service 
public class DoctorService {
    public final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository){
        this.doctorRepository = doctorRepository;
    }

    public List<Doctor> listar(){
        return doctorRepository.findAll();
    }
    public Doctor buscarPorId(Long id){
        return doctorRepository.findById(id).orElse(null);
    }
    public Doctor guardar(Doctor doctor){
        return doctorRepository.save(doctor);
    }
}

    

