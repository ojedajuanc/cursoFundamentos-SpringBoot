package com.fundamentos.SpringBoot.fundamentos.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fundamentos.SpringBoot.fundamentos.bean.NombreCompleto;
import com.fundamentos.SpringBoot.fundamentos.bean.implementation.NombreCompletoImpl;
import com.fundamentos.SpringBoot.fundamentos.model.User;

@Configuration
@EnableConfigurationProperties(User.class)
public class ConfiguracionValores {
	@Value("${value.nombre}")
	private String nombre;
	
	@Value("${value.apellido}")
	private String apellido;
	
	@Bean
	public NombreCompleto funcion() {
		return new NombreCompletoImpl(nombre, apellido);
	}

}
