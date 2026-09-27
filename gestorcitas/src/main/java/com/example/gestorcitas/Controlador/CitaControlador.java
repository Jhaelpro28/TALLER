package com.example.gestorcitas.Controlador;
import com.example.gestorcitas.Modelo.Cita;
import com.example.gestorcitas.service.CitaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller 
public class CitaControlador {
    private final CitaService citaService;

    public CitaControlador(CitaService citaService) {
        this.citaService = citaService;
    }

    @GetMapping("/citas")
    public String listar(Model model) {
        model.addAttribute("citas", citaService.listar());
        return "citas/lista";
    }
 
    @GetMapping("/citas/{id}")
    public String detalle(@PathVariable Long id, Model model) {
        Cita cita = citaService.buscarPorId(id);
        model.addAttribute("cita", cita);
        return "citas/detalle";}

        //Los dos ultimos metodos los use para que devuevan los datos en formato
        // JSON, para que cualquier progrmama pueda consultarlos y no solo thymeleaf
        @GetMapping("/api/citas")
        @ResponseBody 
        public List<Cita> listarJson(){
            return citaService.listar();
        }

      @GetMapping("/api/citas/{id}")
      @ResponseBody
     public Cita obtenerJson(@PathVariable Long id) {
        return citaService.buscarPorId(id);
    }

}