package com.servientrega.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.servientrega.app.entity.Paquete;
import com.servientrega.app.repository.PaqueteRepository;

import java.util.List;

@Controller
public class PaqueteController {

    @Autowired
    private PaqueteRepository paqueteRepository;

    @GetMapping("/gestion-paquetes")
    public String getAllPaquetes(Model model) {
        List<Paquete> paquetes = paqueteRepository.findAll();
        model.addAttribute("paquetes", paquetes);
        return "gestion-paquetes"; 
    }

    @GetMapping("/{id}")
    public Paquete getPaquete(@PathVariable Long id) {
        return paqueteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paquete no encontrado con id: " + id));
    }

    @PostMapping(value = "/paquetes/crear", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String crearPaquete(@ModelAttribute Paquete paquete, RedirectAttributes redirectAttributes) {
        paqueteRepository.save(paquete);
        redirectAttributes.addFlashAttribute("message", "Paquete creado exitosamente");
        return "redirect:/gestion-paquetes";
    }

    @PutMapping("/editar-paquete/{id}")
    public Paquete actualizarPaquete(@RequestBody Paquete nuevoPaquete, @PathVariable Long id) {
        return paqueteRepository.findById(id)
                .map(paquete -> {
                    paquete.setDescripcion(nuevoPaquete.getDescripcion());
                    paquete.setDestino(nuevoPaquete.getDestino());
                    paquete.setEstado(nuevoPaquete.getEstado());
                    paquete.setCliente(nuevoPaquete.getCliente());
                    return paqueteRepository.save(paquete);
                })
                .orElseGet(() -> {
                    nuevoPaquete.setId(id);
                    return paqueteRepository.save(nuevoPaquete);
                });
    }

    @DeleteMapping("/eliminar-paquete/{id}")
    public void borrarPaquete(@PathVariable Long id) {
        paqueteRepository.deleteById(id);
    }
}
