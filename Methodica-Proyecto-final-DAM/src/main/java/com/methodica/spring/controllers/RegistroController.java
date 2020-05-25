package com.methodica.spring.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.methodica.spring.models.Alumno;
import com.methodica.spring.models.Profesor;
import com.methodica.spring.models.Usuario;
import com.methodica.spring.services.AlumnoServicio;
import com.methodica.spring.services.ProfesorServicio;
import com.methodica.spring.services.UsuarioServicio;
import com.methodica.spring.services.ValidacionServicio;

@Controller
public class RegistroController {
	
	@Autowired
	AlumnoServicio alumnoServicio;
	@Autowired
	ProfesorServicio profesorServicio;
	@Autowired
	UsuarioServicio usuarioServicio;
	@Autowired
	ValidacionServicio validacionServicio;
	
	
	@GetMapping("/registro")
	public String registro(Model model) {	
		model.addAttribute("alumno",new Alumno());
		return "registro";
	}	
	
	
	@PostMapping("/registro/submit")
	public String registroSubmit(Model model,@ModelAttribute Alumno alumno,@RequestParam("checkPassword") String checkPassword) {
		
		List<String> errores = new ArrayList<String>();
		
		if(validacionServicio.UsuarioExiste(alumno.getUsername()))
			errores.add("El usuario ya existe");
		if (!validacionServicio.ValidarPassword(alumno.getPassword(),checkPassword ))
			errores.add("Las contraseñas no coinciden");
		if(!validacionServicio.ValidarNombreUsuario(alumno.getUsername()))
			errores.add("El usuario debe tener entre 6-14 caracteres y no contener espacios");
		if(!validacionServicio.ValidarDni(alumno.getDni()) && !validacionServicio.ValidarNie(alumno.getDni()))
			errores.add("El DNI/NIE no es correcto");
		if(!validacionServicio.ValidarPasswordFormato(alumno.getPassword()))
			errores.add("El formato de contraseña debe ser:<br>- Longitud : Al menos 8 caracteres<br>- Debe contener al menos un dígito"
					+ "<br>- Debe contener al menos una letra mayúscula y una minúscula<br>- Debe contener al menos un caracter especial(@#$%^&+=)");
		
		if(errores.size() > 0) {
			model.addAttribute("errores",errores);
			return "registro";
		}
			
			
			
		Usuario u = new Usuario();
		u.setUsername(alumno.getUsername());
		u.setPassword(alumno.getPassword());
		u.setRoles("ROLE_ALUMNO");
		
		usuarioServicio.insertar(u);
		alumnoServicio.insertar(alumno);
		
		return "redirect:/login";
	}
	
	@GetMapping("/registroProfesor")
	public String registroProfesor(Model model) {	
		model.addAttribute("profesor",new Profesor());
		return "registroProfesor";
	}
	
	@PostMapping("/registroProfesor/submit")
	public String registroProfesorSubmit(Model model,@ModelAttribute Profesor profesor,@RequestParam("checkPassword") String checkPassword) {
		
		List<String> errores = new ArrayList<String>();
		
		if(validacionServicio.UsuarioExiste(profesor.getUsername()))
			errores.add("El usuario ya existe");
		if (!validacionServicio.ValidarPassword(profesor.getPassword(),checkPassword ))
			errores.add("Las contraseñas no coinciden");
		if(!validacionServicio.ValidarNombreUsuario(profesor.getUsername()))
			errores.add("El usuario debe tener entre 6-14 caracteres y no contener espacios");
		if(!validacionServicio.ValidarDni(profesor.getDni()) && !validacionServicio.ValidarNie(profesor.getDni()))
			errores.add("El DNI/NIE no es correcto");
		
		if(errores.size() > 0) {
			model.addAttribute("errores",errores);
			return "registroProfesor";
		}
			
			
			
		Usuario u = new Usuario();
		u.setUsername(profesor.getUsername());
		u.setPassword(profesor.getPassword());
		u.setRoles("ROLE_PROFESOR");
		
		usuarioServicio.insertar(u);
		profesorServicio.insertar(profesor);
		
		return "redirect:/inicio";
	}
	
}
