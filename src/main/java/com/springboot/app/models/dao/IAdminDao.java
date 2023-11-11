package com.springboot.app.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.app.models.entity.Administrador;

public interface IAdminDao extends JpaRepository<Administrador, String>{

	
	public Administrador findByEmailOrUsername(String email,String username);
}
