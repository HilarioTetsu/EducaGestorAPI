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
@Table(name = "plan_estudios")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlanEstudios implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7775002494156838222L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="plan_estudios_id")
	private Byte planEstudiosId;
	
	@NotBlank
	@Column(length = 30)
	@Size(max = 30)
	private String nombre;
	
	@NotBlank
	@Column(length = 100)
	@Size(max = 100)
	private String descripcion;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="carrera_id")
	private Carrera carrera;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "planEstudios")
	private List<Materia> listMateria;
	
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "planEstudios")
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
	
	 @PreUpdate
	    public void preUpdateFunction(){
		 fechaModificacion=new Date();
	    }
	 
	 @PrePersist
	    public void preInsertFunction(){
		 fechaCreacion=new Date();
	    }
	
}
