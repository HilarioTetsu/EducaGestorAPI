package com.springboot.app.models.services;

import java.util.List;
import java.util.NoSuchElementException;

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
	
		if (id==null ||id.isBlank() || id.isEmpty()) {
			return null;
		}
		
		Persona p= personaDao.findById(id).orElse(null);
		
		return p;
	}

	@Override
	public Persona findByEmail(String email) {
		
		
		if (email==null ||email.isBlank() || email.isEmpty()) {
			return null;
		}
		
		Persona p= personaDao.findByEmail(email).orElse(null);
		
		
		return p;
	}

	@Override
	public List<Persona> findAll() {
		
		return personaDao.findAll();
	}

	@Override
	public void deleteById(String id) throws NoSuchElementException {
		
		Persona p= findById(id);
		
		if (p==null) {
			throw new NoSuchElementException("Elemento no encontrado");
		}
		
		personaDao.delete(p);

	}

}
