package com.methodica.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.methodica.spring.models.Apartado;
import com.methodica.spring.models.Tema;
import com.methodica.spring.repositories.ApartadoRepository;

@Service
public class ApartadoServicio {
	
	@Autowired
	ApartadoRepository apartadoRepository;
	
	public Apartado insertar(Apartado a) {
		return apartadoRepository.save(a);
	}
	
	public void borrar(long id) {
		apartadoRepository.deleteById(id);
	}
	
	public void borrar(Apartado a) {
		apartadoRepository.delete(a);
	}
	
	public Apartado editar(Apartado a) {
		return apartadoRepository.save(a);
	}
	
	public Apartado findById(long id) {
		return apartadoRepository.findById(id).orElse(null);
	}
	
	public List<Apartado> findByTema(Tema tema) {
		return apartadoRepository.findByTema(tema);
	}
	
	public List<Apartado> deleteByTema(Tema tema) {
		return apartadoRepository.deleteByTema(tema);
	}
	public List<Apartado> findAll() {
		return apartadoRepository.findAll();
	}
		
	
}
