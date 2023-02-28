package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Ciudadano_;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CiudadanoRepoImpl implements ICiudadanoRepository1{

	@PersistenceContext 
	private EntityManager entityManager;
	
	

	@Override
	public List<Ciudadano_> consultarTodos() {
		TypedQuery<Ciudadano_> myQuery = this.entityManager.createQuery(
				"SELECT e FROM Ciudadano_ e", Ciudadano_.class);
	
		List<Ciudadano_> lista = myQuery.getResultList();
//		for(Hotel h: lista) {
//			h.getHabitaciones().size();
//		}
		return lista;
	}

	
}
