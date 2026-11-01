package com.example.gestorcitas.Controlador;
 import com.example.gestorcitas.Repositorio.PacienteRepository;
 import com.example.gestorcitas.service.PacienteService;
 import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.gestorcitas.Modelo.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ModelAttribute;


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
    model.addAttribute("pacientes", pacienteService.listar());
    return "pacientes/lista";
  }
  @GetMapping("/pacientes/nuevo")
  public String formulario(Model model){
    model.addAttribute("paciente", new Paciente());
    return "pacientes/formulario";
  }
  @PostMapping("/pacientes")
  public String guardar(@ModelAttribute Paciente paciente){
    pacienteService.guardar(paciente);
    return "redirect:/pacientes";
  }
  
    



}
