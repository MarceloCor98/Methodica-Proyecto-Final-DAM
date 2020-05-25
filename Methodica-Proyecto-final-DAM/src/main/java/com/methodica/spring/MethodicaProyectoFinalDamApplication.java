package com.methodica.spring;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.methodica.spring.models.Curso;
import com.methodica.spring.models.Profesor;
import com.methodica.spring.repositories.AlumnoRepository;
import com.methodica.spring.services.CursoServicio;
import com.methodica.spring.services.ProfesorServicio;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = AlumnoRepository.class)
public class MethodicaProyectoFinalDamApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(MethodicaProyectoFinalDamApplication.class, args);	
	
	
	}	
	
}


