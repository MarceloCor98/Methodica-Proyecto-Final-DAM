package com.methodica.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.methodica.spring.models.Apartado;
import com.methodica.spring.models.Fichero;
import com.methodica.spring.models.Tema;
import com.methodica.spring.repositories.FicheroRepository;

@Service
public class FicheroServicio {
	
	@Autowired
	FicheroRepository ficheroRepository;
	
	public Fichero insertar(Fichero f) {
		return ficheroRepository.save(f);
	}
	
	public void borrar(long id) {
		ficheroRepository.deleteById(id);
	}
	
	public void borrar(Fichero f) {
		ficheroRepository.delete(f);
	}
	
	public Fichero editar(Fichero f) {
		return ficheroRepository.save(f);
	}
	
	public Fichero findById(long id) {
		return ficheroRepository.findById(id).orElse(null);
	}
	
	public List<Fichero> findByTema(Tema tema) {
		return ficheroRepository.findByTema(tema);
	}
	
	public List<Fichero> deleteByTema(Tema tema) {
		return ficheroRepository.deleteByTema(tema);
	}
	public List<Fichero> findAll() {
		return ficheroRepository.findAll();
	}
		
	
}
