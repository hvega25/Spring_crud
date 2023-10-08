package com.example.demo.controladores;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.bean.Libro;
import com.example.demo.bean.Usuario;
import com.example.demo.repository.BaseDatos;

import org.springframework.ui.Model;

@Controller
@RequestMapping("")
public class controlador {
	
	BaseDatos bd = new BaseDatos();

	@GetMapping("/")
	public String iniciar(Model model) {
		// Importante al importar la libreria import org.springframework.ui.Model;
		model.addAttribute("titulo", "FORMULARIO DE ACCESO");
		return "login";
	}

	@PostMapping("/")
	public String login(Usuario usuario, Model model, @RequestParam String nombre, @RequestParam String password) {
		if (usuario.getNombre().equals("edu") && usuario.getPassword().equals("edu")) {
			ArrayList<Libro> libros = bd.getLibros();
			model.addAttribute("usuario", usuario);
			model.addAttribute("libros", libros);
			return "consulta";
		} else
			return "login";

	}
}
