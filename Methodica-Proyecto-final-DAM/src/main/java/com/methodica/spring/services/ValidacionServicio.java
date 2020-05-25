package com.methodica.spring.services;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidacionServicio {
	
	@Autowired
	UsuarioServicio usuarioServicio;
	
	private static Pattern userNamePattern = Pattern.compile("^[a-z0-9_-]{6,14}$");
	private static Pattern dniPattern = Pattern.compile("^[0-9]{8}[A-Za-z]$");
	private static Pattern niePattern = Pattern.compile("^[XYZxyz][0-9]{7}[A-Z]$");
	private static Pattern passPattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&+=])(?=\\S+$).{8,}$");
	
	public boolean UsuarioExiste(String username) {		
		return usuarioServicio.existeUsuario(username);
	}
	
	public boolean ValidarPassword(String p1,String p2) {
		return p1.equals(p2);
	}
	
	public boolean ValidarPasswordFormato(String password) {
		Matcher mtch = passPattern.matcher(password);
		return mtch.matches();
	}
	
	public boolean ValidarNombreUsuario(String username) {
		
		Matcher mtch = userNamePattern.matcher(username);
		
		return mtch.matches();
	}
	
	public boolean ValidarDni(String dni) {
		Matcher mtch = dniPattern.matcher(dni);
		return mtch.matches();
	}
	
	public boolean ValidarNie(String nie) {
		Matcher mtch = niePattern.matcher(nie);
		return mtch.matches();
	}

}
