package com.methodica.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.methodica.spring.models.Alumno;
import com.methodica.spring.models.Profesor;
import com.methodica.spring.repositories.ProfesorRepository;

@Service
public class ProfesorServicio {
	
	@Autowired
	ProfesorRepository profesorRepository;
	
	public Profesor insertar(Profesor p) {
		return profesorRepository.save(p);
	}
	
	public void borrar(long id) {
		profesorRepository.deleteById(id);
	}
	
	public void borrar(Profesor p) {
		profesorRepository.delete(p);
	}
	
	public Profesor editar(Profesor p) {
		return profesorRepository.save(p);
	}
	
	public Profesor findById(long id) {
		return profesorRepository.findById(id).orElse(null);
	}
	
	public Profesor findByUsername(String username) {
		return profesorRepository.findByUsername(username);
	}
	
	public List<Profesor> findAll() {
		return profesorRepository.findAll();
	}
		
	
}
