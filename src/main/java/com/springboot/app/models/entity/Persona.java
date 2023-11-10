package com.springboot.app.models.entity;

import java.io.Serializable;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "personas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Persona implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5386431283325583296L;

	@Id
	@Column(name = "persona_id",length = 36)
	private String personaId;
	
	@Column(length = 25,nullable = false)
	@NotBlank
	@Size(max = 25)
	private String nombre;
	
	@Column(length = 20,nullable = false)
	@NotBlank
	@Size(max = 20)
	private String apellidoPaterno;
	
	@Column(length = 20,nullable = false)
	@NotBlank
	@Size(max = 20)
	private String apellidoMaterno;
	
	@NotNull
	@Column(nullable = false)
	private Long telefono;
	
	@Column(length = 255,nullable = false,unique=true)
	@NotBlank
	@Size(max = 255)
	@Email
	private String email;
	
	@Column(length = 60,nullable = false)
	@NotBlank
	@Size(max = 60)
	private String password;
	
	@Column(length = 50,nullable = false)
	@NotBlank
	@Size(max = 50)
	private String direccion;
	
	@NotNull
	@Column(nullable = false)
	private Integer codigoPostal;
	
	@Past
	@NotNull
	private LocalDate fechaNac;
	
	@Column(length = 1,nullable = false)
	@NotBlank
	@Size(max = 1)
	private String genero;
	
	@Column(length = 15,nullable = false)
	@NotBlank
	private String role;
	
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
	@Size(max = 20)
	private String usuarioModificacion;
	
	@NotNull
	private Short status;
	
	private Boolean enabled;
	
	@OneToOne(mappedBy = "persona",fetch = FetchType.LAZY)
	private Profesor profesor;
	
	@OneToOne(mappedBy = "persona",fetch = FetchType.LAZY)
	private Alumno alumno;

	 @PreUpdate
	    public void preUpdateFunction(){
		 fechaModificacion=new Date();
	    }
	 
	 @PrePersist
	    public void preInsertFunction(){
		 fechaCreacion=new Date();
	    }
}
