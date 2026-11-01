package com.example.gestorcitas.Modelo;

import jakarta.persistence.*;


@Entity 
public class Paciente {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100)
    private String nombre;
    @Column(nullable = false, unique = true, length=20)
    private String documento;
    private String telefono;


    public Paciente(){}
    public Paciente(String nombre, String documento, String telefono) {
       this.nombre = nombre;
       this.documento = documento;
       this.telefono = telefono;
       
    }

 //Getter y setter de las variables, 
    public Long getId(){ return id;}
    public void serId(Long id){this.id = id;}

    public String getNombre(){ return nombre;}
    public void setNombre(String nombre){this.nombre = nombre;}

    public String getDocumento(){ return documento;}
    public void setDocumento(String documento){this.documento = documento;}

    public String getTelefono(){ return telefono;}
    public void setTelefono(String telefono){this.telefono = telefono;}
    
    
}
