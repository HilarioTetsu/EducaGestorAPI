package com.springboot.app.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.app.models.entity.Carrera;

public interface ICarreraDao extends JpaRepository<Carrera, Byte>{

}
