package com.example.gestorcitas.Controlador;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.gestorcitas.Modelo.Cita;
import com.example.gestorcitas.Modelo.Doctor;
import com.example.gestorcitas.Modelo.EstadoCita;
import com.example.gestorcitas.Modelo.Paciente;
import com.example.gestorcitas.service.CitaService;
import com.example.gestorcitas.service.DoctorService;
import com.example.gestorcitas.service.PacienteService;

@Controller 
@RequestMapping("/citas")
public class CitaControlador {
   private final CitaService citaService;
   private final PacienteService pacienteService;
   private final DoctorService doctorService;

   public CitaControlador(CitaService citaService, PacienteService pacienteService,
    DoctorService doctorService
   ){
        this.citaService = citaService;
        this.pacienteService = pacienteService;
        this.doctorService = doctorService;
   }
   @GetMapping()
   public String listar(Model model){
    model.addAttribute("citas", citaService.listar());
    return "citas/lista";
   }
   @GetMapping("/nueva")
   public String formulario(Model model){
      model.addAttribute("pacientes", pacienteService.listar());
      model.addAttribute("doctores", doctorService.listar());
      return "citas/formulario";
   }
   @PostMapping
   public String guardar(@RequestParam Long pacienteId, @RequestParam Long doctorId, @RequestParam @DateTimeFormat (iso=DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaHora){
      Paciente paciente = pacienteService.buscarPorId(pacienteId);
      Doctor doctor = doctorService.buscarPorId(doctorId);
      citaService.guardar(new Cita(paciente, doctor, fechaHora, EstadoCita.PENDIENTE));
      return "redirect:/citas";
   }

   @GetMapping("/{id}")
   public String detalle(@PathVariable Long id, Model model){
      model.addAttribute("cita", citaService.buscarPorId(id));
      return "citas/detalle";
   }
   @PostMapping("/{id}/estado")
   public String cambiarEstado(@PathVariable Long id, @RequestParam EstadoCita estado){
      citaService.cambiarEstado(id, estado);
      return "redirect:/citas";
   }
   @GetMapping("/api/citas")
   @ResponseBody 
   public List<Cita> listarJson(){
      return citaService.listar();
   }
   @GetMapping("/api/citas/{id}")
   @ResponseBody 
   public ResponseEntity<Cita> obtenerJson(@PathVariable Long id){
      Cita cita = citaService.buscarPorId(id);
      return cita !=null ? ResponseEntity.ok(cita) : ResponseEntity.notFound().build();
   }
}