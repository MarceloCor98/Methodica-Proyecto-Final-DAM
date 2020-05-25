package com.methodica.spring.controllers;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.methodica.spring.models.Fichero;
import com.methodica.spring.models.Tema;
import com.methodica.spring.services.ApartadoServicio;
import com.methodica.spring.services.CursoServicio;
import com.methodica.spring.services.FicheroServicio;
import com.methodica.spring.services.ProfesorServicio;
import com.methodica.spring.services.TemaServicio;


@Controller
public class FicheroController {
	
	public static String directorioSubidas = System.getProperty("user.dir") + "/src/main/resources/subidas";
	
	@Autowired
	CursoServicio cursoServicio;
	@Autowired
	ProfesorServicio profesorServicio;
	@Autowired
	TemaServicio temaServicio;
	@Autowired
	ApartadoServicio apartadoServicio;
	@Autowired
	FicheroServicio ficheroServicio;
	
	@GetMapping("/nuevoFichero/{idTema}")
	public String nuevoFichero(Model model,@PathVariable Long idTema) {
		
		Tema tema = temaServicio.findById(idTema);
		
		
		model.addAttribute("accion","Subir fichero");
		model.addAttribute("tema",tema);
		
		return "cursos/ficheroForm";
	}
	
	@PostMapping("/nuevoFichero/submit")
	public String nuevoFicheroSubmit(@ModelAttribute("tema")Tema tema,@RequestParam("files") MultipartFile[] ficheros) {
		
		for(MultipartFile fichero : ficheros) {
			Path rutaFichero = Paths.get(directorioSubidas,fichero.getOriginalFilename());
			try {
				Files.write(rutaFichero, fichero.getBytes());
				Fichero f = new Fichero();
				f.setNombre(fichero.getOriginalFilename());
				f.setRuta(rutaFichero.toString());
				f.setTema(tema);
				ficheroServicio.insertar(f);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		return "redirect:/curso/" + tema.getCurso().getId();
	}
	
	@GetMapping("/eliminarFichero/{id}")
	public String eliminarTema(Model model,@PathVariable Long id) {
		
		Fichero f = ficheroServicio.findById(id);
		Path ruta = Paths.get(f.getRuta());
		
		
		try {
			Files.delete(ruta);
			ficheroServicio.borrar(f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Tema tema = temaServicio.findById(f.getTema().getId());
		
		
		return "redirect:/curso/" + tema.getCurso().getId();
	}
	
	@GetMapping("/descargarFichero/{idFichero}")
	@ResponseBody
	public void descargarFichero(@PathVariable("idFichero") Long idFichero, HttpServletResponse response){
		
		Fichero f = ficheroServicio.findById(idFichero);
		
		response.setHeader("Content-Disposition","attachment; filename=" + f.getNombre());
		response.setHeader("Content-Transfer-Encoding", "binary");
		
		try {
			BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
			FileInputStream fis = new FileInputStream(f.getRuta());
			
			int longitud;
			byte[] buf = new byte[1024];
			while((longitud=fis.read(buf))>0) {
				bos.write(buf,0,longitud);
			}
			bos.close();
			response.flushBuffer();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
