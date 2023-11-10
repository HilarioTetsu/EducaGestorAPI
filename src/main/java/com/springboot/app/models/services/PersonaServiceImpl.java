package com.springboot.app.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.app.models.dao.IPersonaDao;
import com.springboot.app.models.entity.Persona;

@Service
public class PersonaServiceImpl implements IPersonaService {

	@Autowired
	private IPersonaDao personaDao;
	
	@Override
	public void save(Persona p) {
		personaDao.save(p);

	}

	@Override
	public Persona findById(String id) {
		// TODO Auto-generated method stub
		return personaDao.findById(id).orElse(null);
	}

	@Override
	public Persona findByEmail(String email) {
		
		
		return personaDao.findByEmail(email).orElse(null);
	}

	@Override
	public List<Persona> findAll() {
		// TODO Auto-generated method stub
		return personaDao.findAll();
	}

	@Override
	public void deleteById(String id) {
		personaDao.deleteById(id);
	}

}
