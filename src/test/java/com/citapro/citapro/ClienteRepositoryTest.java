package com.citapro.citapro;

import com.citapro.citapro.model.Cliente;
import com.citapro.citapro.repository.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ClienteRepositoryTest {

    @Autowired
    private ClienteRepository clienteRepository;

    @Test
    void testGuardarCliente() {
        Cliente cliente = new Cliente();
        cliente.setNombre("Test");
        cliente.setEmail("test@email.com");
        cliente.setTelefono("123456");

        Cliente guardado = clienteRepository.save(cliente);

        assertThat(guardado.getId()).isNotNull();
    }

    @Test
    void testBuscarClientes() {
        Cliente cliente = new Cliente();
        cliente.setNombre("Otro");
        cliente.setEmail("otro@email.com");
        cliente.setTelefono("999");

        clienteRepository.save(cliente);

        assertThat(clienteRepository.findAll()).isNotEmpty();
    }
}