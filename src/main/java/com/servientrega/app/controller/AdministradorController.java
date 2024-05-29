package com.servientrega.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.servientrega.app.entity.Administrador;
import com.servientrega.app.repository.AdministradorRepository;

@RestController
@RequestMapping("/administradores")
public class AdministradorController {

    @Autowired
    private AdministradorRepository administradorRepository;

    @GetMapping("/{id}")
    public Administrador getAdministrador(@PathVariable Long id) {
        return administradorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Administrador no encontrado con id: " + id));
    }

    @PostMapping("/crear")
    public Administrador crearAdministrador(@RequestBody Administrador administrador) {
        return administradorRepository.save(administrador);
    }

    @PutMapping("/{id}")
    public Administrador actualizarAdministrador(@RequestBody Administrador nuevoAdministrador, @PathVariable Long id) {
        return administradorRepository.findById(id)
                .map(administrador -> {
                    administrador.setNombre(nuevoAdministrador.getNombre());
                    administrador.setEmail(nuevoAdministrador.getEmail());
                    administrador.setPassword(nuevoAdministrador.getPassword());
                    return administradorRepository.save(administrador);
                })
                .orElseGet(() -> {
                    nuevoAdministrador.setId(id);
                    return administradorRepository.save(nuevoAdministrador);
                });
    }

    @DeleteMapping("/{id}")
    public void borrarAdministrador(@PathVariable Long id) {
        administradorRepository.deleteById(id);
    }
}
