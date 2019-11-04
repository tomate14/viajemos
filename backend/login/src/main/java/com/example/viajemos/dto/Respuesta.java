package com.example.viajemos.dto;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

public class Respuesta implements Serializable{

	private String mensaje;
	private HttpStatus status;	
	private int statusCode;
	
	
	
	public Respuesta() {
		super();
	}

	public Respuesta(String mensaje, HttpStatus status) {
		super();
		this.mensaje = mensaje;
		this.status = status;
		this.statusCode = status.value();
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

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	
	
	
}
