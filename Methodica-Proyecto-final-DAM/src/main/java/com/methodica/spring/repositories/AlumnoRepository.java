package com.methodica.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.methodica.spring.models.Alumno;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno,Long>{
	Alumno findByUsername(String username);
}
