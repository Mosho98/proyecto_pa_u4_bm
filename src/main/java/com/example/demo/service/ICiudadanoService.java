package com.example.demo.service;

import java.util.List;

import com.example.demo.modelo.Ciudadano_;

public interface ICiudadanoService {

	public List<Ciudadano_> consultarTodos();
	public void convertir(Ciudadano_ ciudadano );
}
