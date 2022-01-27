package com.fundamentos.SpringBoot.fundamentos.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.fundamentos.SpringBoot.fundamentos.bean.NombreCompleto;
import com.fundamentos.SpringBoot.fundamentos.bean.implementation.NombreCompletoImpl;
import com.fundamentos.SpringBoot.fundamentos.model.User;

@Configuration
@PropertySource("classpath:connection.properties")
@EnableConfigurationProperties(User.class)
public class GeneralConfiguration {
	@Value("${value.nombre}")
	private String nombre;
	
	@Value("${value.apellido}")
	private String apellido;
	
	@Value("${jdbc.url}")
	private String jdbcUrl;
	
	@Value("${driver}")
	private String driver;

	@Value("${username}")
	private String username;
	
	@Value("${password}")
	private String password;
		
	@Bean
	public NombreCompleto funcion() {
		return new NombreCompletoImpl(nombre, apellido);
	}
	
//	@Bean
//	public DataSource dataSource() {
//		DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
//		dataSourceBuilder.driverClassName("org.h2.Driver");
//		dataSourceBuilder.url("jdbc:h2:mem:testdb");
//		dataSourceBuilder.username("user");
//		dataSourceBuilder.password("user");
//		return dataSourceBuilder.build();
//	}
	
	//Otra alternativa para configurar jdbc usando archivo properties
	//(NO ES UNA BUENA PRACTICA)
	@Bean
	public DataSource dataSource() {
		DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
		dataSourceBuilder.driverClassName(driver);
		dataSourceBuilder.url(jdbcUrl);
		dataSourceBuilder.username(username);
		dataSourceBuilder.password(password);
		return dataSourceBuilder.build();
	}

}
