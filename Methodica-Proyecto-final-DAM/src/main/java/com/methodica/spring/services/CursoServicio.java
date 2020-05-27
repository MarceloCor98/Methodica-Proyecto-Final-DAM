package com.methodica.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.methodica.spring.models.Curso;
import com.methodica.spring.models.Profesor;
import com.methodica.spring.repositories.CursoRepository;

@Service
public class CursoServicio {
	
	@Autowired
	CursoRepository cursoRepository;
	
	public Curso insertar(Curso c) {
		return cursoRepository.save(c);
	}
	
	public void borrar(long id) {
		cursoRepository.deleteById(id);
	}
	
	public void borrar(Curso c) {
		cursoRepository.delete(c);
	}
	
	public Curso editar(Curso c) {
		return cursoRepository.save(c);
	}
	
	public Curso findById(long id) {
		return cursoRepository.findById(id).orElse(null);
	}
	
	public List<Curso> findAll() {
		return cursoRepository.findAll();
	}
	
	public List<Curso> findByProfesor(Profesor profesor){
		return cursoRepository.findByProfesor(profesor);
	}
	public List<Curso> findByNombre(String nombre){
		return cursoRepository.findByNombre(nombre);
	}
	
	
}
