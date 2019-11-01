package com.example.viajemos.config;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.viajemos.entity.Usuario;
import com.example.viajemos.repository.IUsuarioRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	@Autowired
	private IUsuarioRepository usuarioRepository;
	
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<Usuario> usuario = usuarioRepository.findByEmail(email);
		UserDetails userDet = new User(usuario.get().getEmail(), usuario.get().getPassword(),new ArrayList<>());
		try {
			final String uri = "localhost:8081/hello";

		    RestTemplate restTemplate = new RestTemplate();
		    String result = restTemplate.getForObject(uri, String.class);
		    System.out.println(result);
				
		} catch (Exception e) {
			System.out.println();
			// TODO: handle exception
		}
		return userDet;

	}

}
