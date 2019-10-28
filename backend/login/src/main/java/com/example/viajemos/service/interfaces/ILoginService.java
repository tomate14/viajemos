package com.example.viajemos.service.interfaces;

import java.util.List;

import com.example.viajemos.dto.DTOUsuario;

public interface ILoginService {

	public List<DTOUsuario> getUsuario(String email, String password);
}
