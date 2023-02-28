package com.example.demo.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
@Entity
@Table(name = "estudiante_p")

public class Estudiante {
	@Id
	// name = cualquier o el nombre de la secuencia
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_estu")
	@SequenceGenerator(name = "seq_estu", sequenceName = "seq_estu", allocationSize = 1)
	@Column(name = "estu_id")
	private Integer id;
	
	@Column(name = "estu_nombre_completo")
	private Integer nombreCompleto;
	
	@Column(name = "estu_edad")
	private Integer edad;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(Integer nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "Estudiante [id=" + id + ", nombreCompleto=" + nombreCompleto + ", edad=" + edad + "]";
	}
	
	
	
	
}
