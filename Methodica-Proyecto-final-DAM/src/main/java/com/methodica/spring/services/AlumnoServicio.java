package com.methodica.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.methodica.spring.models.Alumno;
import com.methodica.spring.repositories.AlumnoRepository;

@Service
public class AlumnoServicio {
	
	@Autowired
	AlumnoRepository alumnoRepository;
	
	public Alumno insertar(Alumno a) {
		return alumnoRepository.save(a);
	}
	
	public void borrar(long id) {
		alumnoRepository.deleteById(id);
	}
	
	public void borrar(Alumno a) {
		alumnoRepository.delete(a);
	}
	
	public Alumno editar(Alumno a) {
		return alumnoRepository.save(a);
	}
	
	public Alumno findById(long id) {
		return alumnoRepository.findById(id).orElse(null);
	}
	
	public Alumno findByUsername(String username) {
		return alumnoRepository.findByUsername(username);
	}
	
	public List<Alumno> findAll() {
		return alumnoRepository.findAll();
	}
		
	
}
