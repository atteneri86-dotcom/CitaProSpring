package com.citapro.citapro.controller;

import com.citapro.citapro.model.Cliente;
import com.citapro.citapro.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ClienteWebController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/formulario-cliente")
    public String mostrarFormulario(Model model) {
        model.addAttribute("cliente", new Cliente());
        model.addAttribute("listaClientes", clienteRepository.findAll());
        return "formulario-cliente";
    }

    @PostMapping("/guardar-cliente")
    public String guardarCliente(Cliente cliente) {
        clienteRepository.save(cliente);
        return "redirect:/formulario-cliente";
    }

    @GetMapping("/eliminar-cliente/{id}")
    public String eliminarCliente(@PathVariable Long id) {
        clienteRepository.deleteById(id);
        return "redirect:/formulario-cliente";
    }
}