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

import com.methodica.spring.models.Usuario;
import com.methodica.spring.services.AlumnoServicio;
import com.methodica.spring.services.ApartadoServicio;
import com.methodica.spring.services.CursoServicio;
import com.methodica.spring.services.ProfesorServicio;
import com.methodica.spring.services.TemaServicio;
import com.methodica.spring.services.UsuarioServicio;
import com.methodica.spring.services.ValidacionServicio;

@Controller
public class AdminController {
	
	@Autowired
	AlumnoServicio alumnoServicio;
	
	@Autowired
	ProfesorServicio profesorServicio;
	
	@Autowired
	CursoServicio cursoServicio;
	
	@Autowired
	TemaServicio temaServicio;
	
	@Autowired
	ApartadoServicio apartadoServicio;
	
	@Autowired
	UsuarioServicio usuarioServicio;
	@Autowired
	ValidacionServicio validacionServicio;
	
	
	@GetMapping("/addAdmin")
	public String añadirAdmin(Model model) {		
		
		model.addAttribute("adminUser",new Usuario());
		
		return "adminForm";
	}
	
	@PostMapping("/addAdmin/submit")
	public String añadirAdminSubmit(@ModelAttribute("adminUser")Usuario usuario,@RequestParam("adminKey") String adminKey,@RequestParam("checkPassword") String checkPassword,Model model) {		
		
		List<String> errores = new ArrayList<String>();
		
		if(validacionServicio.UsuarioExiste(usuario.getUsername()))
			errores.add("El usuario ya existe");
		if (!validacionServicio.ValidarPassword(usuario.getPassword(),checkPassword ))
			errores.add("Las contraseñas no coinciden");
		if(!validacionServicio.ValidarPasswordFormato(usuario.getPassword()))
			errores.add("El formato de contraseña debe ser:<br>- Longitud : Al menos 8 caracteres<br>- Debe contener al menos un dígito"
					+ "<br>- Debe contener al menos una letra mayúscula y una minúscula<br>- Debe contener al menos un caracter especial(@#$%^&+=)");
		
		if(!adminKey.equals("AdminPassAuth")){
			errores.add("Clave de administración incorrecta");
			
		}
		if(errores.size() > 0) {
			model.addAttribute("errores",errores);
			model.addAttribute("adminUser",usuario);
			return "adminForm";
		}else {
			usuario.setRoles("ROLE_ADMIN");		
			usuarioServicio.insertar(usuario);
			
			return "redirect:/inicio";
		}
		
		
	}
	
	

}
