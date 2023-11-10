package com.springboot.app.models.entity;

import java.io.Serializable;


import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "asistencias")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Asistencia implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6694647887238493383L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "asistencia_id")
	private Integer asistenciaId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "alumno_id",referencedColumnName = "alumno_id")
	private Alumno alumno;
	
	@NotNull
	@Column(name = "asistencia_status")
	private Byte asistenciaStatus;
	
	@NotNull
	@Column(name = "fecha_asistencia")
	private LocalDate fechaAsistencia;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="profesor_materia_id",referencedColumnName = "profesor_materia_id")
	private ProfesorMateria profesorMateria;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_creacion")
	@NotNull
	private Date fechaCreacion;

	@Column(length = 20,name = "usuario_creacion")
	@NotBlank
	@Size(max = 20)
	private String usuarioCreacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion",nullable = true)
	private Date fechaModificacion;

	@Column(length = 20,nullable = true,name="usuario_modificacion")
	@NotBlank
	@Size(max = 20)
	private String usuarioModificacion;

	@NotNull
	private Short status;
	
}
