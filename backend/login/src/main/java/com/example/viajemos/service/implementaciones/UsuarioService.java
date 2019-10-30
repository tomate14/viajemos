package com.example.viajemos.service.implementaciones;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.viajemos.dto.DTOUsuario;
import com.example.viajemos.entity.Usuario;
import com.example.viajemos.repository.IUsuarioRepository;
import com.example.viajemos.service.interfaces.IUsuarioService;

@Service
public class UsuarioService implements IUsuarioService{

	@Autowired
	private IUsuarioRepository usuarioRepository;
	
	@Override
	public DTOUsuario agregarUsuario(Usuario usuario) throws Exception {
		try {
			Usuario newUsuario = this.usuarioRepository.save(usuario);
			return new DTOUsuario(newUsuario.getIdUsuario(), newUsuario.getNombre(), newUsuario.getApellido(), newUsuario.getEmail(), newUsuario.getPassword(),
								  newUsuario.getProvider(), newUsuario.getFecha_nacimiento(), newUsuario.getIdCiudad());
			
		} catch (Exception e) {
			return null;
		}
		
	}

	@Override
	public Optional<Usuario> getUsuario(String email) throws Exception{
		Optional<Usuario> newUsuario = this.usuarioRepository.findByEmail(email);
		return newUsuario;
	}

}
