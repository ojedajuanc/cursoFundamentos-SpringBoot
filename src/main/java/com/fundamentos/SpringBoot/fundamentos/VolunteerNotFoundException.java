package com.fundamentos.SpringBoot.fundamentos;

public class VolunteerNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1728165579103553855L;

	public VolunteerNotFoundException(Long id) {
		super("No se encontrĂ³ al voluntario con id: " + id);
	}

}
