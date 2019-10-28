package com.example.viajemos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.viajemos.dto.DTOUsuario;
import com.example.viajemos.service.interfaces.ILoginService;

@RestController
public class LoginController {

	@Autowired
	private ILoginService loginService;
	
	@GetMapping("/login")
	public List<DTOUsuario> loguearse(@RequestParam String email, @RequestParam(required = false) String password) {
		return loginService.getUsuario(email,password);
	}
}
