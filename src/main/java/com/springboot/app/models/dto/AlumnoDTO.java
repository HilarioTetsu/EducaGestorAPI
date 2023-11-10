package com.springboot.app.models.dto;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlumnoDTO implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = -5767949939291202736L;

	
	@NotBlank
	private String nombre;
	
	@NotBlank
	private String apellidoPaterno;
	
	@NotBlank
	private String apellidoMaterno;
	
	@NotNull
	private Long telefono;
	
	@NotBlank
	private String email;
	
	@NotBlank
	private String password;
	
	@NotBlank
	private String direccion;
	
	@NotNull
	private Integer codigoPostal;
	
	@NotNull
	private LocalDate fechaNac;
	
	@NotBlank
	private String genero;
	
	@NotNull
	private Short generacion;
	
	@NotNull
	private Byte semestreActual;
	
	@NotNull
	private Byte carreraId;
	
	@NotNull
	private Byte creditosTotales;
	@NotNull
	private Byte planEstudiosId;
	
	

}
