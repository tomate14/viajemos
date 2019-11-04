package com.example.viajemos.service.implementacion;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.example.viajemos.dto.DatosMail;
import com.example.viajemos.dto.Respuesta;
import com.example.viajemos.service.interfaz.IMailerService;

@Service
public class MailerService implements IMailerService{

	@Autowired
	private JavaMailSender javaMailSender;
	
	private final static String emailFrom = "viajemosapp@gmail.com";
	private final static String paginaReferencia = "www.ole.com.ar";
	
	@Override
	public ResponseEntity<Respuesta> sendEmail(DatosMail datos) throws Exception{
		SimpleMailMessage msg = new SimpleMailMessage();
//        msg.setTo(datos.getEmail());
//
//        msg.setSubject(datos.getTitulo());
//        msg.setText(datos.getMensaje()+ " "+datos.getPassword());
//        msg.setFrom(MailerService.emailFrom);
        
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        helper.setSubject(datos.getTitulo());
        helper.setTo(datos.getEmail());
        helper.setFrom(MailerService.emailFrom);
        helper.setText("<html><body><h1>"+datos.getMensaje()+ " "+datos.getPassword()+"</h1><a href='"+MailerService.paginaReferencia+"'>Presione aqui</a></body></html>", true);
        
        
        ResponseEntity<Respuesta> respuesta = null;
        try {
        	javaMailSender.send(message);
			
        	Respuesta response = new Respuesta("El mail fue enviado correctamente a: "+datos.getEmail(), HttpStatus.OK);
        	respuesta = new ResponseEntity<Respuesta>(response, HttpStatus.OK);
		} catch (Exception e) {
			throw new Exception("El mail no fue enviado correctamente a: "+datos.getEmail());
		}
		return respuesta;
	}

}
