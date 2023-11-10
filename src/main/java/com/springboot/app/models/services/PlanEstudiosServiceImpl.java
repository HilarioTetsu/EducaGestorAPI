package com.springboot.app.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.app.models.dao.IPlanEstudiosDao;
import com.springboot.app.models.entity.PlanEstudios;

@Service
public class PlanEstudiosServiceImpl implements IPlanEstudiosService {

	@Autowired
	private IPlanEstudiosDao planEstudiosDao;
	
	@Override
	public void save(PlanEstudios pe) {
		planEstudiosDao.save(pe);

	}

}
