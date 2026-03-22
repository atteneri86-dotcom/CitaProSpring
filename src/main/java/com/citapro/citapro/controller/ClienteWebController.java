package com.citapro.citapro.controller;

import com.citapro.citapro.model.Cliente;
import com.citapro.citapro.repository.ClienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class ClienteWebController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/formulario-cliente")
    public String mostrarFormulario(Model model) {
        model.addAttribute("cliente", new Cliente());
        model.addAttribute("clientes", clienteRepository.findAll());
        return "formulario-cliente";
    }

    @PostMapping("/guardar-cliente")
    public String guardarCliente(@Valid @ModelAttribute("cliente") Cliente cliente,
                                 BindingResult result,
                                 Model model) {

        if (result.hasErrors()) {
            model.addAttribute("clientes", clienteRepository.findAll());
            return "formulario-cliente";
        }

        clienteRepository.save(cliente);
        return "redirect:/formulario-cliente";
    }

    @GetMapping("/editar-cliente/{id}")
    public String editarCliente(@PathVariable Long id, Model model) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow();
        model.addAttribute("cliente", cliente);
        model.addAttribute("clientes", clienteRepository.findAll());
        return "formulario-cliente";
    }

    @GetMapping("/borrar-cliente/{id}")
    public String borrarCliente(@PathVariable Long id) {
        clienteRepository.deleteById(id);
        return "redirect:/formulario-cliente";
    }
}