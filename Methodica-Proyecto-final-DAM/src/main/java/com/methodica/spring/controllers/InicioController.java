package com.methodica.spring.controllers;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.methodica.spring.models.Alumno;
import com.methodica.spring.models.Curso;
import com.methodica.spring.services.AlumnoServicio;
import com.methodica.spring.services.CursoServicio;
import com.methodica.spring.services.ProfesorServicio;
import com.methodica.spring.services.UsuarioServicio;

@Controller
public class InicioController {
	
	
	@Autowired
	CursoServicio cursoServicio;
	
	@Autowired
	UsuarioServicio usuarioServicio;
	
	@Autowired
	AlumnoServicio alumnoServicio;
	
	@Autowired
	ProfesorServicio profesorServicio;
		
	@GetMapping({"/","/inicio"})
	public String inicioCursos(Model model,Authentication authentication) {
		model.addAttribute("listaCursos",cursoServicio.findAll());		
		return "inicio";
	}
	
	@GetMapping({"/matricularse/{idCurso}"})
	public String matricularse(Model model,@PathVariable("idCurso") Long idCurso) {
		model.addAttribute("curso",cursoServicio.findById(idCurso));		
		return "matricula";
	}
	
	@PostMapping({"/matricularse/submit/{idCurso}"})
	public String matricularse(Model model,@PathVariable("idCurso")Long idCurso,@RequestParam(name = "clave") String clave,Authentication authentication) {
		
		Curso curso = cursoServicio.findById(idCurso);
		
		if(clave.equals(curso.getClaveMatricula())) {
			
			Alumno a = alumnoServicio.findByUsername(authentication.getName());
			
			a.addCurso(curso);
			
			alumnoServicio.editar(a);
		}
		else {
			model.addAttribute("errorClave","Clave de matriculación incorrecta");
			model.addAttribute("curso",curso);
			return "matricula";
		}
		
		
		return "redirect:/curso/" + curso.getId();
	}

}
