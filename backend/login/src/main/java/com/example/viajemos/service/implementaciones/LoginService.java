package com.example.viajemos.service.implementaciones;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.viajemos.dto.DTOUsuario;
import com.example.viajemos.entity.Usuario;
import com.example.viajemos.enumerados.Providers;
import com.example.viajemos.repository.IUsuarioRepository;
import com.example.viajemos.service.interfaces.ILoginService;

@Service
public class LoginService implements ILoginService{

	@Autowired
	private IUsuarioRepository usuarioRepository;
	
	@Override
	public List<DTOUsuario> getUsuario(String email, String password){
		 Optional<Usuario> usuario = this.usuarioRepository.findByEmail(email);
		 List<DTOUsuario> usuarios = new ArrayList<DTOUsuario>();
		 if(usuario.isPresent()) {
			 if(Providers.MANUAL.toString().equals(usuario.get().getProvider())){
				 //controlar la password
				 DTOUsuario datosUsuario = new DTOUsuario(usuario.get().getIdUsuario(), usuario.get().getNombre(), usuario.get().getApellido(), usuario.get().getEmail(), usuario.get().getPassword(), usuario.get().getProvider(), usuario.get().getFecha_nacimiento(), usuario.get().getIdCiudad());
				 usuarios.add(datosUsuario);				 
			 }else {
				 //Retornamos el usuario como viene
				 DTOUsuario datosUsuario = new DTOUsuario(usuario.get().getIdUsuario(), usuario.get().getNombre(), usuario.get().getApellido(), usuario.get().getEmail(), usuario.get().getPassword(), usuario.get().getProvider(), usuario.get().getFecha_nacimiento(), usuario.get().getIdCiudad());
				 usuarios.add(datosUsuario); 
			 }
		 }
		return usuarios;
	}
}
