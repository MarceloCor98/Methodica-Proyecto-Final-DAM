package com.methodica.spring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.methodica.spring.models.Curso;
import com.methodica.spring.models.Tema;

@Repository
public interface TemaRepository extends JpaRepository<Tema,Long>{
	List<Tema> findByCurso(Curso curso);
	List<Tema> deleteByCurso(Curso curso);
}
