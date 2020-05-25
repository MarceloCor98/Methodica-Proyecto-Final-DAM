package com.methodica.spring.services;

import java.nio.charset.StandardCharsets;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.google.common.hash.Hashing;
import com.methodica.spring.models.Usuario;
import com.methodica.spring.repositories.UsuarioRepository;

@Service
public class UsuarioServicio {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	public Usuario insertar(Usuario u) {
		u.setPassword(passwordEncoder.encode(u.getPassword()));	
		return usuarioRepository.save(u);
	}
	
	public void borrar(long id) {
		usuarioRepository.deleteById(id);
	}
	
	public void borrar(Usuario u) {
		usuarioRepository.delete(u);
	}
	
	public Usuario editar(Usuario u) {
		return usuarioRepository.save(u);
	}
	
	public Usuario findById(long id) {
		return usuarioRepository.findById(id).orElse(null);
	}
	
	public Usuario findByUsername(String username) {
		return usuarioRepository.findByUsername(username);
	}
	
	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}
	
	public boolean existeUsuario(String username) {
		return usuarioRepository.existsUsuarioByUsername(username);
	}
	
}
