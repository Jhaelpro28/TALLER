package com.example.gestorcitas.Modelo;
import java.time.LocalDateTime;

public class Cita {
    private Long id;
    private Paciente paciente;
    private Doctor doctor;
    private LocalDateTime fechaHora;
    private EstadoCita estado;


    public Cita(Long id, Paciente paciente, Doctor doctor, LocalDateTime fechaHora, EstadoCita estado){
        this.id =id;
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
