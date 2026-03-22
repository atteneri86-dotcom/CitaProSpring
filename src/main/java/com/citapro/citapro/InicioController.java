package com.citapro.citapro;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InicioController {

    public String mostrarFormulario() {
        return "formulario-cliente";
    }
}