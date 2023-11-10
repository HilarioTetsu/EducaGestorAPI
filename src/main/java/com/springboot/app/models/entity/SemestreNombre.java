package com.springboot.app.models.entity;

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
@Table(name = "semestre_nombres")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SemestreNombre {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "semestre_nombre_id")
	private Byte semestreNombreId;

	@NotBlank
	@Column(length = 35)
	@Size(max = 35)
	private String semestre;

	@NotBlank
	@Column(length = 25)
	@Size(max = 25)
	private String acronimo;

	@OneToMany(mappedBy = "semestreNombre",fetch = FetchType.LAZY)
	private List<ProfesorMateria> listProfesorMateria;
	
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
	@NotBlank
	@Size(max = 20)
	private String usuarioModificacion;

	@NotNull
	private Short status;

}
