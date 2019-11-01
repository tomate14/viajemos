package com.example.viajemos.repository;

public interface IEnviarEmail {

	public boolean enviarEmail(String email, String newPassword, String titulo, String mensaje);
	
}
