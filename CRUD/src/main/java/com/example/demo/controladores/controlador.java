package com.example.demo.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class controlador {

	
	@GetMapping("/")
	public String iniciar() {
		return "login";		
	}
	
	@PostMapping("/")
	public String login(){
		return "consultar";
	}
}
