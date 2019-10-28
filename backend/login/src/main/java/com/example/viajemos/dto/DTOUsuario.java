package com.example.viajemos.dto;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class DTOUsuario {


	private Integer idUsuario;
	private String nombre;
	private String apellido;
	private String email;
	private String password;
	private String provider;
	private Date fecha_nacimiento;
	private int idCiudad;
	
	
	
	public DTOUsuario(Integer idUsuario, String nombre, String apellido, String email, String password, String provider,
			Date fecha_nacimiento, int idCiudad) {
		super();
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.password = password;
		this.provider = provider;
		this.fecha_nacimiento = fecha_nacimiento;
		this.idCiudad = idCiudad;
	}
	
	public Integer getIdUsuario() {
		return idUsuario;
	}
	
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
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
	
	public String getProvider() {
		return provider;
	}
	
	public void setProvider(String provider) {
		this.provider = provider;
	}
	
	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	
	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
	
	public int getIdCiudad() {
		return idCiudad;
	}
	
	public void setIdCiudad(int idCiudad) {
		this.idCiudad = idCiudad;
	}
	
	
}
