package com.springboot.app.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.app.models.dao.ICarreraDao;
import com.springboot.app.models.entity.Carrera;

@Service
public class CarreraServiceImpl implements ICarreraService {

	@Autowired
	private ICarreraDao carreraDao;
	
	@Override
	public void save(Carrera carrera) {
		
		carreraDao.save(carrera);

	}

	@Override
	public Carrera findById(Byte carreraId) {
		
		Carrera carrera= carreraDao.findById(carreraId).orElse(null);
		
		return carrera;
	}

}
