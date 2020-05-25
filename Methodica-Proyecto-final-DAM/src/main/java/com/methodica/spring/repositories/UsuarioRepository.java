package com.methodica.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.methodica.spring.models.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long>{
	Usuario findByUsername(String username);
	boolean existsUsuarioByUsername(String username);
}
