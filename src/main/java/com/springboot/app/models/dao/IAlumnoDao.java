package com.springboot.app.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.app.models.entity.Alumno;

public interface IAlumnoDao extends JpaRepository<Alumno, Integer>{

}
