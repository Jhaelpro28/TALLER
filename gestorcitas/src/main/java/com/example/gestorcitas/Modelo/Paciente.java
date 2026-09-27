package com.example.gestorcitas.Modelo;

public class Paciente {
    private Long id;
    private String nombre;
    private String documento;
    private String telefono;


    public Paciente(Long id, String nombre, String documento, String telefono) {
       this.id = id;
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
