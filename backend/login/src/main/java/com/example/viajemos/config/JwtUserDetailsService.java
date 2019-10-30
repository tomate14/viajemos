package com.example.viajemos.config;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.viajemos.entity.Usuario;
import com.example.viajemos.repository.IUsuarioRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	@Autowired
	private IUsuarioRepository usuarioRepository;
	
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<Usuario> usuario = usuarioRepository.findByEmail(email);
		UserDetails userDet = new User(usuario.get().getEmail(), usuario.get().getPassword(),new ArrayList<>());
		return userDet;
		
//		if ("javainuse".equals(email)) {
//			return new User("javainuse", "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
//					new ArrayList<>());
//		} else {
//			throw new UsernameNotFoundException("User not found with username: " + email);
//		}
	}
//	@Override
//	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
////		Optional<Usuario> usuario = usuarioRepository.findByEmail(email);
////		UserDetails userDet = new User(usuario.get().getEmail(), usuario.get().getPassword(),new ArrayList<>());
////		return userDet;
////		if(!usuario.isEmpty()) {
////		}else {
////			throw new UsernameNotFoundException("Usuario no encontrado con el nombre: " + email);
////		}
//	}
}
