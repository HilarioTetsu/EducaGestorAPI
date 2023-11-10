package com.springboot.app.models.services;

import java.util.List;

import com.springboot.app.models.entity.Persona;

public interface IPersonaService {
	
	
	
	
	public void save(Persona p);
	
	public Persona findById(String id);
	
	public Persona findByEmail(String id);
	
	public List<Persona> findAll();
	
	public void deleteById(String id);
	

}
