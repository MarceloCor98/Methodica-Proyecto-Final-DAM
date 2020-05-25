package com.methodica.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.methodica.spring.models.Apartado;
import com.methodica.spring.models.Curso;
import com.methodica.spring.models.Profesor;
import com.methodica.spring.models.Tema;
import com.methodica.spring.services.ApartadoServicio;
import com.methodica.spring.services.CursoServicio;
import com.methodica.spring.services.TemaServicio;

@Controller
public class ApartadoController {
	
	@Autowired
	CursoServicio cursoServicio;
	
	@Autowired
	TemaServicio temaServicio;
	
	@Autowired 
	ApartadoServicio apartadoServicio;
	
	@GetMapping("/apartado/{id}")
	public String apartado(Model model,@PathVariable Long id) {
		
		Apartado a = apartadoServicio.findById(id);
		
		model.addAttribute("apartado",a);		
		
		return "cursos/apartado";
	}
	
	@GetMapping("/nuevoApartado/{idTema}")
	public String nuevoApartado(Model model,@PathVariable Long idTema) {
		
		Tema t = temaServicio.findById(idTema);
		
		Apartado a = new Apartado();
		a.setTema(t);
		
		model.addAttribute("apartado",a);		
		model.addAttribute("accion","Añadir apartado");
		
		return "cursos/apartadoForm";
	}
	
	@PostMapping("/nuevoApartado/submit")
	public String nuevoApartadoSubmit(@ModelAttribute("apartado") Apartado apartado) {
		
		apartadoServicio.insertar(apartado);
		
		Curso c = cursoServicio.findById(apartado.getTema().getCurso().getId());
		
		return "redirect:/curso/" + c.getId();
	}
	
	@GetMapping("/editarApartado/{id}")
	public String editarApartado(Model model,@PathVariable Long id) {
		
		Apartado a = apartadoServicio.findById(id);
		
		
		model.addAttribute("apartado",a);
		model.addAttribute("accion","Editar apartado");
		
		return "cursos/apartadoForm";
	}
	
	@PostMapping("/editarApartado/submit")
	public String editarApartadoSubmit(@ModelAttribute("apartado") Apartado apartadoEditado) {
		
		apartadoServicio.editar(apartadoEditado);
		
		Curso c = cursoServicio.findById(apartadoEditado.getTema().getCurso().getId());
		
		return "redirect:/curso/" + c.getId();		
		
		
	}
	
	@GetMapping("/eliminarApartado/{id}")
	public String eliminarApartado(Model model,@PathVariable Long id) {
		
		Apartado a = apartadoServicio.findById(id);
		Curso c = cursoServicio.findById(a.getTema().getCurso().getId());	
		
		apartadoServicio.borrar(a);
		
		return "redirect:/curso/" + c.getId();
	}
}
