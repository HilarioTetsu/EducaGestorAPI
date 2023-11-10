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
@Table(name = "alumnos_materias")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlumnoMateria implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4016233520349394472L;



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="alumno_id",referencedColumnName = "alumno_id")
	private Alumno alumno;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "profesor_materia_id")
	private ProfesorMateria profesorMateria;
	
	
	@OneToMany(mappedBy = "alumnoMateria",fetch = FetchType.LAZY)
	private List<Calificacion> calificacionList;
	
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
