package com.methodica.spring.models;

import java.io.Serializable;

public class NotaClave implements Serializable{
	public int id;
	
	
	public Alumno alumno;
	
	public NotaClave() {
		
	}
	
	public NotaClave(int id, Alumno alumno) {
		this.id = id;
		this.alumno = alumno;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alumno == null) ? 0 : alumno.hashCode());
		result = prime * result + id;
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
		NotaClave other = (NotaClave) obj;
		if (alumno == null) {
			if (other.alumno != null)
				return false;
		} else if (!alumno.equals(other.alumno))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
}
