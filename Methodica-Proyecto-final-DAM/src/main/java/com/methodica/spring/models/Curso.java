package com.methodica.spring.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cursos")
public class Curso {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String nombre;
	@Column(length = 2000)
	private String descripcion;
	private String claveMatricula;
		
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "id_profesor")
    private Profesor profesor;
	
	@ManyToMany(mappedBy = "cursos")
	Set<Alumno> alumnosMatriculados = new HashSet<>();
	
	public Curso() {
		
	}	

	public Curso(String nombre, String descripcion, String claveMatricula) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.claveMatricula = claveMatricula;
	}


	public Curso(String nombre, String descripcion, Profesor profesor) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.profesor = profesor;
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}	
	

	public String getClaveMatricula() {
		return claveMatricula;
	}

	public void setClaveMatricula(String claveMatricula) {
		this.claveMatricula = claveMatricula;
	}

	public Set<Alumno> getAlumnosMatriculados() {
		return alumnosMatriculados;
	}

	public void setAlumnosMatriculados(Set<Alumno> alumnosMatriculados) {
		this.alumnosMatriculados = alumnosMatriculados;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((profesor == null) ? 0 : profesor.hashCode());
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
		Curso other = (Curso) obj;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (id != other.id)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (profesor == null) {
			if (other.profesor != null)
				return false;
		} else if (!profesor.equals(other.profesor))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Curso [id_curso=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", profesor="
				+ profesor + "]";
	}
	
	
	
	

}
