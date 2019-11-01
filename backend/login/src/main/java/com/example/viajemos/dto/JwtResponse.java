package com.example.viajemos.dto;

import java.io.Serializable;

import com.example.viajemos.entity.Usuario;

public class JwtResponse implements Serializable {
	private static final long serialVersionUID = -8091879091924046844L;
	private final String jwttoken;
	private DTOUsuario usuario;
	
	public JwtResponse(String jwttoken, Usuario usuario) {
		this.jwttoken = jwttoken;
		this.usuario = new DTOUsuario(usuario.getNombre(), usuario.getApellido(), usuario.getEmail(), usuario.getIdCiudad());
	}
	
	public JwtResponse(String jwttoken, DTOUsuario usuario) {
		this.jwttoken = jwttoken;
		this.usuario = new DTOUsuario(usuario.getNombre(), usuario.getApellido(), usuario.getEmail(), usuario.getIdCiudad());
	}
	
	public String getToken() {
		return this.jwttoken;
	}

	public DTOUsuario getUsuario() {
		return usuario;
	}

	
	
}
