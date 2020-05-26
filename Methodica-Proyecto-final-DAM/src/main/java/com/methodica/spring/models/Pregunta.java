package com.methodica.spring.models;

import javax.persistence.CascadeType;
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
@Table( name = "preguntas")
public class Pregunta {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(length = 2000)
	private String texto;
	private float puntuacion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_examen")
	private Examen examen;
	
	public Pregunta() {
		
	}

	public Pregunta(String texto, int puntuacion, Examen examen) {
		super();
		this.texto = texto;
		this.puntuacion = puntuacion;
		this.examen = examen;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public float getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(float puntuacion) {
		this.puntuacion = puntuacion;
	}

	public Examen getExamen() {
		return examen;
	}

	public void setExamen(Examen examen) {
		this.examen = examen;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((examen == null) ? 0 : examen.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + Float.floatToIntBits(puntuacion);
		result = prime * result + ((texto == null) ? 0 : texto.hashCode());
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
		Pregunta other = (Pregunta) obj;
		if (examen == null) {
			if (other.examen != null)
				return false;
		} else if (!examen.equals(other.examen))
			return false;
		if (id != other.id)
			return false;
		if (Float.floatToIntBits(puntuacion) != Float.floatToIntBits(other.puntuacion))
			return false;
		if (texto == null) {
			if (other.texto != null)
				return false;
		} else if (!texto.equals(other.texto))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pregunta [id=" + id + ", texto=" + texto + ", puntuacion=" + puntuacion + ", examen=" + examen + "]";
	}
	
	
	
	
}
