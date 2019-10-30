package com.example.viajemos.service.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.viajemos.dto.DTOUsuario;
import com.example.viajemos.entity.Usuario;

public interface ILoginService {
	
	public ResponseEntity<Usuario> agregarUsuario(Usuario usuario);
}
