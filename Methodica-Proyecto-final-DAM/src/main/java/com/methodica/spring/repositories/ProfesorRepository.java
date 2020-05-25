package com.methodica.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.methodica.spring.models.Profesor;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor,Long>{
	Profesor findByUsername(String username);

}
