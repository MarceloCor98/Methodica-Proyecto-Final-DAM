package com.methodica.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.methodica.spring.models.Curso;
import com.methodica.spring.models.Profesor;
import com.methodica.spring.models.Tema;
import com.methodica.spring.repositories.TemaRepository;

@Service
public class TemaServicio {
	
	@Autowired
	TemaRepository temaRepository;
	
	public Tema insertar(Tema t) {
		return temaRepository.save(t);
	}
	
	public void borrar(long id) {
		temaRepository.deleteById(id);
	}
	
	public void borrar(Tema t) {
		temaRepository.delete(t);
	}
	
	public Tema editar(Tema t) {
		return temaRepository.save(t);
	}
	
	public Tema findById(long id) {
		return temaRepository.findById(id).orElse(null);
	}
	
	public List<Tema> findByCurso(Curso curso) {
		return temaRepository.findByCurso(curso);
	}
	
	public List<Tema> deleteByCurso(Curso curso) {
		return temaRepository.deleteByCurso(curso);
	}
	
	public List<Tema> findAll() {
		return temaRepository.findAll();
	}
		
	
}
