package com.example.demo.controladores;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.bean.Libro;
import com.example.demo.bean.Usuario;
import com.example.demo.repository.BaseDatos;
import com.example.demo.repository.BaseDatos2;
import com.example.demo.repository.BaseDatos3;
import com.example.demo.repository.BaseDatos3Service;

import org.springframework.ui.Model;

@Controller
@RequestMapping("")

public class controlador {

	/*
	 * puertos usados para conexiones springboot = 8090 xampp = localhost 8080:3306
	 */

	// conexion a la base de datos con arraylist
	// BaseDatos bd = new BaseDatos();
	Usuario usuario;
	// nueva conexion a mysql
	// BaseDatos2 bd = new BaseDatos2();
	@Autowired
	BaseDatos3Service bd;

	@GetMapping("/")
	public String iniciar(Model model) { 
		// Importante al importar la libreria import org.springframework.ui.Model;
		model.addAttribute("titulo", "FORMULARIO DE ACCESO");
		return "login"; 
	}

	@PostMapping("/")
	public String login(Usuario usuario, Model model, @RequestParam String nombre, @RequestParam String password) {
		if (usuario.getNombre().equals("edu") && usuario.getPassword().equals("edu")) {
			this.usuario = usuario;
			ArrayList<Libro> libros = bd.getLibros();
			model.addAttribute("usuario", usuario);
			model.addAttribute("libros", libros);
			return "consulta"; 
		} else 
			return "login";

	}

	@PostMapping("/insertar")
	public String insertar(Libro libro, Model model) {
		//esto sirve para la basedatos y basedatos2
		bd.inserta(libro);
		ArrayList<Libro> libros = bd.getLibros();

		model.addAttribute("usuario", this.usuario);
		model.addAttribute("libros", libros);
		model.addAttribute("boton", "Inserta Libro");
		model.addAttribute("action", "/insertar");
		model.addAttribute("libro", null);
		return "consulta";
	}

	@GetMapping("/borrado/{id}")
	public String borrar(@PathVariable int id, Model model) {
		bd.borrar(id);
		ArrayList<Libro> libros = bd.getLibros();
		model.addAttribute("libros", libros);
		model.addAttribute("usuario", this.usuario);
		model.addAttribute("boton", "Inserta Libro");
		model.addAttribute("action", "/insertar");
		return "consulta";
	}

	@GetMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model) {
		// mirar este error del pdf
		Libro libro = bd.getLibro(id);
		ArrayList<Libro> libros = bd.getLibros();
		model.addAttribute("libros", libros);
		model.addAttribute("libro", libro);
		model.addAttribute("usuario", this.usuario);
		model.addAttribute("boton", "Actualiza Libro");
		model.addAttribute("action", "/modificar");
		return "consulta";
	}

	@PostMapping("/modificar")
	public String modificar2(Libro libro, Model model) {
		bd.modifica(libro);
		ArrayList<Libro> libros = bd.getLibros();
		model.addAttribute("usuario", this.usuario);
		model.addAttribute("libros", libros);
		model.addAttribute("libro", null);
		model.addAttribute("usuario", this.usuario);
		model.addAttribute("boton", "Inserta Libro");
		model.addAttribute("action", "/insertar");
		return "consulta";
	}

}
