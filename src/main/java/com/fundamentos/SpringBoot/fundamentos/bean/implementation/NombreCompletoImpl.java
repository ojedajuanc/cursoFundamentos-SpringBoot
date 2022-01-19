package com.fundamentos.SpringBoot.fundamentos.bean.implementation;

import com.fundamentos.SpringBoot.fundamentos.bean.NombreCompleto;

public class NombreCompletoImpl implements NombreCompleto{
	
	private String nombre;
	private String apellido;

	public NombreCompletoImpl(String nombre, String apellido) {
		this.nombre = nombre;
		this.apellido = apellido;
	}

	@Override
	public String function() {
		return nombre + " " + apellido;
	}

}
