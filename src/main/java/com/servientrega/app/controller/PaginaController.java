package com.servientrega.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PaginaController {

	@GetMapping("/cliente")
	public String mostrarPaginaClientes() {
		return "cliente";
	}

	@GetMapping("/administrador")
	public String mostrarPaginaAdministradores() {
		return "administrador";
	}

	@GetMapping("/gestion-clientes")
	public String mostrarPaginaGestionClientes() {
		return "gestion-clientes";
	}
/*
	@GetMapping("/gestion-paquetes")
	public String mostrarPaginaGestionPaquete() {
		return "gestion-paquetes";
	}*/

	@GetMapping("/agregar-paquete")
	public String mostrarPaginaCrearPaquete() {
		return "agregar-paquete";
	}
	@GetMapping("/agregar-cliente")
	public String mostrarPaginaCrearCliente() {
		return "agregar-cliente";
	}

	@GetMapping("/gestionar-clientes")
	public String mostrarPaginaGestionarCliente() {
		return "gestionar-clientes";
	}
}
