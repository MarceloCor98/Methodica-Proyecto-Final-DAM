package com.methodica.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.methodica.spring.models.Usuario;
import com.methodica.spring.services.AlumnoServicio;

@Controller
public class LoginController {
	
	@Autowired
	AlumnoServicio alumnoServicio;
	
	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("usuario",new Usuario());
		return "login";
	}

}
