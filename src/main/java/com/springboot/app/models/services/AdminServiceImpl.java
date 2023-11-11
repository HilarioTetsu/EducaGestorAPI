package com.springboot.app.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.app.models.dao.IAdminDao;
import com.springboot.app.models.entity.Administrador;

@Service
public class AdminServiceImpl implements IAdminService {

	@Autowired
	private IAdminDao adminDao;
	
	
	@Override
	public Administrador findByEmailOrUsername(String email, String username) {
		
		return adminDao.findByEmailOrUsername(email, username);
	}

}
