package com.example.viajemos.service.implementaciones;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
	
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	private final static String CONSTANTE_PASSWORD = "b2kjs891mj";

	@Override
	public ResponseEntity<Usuario> agregarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		Usuario user = null;
		try {
			user = this.usuarioRepository.save(usuario); 		
			if (user != null) {
				return new ResponseEntity<Usuario>(user,HttpStatus.OK);
			}else {
				return new ResponseEntity<Usuario>(user, HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<Usuario>(user, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
//	@Override
//	public ResponseEntity<List<DTOUsuario>> getUsuario(String email, String password){
//         List<DTOUsuario> usuarios = new ArrayList<DTOUsuario>();
//		 Optional<Usuario> usuario = Optional.empty();
//		 password = this.bCryptPasswordEncoder.encode(CONSTANTE_PASSWORD+password);
//		 try {
//			 usuario = this.usuarioRepository.findByEmail(email);
//			
//   	     } catch (Exception e) {
//			// TODO: handle exception
//   	    	return new ResponseEntity<List<DTOUsuario>>(usuarios,HttpStatus.INTERNAL_SERVER_ERROR); 
//		 }
//		 
//		 if(usuario.isPresent()) {
//			 if(Providers.MANUAL.toString().equals(usuario.get().getProvider())){
//				 //controlar la password
//				 DTOUsuario datosUsuario = new DTOUsuario(usuario.get().getIdUsuario(), usuario.get().getNombre(), usuario.get().getApellido(), usuario.get().getEmail(), usuario.get().getPassword(), usuario.get().getProvider(), usuario.get().getFecha_nacimiento(), usuario.get().getIdCiudad());
//				 usuarios.add(datosUsuario);				 
//			 }else {
//				 //Retornamos el usuario como viene
//				 DTOUsuario datosUsuario = new DTOUsuario(usuario.get().getIdUsuario(), usuario.get().getNombre(), usuario.get().getApellido(), usuario.get().getEmail(), usuario.get().getPassword(), usuario.get().getProvider(), usuario.get().getFecha_nacimiento(), usuario.get().getIdCiudad());
//				 usuarios.add(datosUsuario); 
//			 }
//			 return new ResponseEntity<List<DTOUsuario>>(usuarios,HttpStatus.OK);
//		 }else {
//			 return new ResponseEntity<List<DTOUsuario>>(usuarios,HttpStatus.NOT_FOUND);
//		 }
//	
//	}

}
