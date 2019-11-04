package com.example.viajemos.service.implementaciones;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.viajemos.dto.DTOUsuario;
import com.example.viajemos.dto.Respuesta;
import com.example.viajemos.entity.Usuario;
import com.example.viajemos.repository.IEnviarEmail;
import com.example.viajemos.repository.IUsuarioRepository;
import com.example.viajemos.service.interfaces.IUsuarioService;

@Service
public class UsuarioService implements IUsuarioService{

	@Autowired
	private IUsuarioRepository usuarioRepository;
	
	@Autowired
	private IEnviarEmail enviarEmailRepository;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;

	
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

	@Override
	public ResponseEntity<Respuesta> resetPassword(String email) throws Exception {
		try {
			Optional<Usuario> usuario = this.usuarioRepository.findByEmail(email);
			if(usuario.isPresent()) {
				String newPassword = UUID.randomUUID().toString();
				usuario.get().setPassword(bcrypt.encode(newPassword));
				this.usuarioRepository.save(usuario.get());
				return this.enviarEmailRepository.enviarEmail(email, newPassword, "Hola como estas", "Cuerpo del email");			
			}			
		} catch (Exception e) {
			throw new Exception(e.getCause());
//			return new ResponseEntity<Respuesta>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return null;
	}


}
