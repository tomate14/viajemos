package com.example.viajemos.repository.implementacion;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.example.viajemos.dto.Respuesta;
import com.example.viajemos.dto.mailer.DatosMail;
import com.example.viajemos.repository.IEnviarEmail;

@Repository
public class EnviadorMail implements IEnviarEmail{

//	@Autowired
//	private JavaMailSender javaMailSender;	

	
	@Override
	public ResponseEntity<Respuesta> enviarEmail(String email, String newPassword, String titulo, String mensaje) {
		
		final String uri = "http://localhost:8082/sendmail";

	    RestTemplate restTemplate = new RestTemplate();
	    
	    DatosMail datos = new DatosMail(email, newPassword, titulo, mensaje);
	    ResponseEntity<Respuesta> result = null;
	    try {
	    	result = restTemplate.postForEntity(uri,datos, Respuesta.class);
			
		} catch (Exception e) {
			System.out.println(e.toString());
			// TODO: handle exception
		}
	    return result;

		
	}

}
