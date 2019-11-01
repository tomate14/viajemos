package com.example.viajemos.service.interfaces;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;

import com.example.viajemos.dto.DTOUsuario;
import com.example.viajemos.entity.Usuario;

public interface IUsuarioService {

	public DTOUsuario agregarUsuario(Usuario usuario) throws Exception;
	
	public Optional<Usuario> getUsuario(String email) throws Exception;
	
	public boolean resetPassword(String email) throws Exception;
	
}
