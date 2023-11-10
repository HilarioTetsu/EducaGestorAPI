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
@Table(name = "academias")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Academia implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2057010582978152266L;

	@Id
	@Column(name = "academia_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Byte academiaId;
	
	@Column(length = 50)
	@NotBlank
	@Size(max = 50)
	private String descripcion;
	
	@OneToMany(mappedBy = "academia",fetch = FetchType.LAZY)
	private List<Materia> listMateria;
	
	
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
