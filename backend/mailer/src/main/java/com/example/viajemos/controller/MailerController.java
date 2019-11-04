package com.example.viajemos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.viajemos.dto.DatosMail;
import com.example.viajemos.dto.Respuesta;
import com.example.viajemos.service.interfaz.IMailerService;

@RestController
public class MailerController {

	@Autowired
	private IMailerService mailerService;
	
	@PostMapping(value = "/sendmail")	
	public ResponseEntity<Respuesta> sendEmail(@RequestBody DatosMail datos) throws Exception{
		return this.mailerService.sendEmail(datos);
	}
	
}
