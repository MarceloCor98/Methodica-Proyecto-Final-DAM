package com.methodica.spring.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="notas")
@IdClass(NotaClave.class)
public class Nota {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private float nota;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_examen")
	private Examen examen;
	
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_alumno")
	private Alumno alumno;

	public Nota() {
	}

	public Nota(long id, int nota, Examen examen, Alumno alumno) {
		super();
		this.id = id;
		this.nota = nota;
		this.examen = examen;
		this.alumno = alumno;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public float getNota() {
		return nota;
	}

	public void setNota(float nota) {
		this.nota = nota;
	}

	public Examen getExamen() {
		return examen;
	}

	public void setExamen(Examen examen) {
		this.examen = examen;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	
	
	
	
}
