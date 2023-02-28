
	 package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.modelo.Ciudadano_;
import com.example.demo.service.ICiudadanoService;



@SpringBootApplication
public class ProyectoPaU4BmApplication implements CommandLineRunner{

	@Autowired
	private ICiudadanoService ciudadanoService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoPaU4BmApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
List<Ciudadano_> ciudadanos= this.ciudadanoService.consultarTodos();
long tiempoInicial = System.currentTimeMillis();
		System.out.println("LISTA");
		for(Ciudadano_ ciud: ciudadanos) {
			System.out.println(ciud);
			
			this.ciudadanoService.convertir(ciud);
			
			
			
		}
		long tiempofinal = System.currentTimeMillis();
		long tiempoTranscurrido = (tiempofinal - tiempoInicial) / 1000;
		ciudadanos.forEach(cadena -> System.out.println(cadena));
		System.out.println("Tiempo transcurrido en seg: " + tiempoTranscurrido);
		System.out.println("--------------------------------------------------");
		
		
		
	
	}

}
