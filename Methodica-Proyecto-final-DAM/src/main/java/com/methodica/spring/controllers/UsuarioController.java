package com.methodica.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.methodica.spring.models.Alumno;
import com.methodica.spring.models.Usuario;
import com.methodica.spring.services.UsuarioServicio;

@Controller
public class UsuarioController {
	
	@Autowired
	UsuarioServicio usuarioServicio;
	
	@GetMapping("/añadirUsuario")
	public String login(Model model) {
		
		
		
		Usuario u = usuarioServicio.findByUsername("jorgito");
		
		u.setRoles("ROLE_USER,ROLE_ADMIN");
		usuarioServicio.editar(u);
		
		return "redirect:/inicio";
	}

}
