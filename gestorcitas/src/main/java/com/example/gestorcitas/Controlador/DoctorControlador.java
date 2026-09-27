    package com.example.gestorcitas.Controlador;
    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.web.bind.annotation.GetMapping;

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
        

        
    }
