package com.fundamentos.SpringBoot.fundamentos;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import com.fundamentos.SpringBoot.fundamentos.persistence.User;
import com.fundamentos.SpringBoot.fundamentos.repository.UserRepository;

import sun.util.logging.resources.logging;

@SpringBootApplication
public class App implements CommandLineRunner {
	
	private UserRepository userRepository;
	
	private final Log LOGGER = LogFactory.getLog(this.getClass());
//	private ComponentDependency componentDependency;
//	private MyBean1 myBean;
//	private BeanWithDependencies beanWithDependencie;
//	private NombreCompleto nombreCompleto;
//	private User u1;


	/**
	 * Se utiliza el annotation Qualifier para que SpringBoot sepa a qué componente
	 * llamar cuando dos o más tienen misma implementación
	 */
//	public App(@Qualifier("component2Impl") ComponentDependency componentDependency,
//			MyBean1 myBean, BeanWithDependencies beanWithDependencie, NombreCompleto nombreCompleto,
//			User u1) {
//		this.componentDependency = componentDependency;
//		this.myBean = myBean;
//		this.beanWithDependencie = beanWithDependencie;
//		this.nombreCompleto = nombreCompleto;
//		this.u1 = u1;
//	}

	public App(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		saveUsersInDataBase();
		getInfoFromJPQL();
	}
	
	public void saveUsersInDataBase() {
		User u1 = new User("Juan", "test1@mail.com", LocalDate.of(1980, 03, 15));
		User u2 = new User("Mariano", "test2@mail.com", LocalDate.of(1955,03, 15));
		User u3 = new User("Sandra", "test3@mail.com", LocalDate.of(1999, 03, 15));
		User u4 = new User("Monica", "test4@mail.com", LocalDate.of(2003, 03, 15));
		User u5 = new User("Emilio", "test5@mail.com", LocalDate.of(1995, 03, 15));
		
		List<User> usersList = Arrays.asList(u1, u2, u3, u4, u5);
//		userRepository.saveAll(usersList);
		usersList.forEach(userRepository::save);
	}
	
	private void getInfoFromJPQL() {
		LOGGER.info("El usuario encontrado es: " + userRepository.findByUserEmail("test2@mail.com"));
		LOGGER.info("Lista de usuarios con mail test: ");
		userRepository.findAndSort("test", Sort.by("id").descending())
					.stream()
					.forEach((user)-> LOGGER.info("Usuario: " + user.getName() + ", ID: " + user.getId()));
	}
	
	private void getInfoFromJPQLWithException() {
		LOGGER.info("El usuario encontrado es: " + 
					userRepository.findByUserEmail("test7@mail.com")
					.orElseThrow(()->new RuntimeException("No se encontró el usuario")));
	}

}
