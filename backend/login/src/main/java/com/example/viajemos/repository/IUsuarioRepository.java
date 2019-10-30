package com.example.viajemos.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.viajemos.entity.Usuario;

@Repository
public interface IUsuarioRepository extends CrudRepository<Usuario, Integer> {

	public Optional<Usuario> findByIdUsuario(Integer id);
	
	public Optional<Usuario> findByEmail(String email);
	
	public List<Usuario> findAll();
	
	public Usuario save(Usuario establecimiento);
}
