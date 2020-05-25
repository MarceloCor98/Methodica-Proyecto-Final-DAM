package com.methodica.spring.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="notas")
public class Nota {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private int nota;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_examen")
	private Examen examen;
	
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

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alumno == null) ? 0 : alumno.hashCode());
		result = prime * result + ((examen == null) ? 0 : examen.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + nota;
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
		Nota other = (Nota) obj;
		if (alumno == null) {
			if (other.alumno != null)
				return false;
		} else if (!alumno.equals(other.alumno))
			return false;
		if (examen == null) {
			if (other.examen != null)
				return false;
		} else if (!examen.equals(other.examen))
			return false;
		if (id != other.id)
			return false;
		if (nota != other.nota)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Nota [id=" + id + ", nota=" + nota + ", examen=" + examen + ", alumno=" + alumno + "]";
	}
	
	
}
