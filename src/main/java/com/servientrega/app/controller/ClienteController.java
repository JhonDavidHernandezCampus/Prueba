package com.servientrega.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.servientrega.app.entity.Cliente;
import com.servientrega.app.repository.ClienteRepository;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/")
    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    @GetMapping("/{id}")
    public Cliente getCliente(@PathVariable Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado con id: " + id));
    }

    @PostMapping("/crear")
    public Cliente crearCliente(@RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @PutMapping("/{id}")
    public Cliente actualizarCliente(@RequestBody Cliente nuevoCliente, @PathVariable Long id) {
        return clienteRepository.findById(id)
                .map(cliente -> {
                    cliente.setNombre(nuevoCliente.getNombre());
                    cliente.setEmail(nuevoCliente.getEmail());
                    cliente.setDireccion(nuevoCliente.getDireccion());
                    cliente.setTelefono(nuevoCliente.getTelefono());
                    return clienteRepository.save(cliente);
                })
                .orElseGet(() -> {
                    nuevoCliente.setId(id);
                    return clienteRepository.save(nuevoCliente);
                });
    }

    @DeleteMapping("/{id}")
    public void borrarCliente(@PathVariable Long id) {
        clienteRepository.deleteById(id);
    }
}
