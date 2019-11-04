package com.example.viajemos.dto;

import org.springframework.http.HttpStatus;

public class Respuesta {

	private String mensaje;
	private HttpStatus status;	
	
	public Respuesta(String mensaje, HttpStatus status) {
		super();
		this.mensaje = mensaje;
		this.status = status;
	}
	
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	
	
}
