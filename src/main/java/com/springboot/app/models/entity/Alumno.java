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
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
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
@Table(name = "alumnos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Alumno implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8656812121391019579L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_sec")
	private Integer idSec;


	@Column(length = 11, unique = true, name = "alumno_id", nullable = true)
	@Size(max = 11)
	private String alumnoId;
		

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "persona_id")
	private Persona persona;
	
	@NotNull
	private Short generacion;

	@NotNull
	@Column(name = "semestre_actual")
	private Byte semestreActual;

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "carrera_id")
	private Carrera carrera;
	

	@NotNull
	@Column(name = "creditos_totales")
	private Byte creditosTotales;


	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "plan_estudios_id")
	private PlanEstudios planEstudios;
	
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "alumno")
	private List<AlumnoMateria> listAlumnoMateria;
	
	

	@OneToMany(fetch = FetchType.LAZY,mappedBy = "alumno")
	private List<Asistencia> asistencia;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_creacion")
	@NotNull
	private Date fechaCreacion;

	@Column(length = 20, name = "usuario_creacion")
	@NotBlank
	@Size(max = 20)
	private String usuarioCreacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion", nullable = true)
	private Date fechaModificacion;

	@Column(length = 20, nullable = true, name = "usuario_modificacion")
	@Size(max = 20)
	private String usuarioModificacion;

	@NotNull
	private Short status;
	
	 @PreUpdate
	    public void preUpdateFunction(){
		 fechaModificacion=new Date();
	    }
	 
	 @PrePersist
	    public void preInsertFunction(){
		 fechaCreacion=new Date();
	    }

}
