package com.example.viajemos.service.interfaz;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.viajemos.dto.DatosMail;
import com.example.viajemos.dto.Respuesta;

@Service
public interface IMailerService{

	public ResponseEntity<Respuesta> sendEmail(DatosMail datos) throws Exception;
}
