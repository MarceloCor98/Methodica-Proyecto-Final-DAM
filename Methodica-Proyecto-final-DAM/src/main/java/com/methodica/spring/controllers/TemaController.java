package com.methodica.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.methodica.spring.models.Apartado;
import com.methodica.spring.models.Curso;
import com.methodica.spring.models.Tema;
import com.methodica.spring.services.ApartadoServicio;
import com.methodica.spring.services.CursoServicio;
import com.methodica.spring.services.TemaServicio;

@Controller
public class TemaController {
	
	
	@Autowired
	CursoServicio cursoServicio;
	
	@Autowired
	TemaServicio temaServicio;
	
	@Autowired 
	ApartadoServicio apartadoServicio;
	
	
	@GetMapping("/nuevoTema/{idCurso}")
	public String nuevoTema(Model model,@PathVariable Long idCurso) {
		
		Curso c = cursoServicio.findById(idCurso);		
		Tema t = new Tema();
		t.setCurso(c);
		
		model.addAttribute("tema",t);		
		model.addAttribute("accion","Añadir tema");	
		
		return "cursos/temaForm";
	}
	
	@PostMapping("/nuevoTema/submit")
	public String nuevoTemaSubmit(@ModelAttribute Tema nuevoTema) {
		
		temaServicio.insertar(nuevoTema);	
		
		return "redirect:/curso/" + nuevoTema.getCurso().getId();					
		
	}
	
	@GetMapping("/editarTema/{id}")
	public String editarTema(Model model,@PathVariable Long id) {
		
		Tema t = temaServicio.findById(id);
		model.addAttribute("tema",t);		
		model.addAttribute("accion","Editar tema");	
		
		return "cursos/temaForm";	
	}
	
	@PostMapping("/editarTema/submit")
	public String editarTemaSubmit(@ModelAttribute("tema") Tema temaEditado) {
		
		temaServicio.editar(temaEditado);	
		
		return "redirect:/curso/" + temaEditado.getCurso().getId();					
		
	}
	
	@GetMapping("/eliminarTema/{id}")
	public String eliminarTema(Model model,@PathVariable Long id) {
		
		Tema t = temaServicio.findById(id);
		
		List<Apartado> apartados = apartadoServicio.findByTema(t);
		
		for(Apartado a : apartados) {
			apartadoServicio.borrar(a);
		}
		
		temaServicio.borrar(t);
		
		return "redirect:/curso/" + t.getCurso().getId();	
	}
	
	
	

}
