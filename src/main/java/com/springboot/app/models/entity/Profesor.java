package com.springboot.app.models.entity;

import java.io.Serializable;

import java.time.LocalDate;

import java.util.Date;
import java.util.List;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
@Table(name = "profesores")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Profesor implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2319996713301563634L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_sec")
	private Integer idSec;
	
	
	@NotBlank
	@Column(name = "profesor_id",length = 10,nullable = true,unique = true)
	@Size(max = 10)
	private String profesorId;
		
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="persona_id")
	private Persona persona;
	
	
	@NotNull
	@Column(name = "fecha_ingreso")
	private LocalDate fechaIngreso;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "academia_id")
	private Academia academia;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "profesor")
	private List<ProfesorMateria> listProfesorMateria;
	
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
