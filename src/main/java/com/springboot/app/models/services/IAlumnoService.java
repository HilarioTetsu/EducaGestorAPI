package com.springboot.app.models.services;

import com.springboot.app.models.dto.AlumnoDTO;
import com.springboot.app.models.entity.Alumno;

public interface IAlumnoService {

	
	public void save(Alumno alumno);
	
	public void save(AlumnoDTO alumno);
}
