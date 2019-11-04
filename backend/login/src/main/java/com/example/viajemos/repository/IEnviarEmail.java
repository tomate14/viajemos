package com.example.viajemos.repository;


import org.springframework.http.ResponseEntity;

import com.example.viajemos.dto.Respuesta;

public interface IEnviarEmail {

	public ResponseEntity<Respuesta> enviarEmail(String email, String newPassword, String titulo, String mensaje);
	
}
