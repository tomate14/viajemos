package com.example.viajemos.repository.implementacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Repository;

import com.example.viajemos.repository.IEnviarEmail;

@Repository
public class EnviadorMail implements IEnviarEmail{

	@Autowired
	private JavaMailSender javaMailSender;	
	
//	@Value("${spring.mail.username}")
//	private String email_from;
	
//	public EnviadorMail(JavaMailSender javaMailSender) {
//        this.javaMailSender = javaMailSender;
//    }
	
	@Override
	public boolean enviarEmail(String email, String newPassword, String titulo, String mensaje) {

        
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(email);

        msg.setSubject(titulo);
        msg.setText(mensaje+ " "+newPassword);
        msg.setFrom("viajemosapp@gmail.com");
        
        javaMailSender.send(msg);
        
        return true;
		
	}

}
