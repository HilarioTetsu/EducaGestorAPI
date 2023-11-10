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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "materias")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Materia implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2828745096148609428L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idSec;
	
	@NotBlank
	@Column(length = 17,name = "materia_id",nullable = true,unique = true)
	@Size(max = 17)
	private String materiaId;
	
	@NotBlank
	@Column(length = 50)
	@Size(max = 50)
	private String nombre;
	
	@NotNull
	private Byte creditos;
	
	
	@Column(nullable = true)
	private Byte unidades;
		
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "academia_id",referencedColumnName = "academia_id")
	private Academia academia;
	
	@NotBlank
	@Column(length = 5)
	@Size(max = 5)
	private String acronimo;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "planEstudios_id", referencedColumnName = "plan_estudios_id")
	private PlanEstudios planEstudios;
	
	@OneToMany(mappedBy = "materia",fetch = FetchType.LAZY)
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
