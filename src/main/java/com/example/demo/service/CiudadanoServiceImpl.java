package com.example.demo.service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.funcional.ICiudadanoFunction;
import com.example.demo.modelo.Ciudadano_;
import com.example.demo.modelo.Estudiante;
import com.example.demo.repository.ICiudadanoRepository1;

@Service
public class CiudadanoServiceImpl implements ICiudadanoService{
	private static final Logger LOG = LoggerFactory.getLogger(CiudadanoServiceImpl.class);
	@Autowired
	private ICiudadanoRepository1 ciudadanoRepository1;
	@Autowired
	private IEstudianteService estudianteService;

	@Override
	public List<Ciudadano_> consultarTodos() {
		// TODO Auto-generated method stub
		return this.ciudadanoRepository1.consultarTodos();
	}


	@Override
	public void convertir(Ciudadano_ ciudadano) {
		// TODO Auto-generated method stub
				ICiudadanoFunction<Estudiante, Ciudadano_> function= ciu ->{
					Estudiante est=new Estudiante();
					
					est.setNombreCompleto(ciu.getNombre()+" "+ciu.getApellido());
					int edadfinal=(int) ChronoUnit.YEARS.between(LocalDateTime.now(), ((Ciudadano_) ciu).getFechaNacimiento());
					est.setEdad(edadfinal);
					return est;
				};
				Ciudadano_ ciu=new Ciudadano_();
				ciu.setNombre(ciudadano.getNombre());
				ciu.setApellido(ciudadano.getApellido());
				ciu.setFechaNacimiento(ciudadano.getFechaNacimiento());
				
				Estudiante estuConver=function.aplicarEst(ciu);
				System.out.println("Ciudadano convertido: " + estuConver);
		this.estudianteService.insertar(estuConver);
	}



	

}
