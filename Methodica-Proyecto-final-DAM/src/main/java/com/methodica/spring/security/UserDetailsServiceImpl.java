package com.methodica.spring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.methodica.spring.models.Usuario;
import com.methodica.spring.services.UsuarioServicio;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	UsuarioServicio usuarioServicio;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuario usuario = usuarioServicio.findByUsername(username);
		
		if(usuario == null) throw new UsernameNotFoundException("Not found : " + username);
		
		return new MyUserDetails(usuario);
	}
	
	
	
	
	

}
