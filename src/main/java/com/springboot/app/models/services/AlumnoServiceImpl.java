package com.springboot.app.models.services;

import java.util.NoSuchElementException;


import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.app.models.dao.IAlumnoDao;
import com.springboot.app.models.dto.AlumnoDTO;
import com.springboot.app.models.entity.Alumno;
import com.springboot.app.models.entity.Persona;
import com.springboot.app.models.entity.PlanEstudios;
import com.springboot.app.utils.Constants;

import jakarta.transaction.Transactional;

import com.springboot.app.models.entity.Carrera;

@Service
public class AlumnoServiceImpl implements IAlumnoService {

	@Autowired
	private IAlumnoDao alumnoDao;
	
	@Autowired 
	private ICarreraService carreraService;
	
	@Autowired
	private IPlanEstudiosService planEstudiosService;
	
	@Autowired
	private IPersonaService personaService;
	

	

	
	
	
	@Override
	public void save(Alumno alumno) {
		alumnoDao.save(alumno);

	}

	@Override
	@Transactional
	public void save(AlumnoDTO dto) {
		Alumno alumno = new Alumno();
		
		Persona persona = new Persona();
		
		PlanEstudios pe=planEstudiosService.findById(dto.getPlanEstudiosId());
		
		Carrera carrera = carreraService.findById(dto.getCarreraId());
		
		if (carrera==null || pe==null) {
			throw new NoSuchElementException("Carrera o Plan de estudios no encontrado");
		}
		
		persona.setPersonaId(UUID.randomUUID().toString());
		persona.setNombre(dto.getNombre());
		persona.setApellidoMaterno(dto.getApellidoMaterno());
		persona.setApellidoPaterno(dto.getApellidoPaterno());
		persona.setTelefono(dto.getTelefono());
		persona.setEmail(dto.getEmail());
		persona.setPassword(dto.getPassword());
		persona.setDireccion(dto.getDireccion());
		persona.setCodigoPostal(dto.getCodigoPostal());
		persona.setFechaNac(dto.getFechaNac());
		persona.setGenero(dto.getGenero());
		persona.setUsuarioCreacion("ADMIN");
		persona.setStatus(Constants.STATUS_ACTIVO);
		persona.setRole("ROLE_ALUMNO");
		personaService.save(persona);
		
		alumno.setPersona(persona);
		alumno.setCarrera(carrera);
		alumno.setPlanEstudios(pe);
		alumno.setGeneracion(dto.getGeneracion());
		alumno.setSemestreActual(dto.getSemestreActual());
		alumno.setCreditosTotales(dto.getCreditosTotales());
		alumno.setUsuarioCreacion("ADMIN");
		alumno.setStatus(Constants.STATUS_ACTIVO);
		
		save(alumno);
		
		

	}

}
