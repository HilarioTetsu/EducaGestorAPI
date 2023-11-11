package com.springboot.app.models.services;

import com.springboot.app.models.entity.Administrador;

public interface IAdminService {

	public Administrador findByEmailOrUsername(String email,String username);
}
