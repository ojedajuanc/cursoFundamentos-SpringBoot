package com.fundamentos.SpringBoot.fundamentos.component;

import org.springframework.stereotype.Component;

@Component
public class Component2Impl implements ComponentDependency {

	@Override
	public void saludar() {
		System.out.println("Hola mundo desde mi SEGUNDO componente");
		
	}

}
