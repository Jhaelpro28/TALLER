    package com.example.gestorcitas.Controlador;
    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.gestorcitas.Modelo.Doctor;
    import com.example.gestorcitas.service.DoctorService;



    @Controller 
    public class DoctorControlador {
        private final DoctorService doctorService;

        public DoctorControlador(DoctorService doctorService){
            this.doctorService = doctorService;
        }

        //lo mismo que use para lo del controlador del paciente
        @GetMapping("/doctores")
        public String listar(Model model) {
        model.addAttribute("doctores", doctorService.listar());
        return "doctores/lista";
        }
        @GetMapping("/doctores/nuevo")
        public String formulario(Model model){
            model.addAttribute("doctor", new Doctor());
            return "doctores/formulario";
        }
        @PostMapping("/doctores")
        public String guardar(@ModelAttribute Doctor doctor){
            doctorService.guardar(doctor);
            return "redirect:/doctores";
        }

        
    }
