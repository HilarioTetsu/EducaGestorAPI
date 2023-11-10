package com.springboot.app.models.services;

import com.springboot.app.models.entity.Carrera;

public interface ICarreraService {

	public void save(Carrera carrera);
	
	public Carrera findById(Byte carreraId);
	
}
