package com.methodica.spring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.methodica.spring.models.Fichero;
import com.methodica.spring.models.Tema;

@Repository
public interface FicheroRepository extends JpaRepository<Fichero,Long>{
	List<Fichero> findByTema(Tema tema);
	List<Fichero> deleteByTema(Tema tema);
}
