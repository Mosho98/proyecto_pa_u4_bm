package com.example.demo.paralelo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MainSecuencial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> idEstudiantes = new ArrayList<>();
		for(int i = 1; i<=10; i++) {
			idEstudiantes.add(i);
		}

		idEstudiantes.forEach(numero -> System.out.println("Estudiante: " + numero));
		
		//Precesar cada estudiante
		long tiempoInicial = System.currentTimeMillis();
		List<String> listaFinal = new ArrayList<>();
		
		for(Integer id:idEstudiantes) {
			listaFinal.add(procesarIdEstudiante(id));
		}
		long tiempoFinal = System.currentTimeMillis();
		long tiempoTranscurrido = (tiempoFinal-tiempoInicial)/1000;
		listaFinal.forEach(cadena -> System.out.println(cadena));
		System.out.println("Tiempo transcurrido es segundo: " + tiempoTranscurrido);
		}
	
	public static String procesarIdEstudiante(Integer idEstudiante) {
		//Convertir a string
		String idConvertido = "E" + idEstudiante.toString();
		//Insertar en la base
		System.out.println("Insertando Estudiante: " + idConvertido + " Hilo: " + Thread.currentThread().getName());
		//1 segundo en demora
		try {
			//1 SEGUNDO
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return idConvertido;
	}

}
