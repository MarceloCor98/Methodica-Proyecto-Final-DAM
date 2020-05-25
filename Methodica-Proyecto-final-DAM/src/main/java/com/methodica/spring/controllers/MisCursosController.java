package com.methodica.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.methodica.spring.models.Alumno;
import com.methodica.spring.models.Profesor;
import com.methodica.spring.models.Usuario;
import com.methodica.spring.services.AlumnoServicio;
import com.methodica.spring.services.CursoServicio;
import com.methodica.spring.services.ProfesorServicio;
import com.methodica.spring.services.UsuarioServicio;

@Controller
public class MisCursosController {
	
	
	@Autowired
	CursoServicio cursoServicio;
	
	@Autowired
	UsuarioServicio usuarioServicio;
	
	@Autowired
	AlumnoServicio alumnoServicio;
	
	@Autowired
	ProfesorServicio profesorServicio;
	
	
	@GetMapping("/misCursos")
	public String inicioCursos(Model model,Authentication authentication) {
		
		Usuario u = usuarioServicio.findByUsername(authentication.getName());
		if(u.getRoles().contains("ROLE_ADMIN"))
			model.addAttribute("listaCursos",cursoServicio.findAll());
		else if(u.getRoles().contains("ROLE_PROFESOR")){
			Profesor p = profesorServicio.findByUsername(authentication.getName());
			model.addAttribute("listaCursos",cursoServicio.findByProfesor(p));
		}
		else if(u.getRoles().contains("ROLE_ALUMNO")){
			Alumno a = alumnoServicio.findByUsername(authentication.getName());
			model.addAttribute("listaCursos",a.getCursos());
		}	
		
		return "inicio";
	}

}
