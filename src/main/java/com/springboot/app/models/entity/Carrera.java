package com.springboot.app.models.entity;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@Table(name = "carreras")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Carrera implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3383401970257283867L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "carrera_id")
	private Byte carreraId;
	
	@NotBlank
	@Column(length = 50)
	@Size(max = 50)
	private String descripcion;
	
	@NotBlank
	@Column(length = 6,nullable = false)
	@Size(max = 6)
	private String acronimo;
	
	
	@OneToMany(mappedBy = "carrera",fetch = FetchType.LAZY)
	private List<PlanEstudios> listPlanEstudio;
	
	@OneToMany(mappedBy = "carrera",fetch = FetchType.LAZY)
	private List<Alumno> listAlumno;
	
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
