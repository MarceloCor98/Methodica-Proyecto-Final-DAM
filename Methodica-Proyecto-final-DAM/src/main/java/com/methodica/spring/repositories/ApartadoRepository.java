package com.methodica.spring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.methodica.spring.models.Apartado;
import com.methodica.spring.models.Tema;

@Repository
public interface ApartadoRepository extends JpaRepository<Apartado,Long>{
	List<Apartado> findByTema(Tema tema);
	List<Apartado> deleteByTema(Tema tema);
}
