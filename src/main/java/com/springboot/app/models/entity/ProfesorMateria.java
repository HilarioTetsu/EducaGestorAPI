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
import jakarta.persistence.Index;
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
@Table(name = "profesores_materias",indexes = {@Index(columnList = "profesor_id, materia_id,semestre_nombre_id",unique = true)})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfesorMateria implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6972351480976974130L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "profesor_materia_id")
	private Integer profesorMateriaId;
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "profesor_id",referencedColumnName = "profesor_id")
	private Profesor profesor;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "materia_id",referencedColumnName = "materia_id")
	private Materia materia;
	
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "semestre_nombre_id",referencedColumnName = "semestre_nombre_id")
	private SemestreNombre semestreNombre;
	
	
	@OneToMany(mappedBy = "profesorMateria",fetch = FetchType.LAZY)
	private List<AlumnoMateria> listAlumnoMateria;
	
	@OneToMany(mappedBy = "profesorMateria",fetch = FetchType.LAZY)
	private List<Asistencia> listAsistencia;
	
	@OneToMany(mappedBy = "profesorMateria",fetch = FetchType.LAZY)
	private List<Clase> listClase;
	
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
