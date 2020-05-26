package com.methodica.spring.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ficheros")
public class Fichero {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private String nombre;
	private String ruta;
	private String tipo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tema")
	private Tema tema;
	
	public Fichero() {
		
	}
	
	public Fichero(String nombre, String ruta, String tipo, Tema tema) {
		
		this.nombre = nombre;
		this.ruta = ruta;
		this.tipo = tipo;
		this.tema = tema;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}
	
	

}
