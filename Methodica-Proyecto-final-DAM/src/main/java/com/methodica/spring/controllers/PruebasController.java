package com.methodica.spring.controllers;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.methodica.spring.models.Alumno;
import com.methodica.spring.models.Apartado;
import com.methodica.spring.models.Curso;
import com.methodica.spring.models.Profesor;
import com.methodica.spring.models.Tema;
import com.methodica.spring.models.Usuario;
import com.methodica.spring.services.AlumnoServicio;
import com.methodica.spring.services.ApartadoServicio;
import com.methodica.spring.services.CursoServicio;
import com.methodica.spring.services.ProfesorServicio;
import com.methodica.spring.services.TemaServicio;
import com.methodica.spring.services.UsuarioServicio;

@Controller
public class PruebasController {
	
	@Autowired
	AlumnoServicio alumnoServicio;
	
	@Autowired
	ProfesorServicio profesorServicio;
	
	@Autowired
	CursoServicio cursoServicio;
	
	@Autowired
	TemaServicio temaServicio;
	
	@Autowired
	ApartadoServicio apartadoServicio;
	
	@Autowired
	UsuarioServicio usuarioServicio;
	
	@GetMapping("/añadirProfes")
	public String añadirProfes(Model model) {		
		
		Profesor p = new Profesor();
		p.setNombre("Jorge");		
		
		profesorServicio.insertar(p);
		
		Profesor p2 = new Profesor();
		p2.setNombre("Marta");		
		
		profesorServicio.insertar(p2);
		
		Profesor p3 = new Profesor();
		p3.setNombre("Marcelo");		
		
		profesorServicio.insertar(p3);
		
		Profesor p4 = new Profesor();
		p4.setNombre("Raúl");		
		
		profesorServicio.insertar(p4);
		
		return "redirect:/inicio";
	}
	
	@GetMapping("/añadirTemas")
	public String añadirTemas(Model model) {		
		
		Curso cursoFisica = cursoServicio.findById(25);
		
		
		Tema t1 = new Tema();
		t1.setNombre("Tema 1");
		t1.setCurso(cursoFisica);
		
		Tema t2 = new Tema();
		t2.setNombre("Tema 2");
		t2.setCurso(cursoFisica);
		
		Tema t3 = new Tema();
		t3.setNombre("Tema 3");
		t3.setCurso(cursoFisica);
		
		temaServicio.insertar(t1);
		temaServicio.insertar(t2);
		temaServicio.insertar(t3);
		
		return "pruebaProfe";
	}
	
	@GetMapping("/añadirApartados")
	public String añadirApartados(Model model) {		
		
		Tema t1 = temaServicio.findById(29);
		
		Apartado a1 = new Apartado();
		a1.setTitulo("Apartado 1");
		a1.setTema(t1);
		
		Apartado a2 = new Apartado();
		a2.setTitulo("Apartado 2");
		a2.setTema(t1);
		
		apartadoServicio.insertar(a1);
		apartadoServicio.insertar(a2);
		
		return "pruebaProfe";
	}
	
	@GetMapping("/admin")
	public String admin(Model model) {		
		
		return "admin";
	}
	
	@GetMapping("/user")
	public String user(Model model) {		
		
		return "user";
	}
	
	@GetMapping("/añadirAdmin")
	public String añadirAdmin(Model model) {		
		
		Usuario u = new Usuario();
		u.setUsername("admin");
		u.setPassword("admin");
		u.setRoles("ROLE_ADMIN");		
		
		usuarioServicio.insertar(u);
		
		return "redirect:/inicio";
	}
	
	
	@GetMapping("/matricularAlumno")
	public String matricula(Model model) {		
		
		Curso c = cursoServicio.findById(3);
		
		Alumno a = new Alumno();
		a.setUsername("userprueba456");
		a.setPassword("arg66631M!");
		
		Set<Curso> cursos = new HashSet<>();
		cursos.add(c);
		a.setCursos(cursos);
		
		alumnoServicio.insertar(a);
		
		return "redirect:/inicio";
	}
	
	

}
