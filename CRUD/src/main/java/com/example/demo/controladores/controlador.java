package com.example.demo.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.bean.Usuario;

import org.springframework.ui.Model;

@Controller
@RequestMapping("")
public class controlador {

	@GetMapping("/")
	public String iniciar(Model model) {
		// Importante al importar la libreria import org.springframework.ui.Model;
		model.addAttribute("titulo", "FORMULARIO DE ACCESO");
		return "login";
	}

	@PostMapping("/")
	public String login(Usuario usuario, Model model) {
		if (usuario.getNombre().equals("edu") && usuario.getPassword().equals("edu")) {
			model.addAttribute("usuario", usuario);
			return "consulta";
		} else
			return "login";

	}
}
