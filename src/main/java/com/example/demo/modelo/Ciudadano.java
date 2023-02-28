package com.example.demo.modelo;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "ciudadano_p")
public class Ciudadano {
	
	@Id
	// name = cualquier o el nombre de la secuencia
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_ciud")
	@SequenceGenerator(name = "seq_ciud", sequenceName = "seq_ciud", allocationSize = 1)
	@Column(name = "ciud_id")
	private Integer Id;
	
	@Column(name = "ciud_nombre")
	private String nombre;
	
	@Column(name = "ciud_apellido")
	private String apellido;
	
	@Column(name = "ciud_fecha_naciemiento")
	private LocalDateTime fechaNacimiento;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public LocalDateTime getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	@Override
	public String toString() {
		return "Ciudadano [Id=" + Id + ", nombre=" + nombre + ", apellido=" + apellido + ", fechaNacimiento="
				+ fechaNacimiento + "]";
	}
	
	
	
	

}
