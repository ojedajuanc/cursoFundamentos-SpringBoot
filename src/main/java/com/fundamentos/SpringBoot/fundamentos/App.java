package com.fundamentos.SpringBoot.fundamentos;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fundamentos.SpringBoot.fundamentos.bean.MyBean1;
import com.fundamentos.SpringBoot.fundamentos.bean.NombreCompleto;
import com.fundamentos.SpringBoot.fundamentos.component.ComponentDependency;
import com.fundamentos.SpringBoot.fundamentos.model.User;
import com.fundamentos.SpringBoot.fundamentos.services.BeanWithDependencies;

@SpringBootApplication
public class App implements CommandLineRunner {
	
	private final Log LOGGER = LogFactory.getLog(this.getClass());

	private ComponentDependency componentDependency;
	private MyBean1 myBean;
	private BeanWithDependencies beanWithDependencie;
	private NombreCompleto nombreCompleto;
	private User u1;

	/**
	 * Se utiliza el annotation Qualifier para que SpringBoot sepa a qué componente
	 * llamar cuando dos o más tienen misma implementación
	 */
	public App(@Qualifier("component2Impl") ComponentDependency componentDependency,
			MyBean1 myBean, BeanWithDependencies beanWithDependencie, NombreCompleto nombreCompleto,
			User u1) {
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.beanWithDependencie = beanWithDependencie;
		this.nombreCompleto = nombreCompleto;
		this.u1 = u1;
	}

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		componentDependency.saludar();
		System.out.println(beanWithDependencie.operationWithDependencies());
		System.out.println("Nombre: " + nombreCompleto.function());
		System.out.println("Mail: " + u1.getEmail() + " Edad: " + u1.getAge());
		LOGGER.error("Error de prueba");
		try {
			int value = u1.getAge() / 0;
			System.out.println(value);
		} catch (Exception e) {
			LOGGER.error("No se ingresó un número");
		}
		
	}

}
