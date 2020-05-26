package com.methodica.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.methodica.spring.models.Alumno;
import com.methodica.spring.models.Curso;
import com.methodica.spring.models.Profesor;
import com.methodica.spring.models.Tema;
import com.methodica.spring.models.Usuario;
import com.methodica.spring.services.AlumnoServicio;
import com.methodica.spring.services.ApartadoServicio;
import com.methodica.spring.services.CursoServicio;
import com.methodica.spring.services.FicheroServicio;
import com.methodica.spring.services.ProfesorServicio;
import com.methodica.spring.services.TemaServicio;
import com.methodica.spring.services.UsuarioServicio;

@Controller
@Transactional
public class CursoController {
	
	
	@Autowired
	CursoServicio cursoServicio;
	@Autowired
	ProfesorServicio profesorServicio;
	@Autowired
	AlumnoServicio alumnoServicio;
	@Autowired
	TemaServicio temaServicio;
	@Autowired
	ApartadoServicio apartadoServicio;
	@Autowired
	FicheroServicio ficheroServicio;
	@Autowired
	UsuarioServicio usuarioServicio;
	
	@GetMapping("/curso/{id}")
	public String curso(Model model,@PathVariable Long id, Authentication auth) {
		
		Curso c = cursoServicio.findById(id);
		
		Usuario u = usuarioServicio.findByUsername(auth.getName());
		
		 if (u.getRoles().contains("ROLE_PROFESOR")) {
			Profesor p = profesorServicio.findByUsername(u.getUsername());
			if(!(c.getProfesor().getId() == p.getId())) {
				model.addAttribute("titulo","Contenido no accesible");
				model.addAttribute("mensaje","El curso al que intenta acceder no es de su propiedad, contacte con un administrador para conseguir privilegios.");
				return "errores/error";
			}
		}
				
			if(u.getRoles().contains("ROLE_ALUMNO")) {
				Alumno a = alumnoServicio.findByUsername(u.getUsername());
				if(!a.getCursos().contains(c)) {
					return "redirect:/matricularse/"+ c.getId();
				}
			}
			
			List<Tema> listaTemas = temaServicio.findByCurso(c);
			
			for(Tema t : listaTemas){
				t.setApartados(apartadoServicio.findByTema(t));
				t.setFicheros(ficheroServicio.findByTema(t));
			}
			
			
			model.addAttribute("curso",c);
			model.addAttribute("listaTemas",listaTemas);
			return "cursos/curso";
		
		
	}
	
	@GetMapping("/editarCurso/{id}")
	public String editarCurso(Model model,@PathVariable Long id) {
		
		Curso c = cursoServicio.findById(id);
		
		model.addAttribute("curso",c);
		model.addAttribute("listaProfesores",profesorServicio.findAll());
		model.addAttribute("accion","Editar curso");
		
		return "cursos/cursoForm";
	}
	
	@PostMapping("/editarCurso/submit")
	public String editarCursoSubmit(@ModelAttribute("curso") Curso cursoEditado,@RequestParam("idProfesor") long idProfesor) {
		
		Profesor p = profesorServicio.findById(idProfesor);
		
		cursoEditado.setProfesor(p);
		
		cursoServicio.editar(cursoEditado);
		
		return "redirect:/inicio";			
		
		
	}
	
	
	@GetMapping("/nuevoCurso")
	public String nuevoCurso(Model model) {
		Profesor p = new Profesor();
		Curso c = new Curso();
		c.setProfesor(p);
		model.addAttribute("curso",c);
		model.addAttribute("listaProfesores",profesorServicio.findAll());
		model.addAttribute("accion","Nuevo curso");
		
		return "cursos/cursoForm";
	}
	
	@PostMapping("/nuevoCurso/submit")
	public String nuevoCursoSubmit(@ModelAttribute Curso nuevoCurso,@RequestParam("idProfesor") long idProfesor) {
		
		Profesor p = profesorServicio.findById(idProfesor);
		
		nuevoCurso.setProfesor(p);
		
		cursoServicio.insertar(nuevoCurso);
		
		return "redirect:/inicio";			
		
		
	}
	
	@GetMapping("/eliminarCurso/{id}")
	public String eliminarCurso(Model model,@PathVariable Long id) {
		
		Curso c = cursoServicio.findById(id);
		
		List<Tema> temas = temaServicio.findByCurso(c);
		
		for(Tema t : temas) {
			apartadoServicio.deleteByTema(t);
		}	
		
		temaServicio.deleteByCurso(c);
		
		for(Alumno a : c.getAlumnosMatriculados())
			a.deleteCurso(c);
		
		c.setProfesor(null);
		
		cursoServicio.borrar(c);
		
		return "redirect:/inicio";
	}

}
