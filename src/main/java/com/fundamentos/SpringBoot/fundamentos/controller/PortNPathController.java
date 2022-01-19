package com.fundamentos.SpringBoot.fundamentos.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PortNPathController {
	@RequestMapping //para manejar todas las solicitudes a nivel http
	@ResponseBody // para responder un cuerpo
	public ResponseEntity<String> function(){
		return new ResponseEntity<String>("Hola desde controlador", HttpStatus.OK);
	}
}
