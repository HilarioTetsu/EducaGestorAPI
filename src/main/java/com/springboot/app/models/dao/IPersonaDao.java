package com.springboot.app.models.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.app.models.entity.Persona;


public interface IPersonaDao extends JpaRepository<Persona, String>{

	
	public Optional<Persona> findByEmail(String email);
	
}
