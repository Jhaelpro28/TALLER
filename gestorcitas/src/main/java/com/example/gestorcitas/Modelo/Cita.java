package com.example.gestorcitas.Modelo;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;


@Entity 
public class Cita {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Paciente paciente;

    @ManyToOne 
    private Doctor doctor;
    
    private LocalDateTime fechaHora;
    

    @Enumerated(EnumType.STRING)
    private EstadoCita estado;

    public Cita(){}
    
    public Cita(Paciente paciente, Doctor doctor, LocalDateTime fechaHora, EstadoCita estado){
        this.paciente = paciente;
        this.doctor = doctor;
        this.fechaHora = fechaHora;
       this.estado = estado;
 }
    
      public Long getId(){return id;}
      public void setId(Long id){this.id = id;}

      public Paciente getPaciente(){return paciente;}
      public void setPaciente(Paciente paciente){this.paciente = paciente;}
    
      public Doctor getDoctor(){return doctor;}
      public void setDoctor(Doctor doctor){this.doctor = doctor;}

      public LocalDateTime getFechaHora(){return fechaHora;}
      public void setFechaHora(LocalDateTime fechaHora) {this.fechaHora = fechaHora;}

      public EstadoCita getEstado(){return estado;}
      public void setEstado(EstadoCita estado){this.estado = estado;}

      


}
