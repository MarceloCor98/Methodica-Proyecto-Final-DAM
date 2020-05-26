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
@Table(name = "examenes")
public class Examen { 
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private boolean activo;
	private boolean corregido;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "id_tema", nullable = true)
	private Tema tema;
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "id_curso", nullable = true)
	private Curso curso;
	
	public Examen() {
		
	}

	public Examen(boolean pendienteDeHacer, boolean corregido, Tema tema, Curso curso) {
		this.activo = pendienteDeHacer;
		this.corregido = corregido;
		this.tema = tema;
		this.curso = curso;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isPendienteDeHacer() {
		return activo;
	}

	public void setPendienteDeHacer(boolean pendienteDeHacer) {
		this.activo = pendienteDeHacer;
	}

	public boolean isCorregido() {
		return corregido;
	}

	public void setCorregido(boolean corregido) {
		this.corregido = corregido;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (corregido ? 1231 : 1237);
		result = prime * result + ((curso == null) ? 0 : curso.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + (activo ? 1231 : 1237);
		result = prime * result + ((tema == null) ? 0 : tema.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Examen other = (Examen) obj;
		if (corregido != other.corregido)
			return false;
		if (curso == null) {
			if (other.curso != null)
				return false;
		} else if (!curso.equals(other.curso))
			return false;
		if (id != other.id)
			return false;
		if (activo != other.activo)
			return false;
		if (tema == null) {
			if (other.tema != null)
				return false;
		} else if (!tema.equals(other.tema))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Examen [id=" + id + ", pendienteDeHacer=" + activo + ", corregido=" + corregido + ", tema="
				+ tema + ", curso=" + curso + "]";
	}
	
	
	

}
