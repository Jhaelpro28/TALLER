package com.example.gestorcitas.service;
import com.example.gestorcitas.Modelo.Paciente;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;;

@Service 
public class PacienteService {
    private List<Paciente> pacientes = new ArrayList<>();
    
//Recuerda que el identificador lo puse como tipo long, cuando busque se supone que se inicia asi,
//  donde dice 1L y 2L, esos serian los id de los pacientes
    public PacienteService(){
        pacientes.add(new Paciente(1L, "Carolina Cohen", "104256783", "3236780901"));
        pacientes.add(new Paciente(2L, "Jhael Perez", "12344567", "32145678"));
    }

    //el metodo devuelve la lista de todos los pacientes 
    public List<Paciente> listar(){
        return pacientes;
    }
    
    //este para buscar por id
    public Paciente buscarPorId(Long id) {
        for(Paciente p : pacientes){
            if(p.getId() .equals(id)){
                return p;
            }
        } return null;
    }
}
