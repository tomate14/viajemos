package com.example.viajemos.dto.mailer;

import java.io.Serializable;

public class DatosMail implements Serializable{

	private String email;
	private String password;
	private String titulo;
	private String mensaje;
	
	
	
	public DatosMail(String email, String password, String titulo, String mensaje) {
		super();
		this.email = email;
		this.password = password;
		this.titulo = titulo;
		this.mensaje = mensaje;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	
}
