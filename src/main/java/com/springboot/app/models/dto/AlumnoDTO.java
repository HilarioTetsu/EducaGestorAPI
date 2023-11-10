package com.springboot.app.models.dto;

import java.io.Serializable;
import java.time.LocalDate;

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

	
	private String nombre;
	
	private String apellidoPaterno;
	
	private String apellidoMaterno;
	
	private Long telefono;
	
	private String email;
	
	private String password;
	
	private String direccion;
	
	private Integer codigoPostal;
	
	private LocalDate fechaNac;
	
	private String genero;
	
	private Short generacion;
	
	private Byte semestreActual;
	
	private Byte carreraId;
	
	private Byte creditosTotales;
	
	private Byte planEstudiosId;
	
	

}
