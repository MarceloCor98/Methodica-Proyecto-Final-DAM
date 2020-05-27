package com.methodica.spring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.methodica.spring.models.Curso;
import com.methodica.spring.models.Profesor;

@Repository
public interface CursoRepository extends JpaRepository<Curso,Long>{
	List<Curso> findByProfesor(Profesor profesor);
	List<Curso> findByNombre(String nombre);
	
}
