package com.example.viajemos.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.viajemos.config.JwtTokenUtil;
import com.example.viajemos.config.JwtUserDetailsService;
import com.example.viajemos.dto.DTOUsuario;
import com.example.viajemos.dto.JwtRequest;
import com.example.viajemos.dto.JwtResponse;
import com.example.viajemos.entity.Usuario;
import com.example.viajemos.service.interfaces.IUsuarioService;

@RestController
@CrossOrigin
public class JwtAuthenticationController {
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private JwtUserDetailsService userDetailsService;
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	@PostMapping(value = "/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());
		final String token = jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(new JwtResponse(token));
	}
	
	@PostMapping(value = "/registro")
	public ResponseEntity<Object> createUser(@RequestBody Usuario usuario) throws Exception {
		try {
			usuario.setPassword(bcrypt.encode(usuario.getPassword()));
			Optional<Usuario> user = this.usuarioService.getUsuario(usuario.getEmail());
			if(user.isEmpty()) {
				DTOUsuario newUser = this.usuarioService.agregarUsuario(usuario);
				final UserDetails userDetails = userDetailsService
						.loadUserByUsername(newUser.getEmail());
				final String token = jwtTokenUtil.generateToken(userDetails);
				return ResponseEntity.ok(new JwtResponse(token));				
			}else {
				return new ResponseEntity<Object>("Usuario ya registrado en el sistema", HttpStatus.ACCEPTED);
			}
			
		} catch (Exception e) {
			ResponseEntity<Object> response = new ResponseEntity<Object>(e.getMessage(), HttpStatus.CONFLICT);
			return response;
		}
	}
	
	
	
	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}
