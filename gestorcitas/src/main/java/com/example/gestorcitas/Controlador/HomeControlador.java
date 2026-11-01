package com.example.gestorcitas.Controlador;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;


@Controller
public class HomeControlador {
    @GetMapping("/")
    public String inicio(){
        return "index";
    }

}
