package com.fundamentos.SpringBoot.fundamentos;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fundamentos.SpringBoot.fundamentos.persistence.entity.User;
import com.fundamentos.SpringBoot.fundamentos.persistence.repository.UserRepository;

@SpringBootApplication
public class App implements CommandLineRunner {
	
	private UserRepository userRepository;

	public App(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		saveUsersInDataBase();
	}
	
	public void saveUsersInDataBase() {
		User u1 = new User("usuario1", "test1@mail.com", LocalDate.of(1980, 03, 15));
		User u2 = new User("usuario2", "test2@mail.com", LocalDate.of(1955, 03, 15));
		User u3 = new User("usuario3", "test3@mail.com", LocalDate.of(1999, 03, 15));
		User u4 = new User("usuario4", "test4@mail.com", LocalDate.of(2003, 03, 15));
		User u5 = new User("usuario5", "test5@mail.com", LocalDate.of(1995, 03, 15));
		User u6 = new User("usuario6", "test6@mail.com");
		
		List<User> usersList = Arrays.asList(u1, u2, u3, u4, u5, u6);
		usersList.forEach(userRepository::save);
	}
}
