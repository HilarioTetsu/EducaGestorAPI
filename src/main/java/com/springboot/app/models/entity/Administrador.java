package com.springboot.app.models.entity;

import java.io.Serializable;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
@Table(name = "administradores")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Administrador implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1484673061694639356L;

	@Id
	@Column(length = 36, name = "admin_id")
	private String adminId;
	
	@Column(length = 20,nullable = false)
	@NotBlank
	@Size(max = 20)
	private String username;
	
	@Column(length = 255,nullable=false)
	@NotBlank
	@Size(max = 255)
	private String email;
	
	@Column(length = 60,nullable=false)
	@NotBlank
	@Size(max = 60)
	private String password;
	
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
	
	@NotNull
	private Boolean enabled;

}
