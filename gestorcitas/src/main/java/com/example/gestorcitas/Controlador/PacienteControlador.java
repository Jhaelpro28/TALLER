package com.example.gestorcitas.Controlador;
 import com.example.gestorcitas.service.PacienteService;
 import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller 
public class PacienteControlador {
    private final PacienteService pacienteService;

    public PacienteControlador(PacienteService pacienteService){
     this.pacienteService = pacienteService;

    }
    //Le pide los pacientes al service y se los entrega a la plantilla html con el nombre de pacientes 
  // le dice al spring cual plantilla mostrar 
    
  @GetMapping("/pacientes")
  public String listar(Model model){
    model.addAttribute("paciente", pacienteService.listar());
    return "pacientes/lista";
  }
    



}
