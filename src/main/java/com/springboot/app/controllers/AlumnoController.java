package com.springboot.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.app.models.dto.AlumnoDTO;
import com.springboot.app.models.services.IAlumnoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/educagestor/v1/alumno")
public class AlumnoController {

	@Autowired
	private IAlumnoService alumnoService;
	
	@PostMapping("/crear")
	public ResponseEntity<String> insertarAlumno(@Valid @RequestBody AlumnoDTO dto){
		
		try {
			
			alumnoService.save(dto);
			
			return new ResponseEntity<>("Alumno creado correctamente", HttpStatus.CREATED);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			return new ResponseEntity<>("Error en la operacion:"+e.getMessage(), HttpStatus.BAD_REQUEST);
			
		}
		
		
		
		
	}
	
	
}
