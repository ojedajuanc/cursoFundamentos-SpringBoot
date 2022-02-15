package com.fundamentos.SpringBoot.fundamentos.configuration;

import java.time.LocalDate;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fundamentos.SpringBoot.fundamentos.persistence.entity.Volunteer;
import com.fundamentos.SpringBoot.fundamentos.persistence.repository.VolunteerRepository;

@Configuration
public class LoadVolunteers {

	private static final Log log = LogFactory.getLog(LoadVolunteers.class);
	
	@Bean
	CommandLineRunner initDatabase(VolunteerRepository repository) {
		return args -> {
			log.info("Cargando..." + repository.save(new Volunteer((long) 1, "Ojeda", "Juan", "juan@mail.com", LocalDate.of(1990,03, 15))));
			log.info("Cargando..." + repository.save(new Volunteer((long)3,"Morse","Caleb","morse@test.com",LocalDate.of(2018,02,24))));
			log.info("Cargando..." + repository.save(new Volunteer((long)3,"Rogers","Courtney","rogers@test.com",LocalDate.of(2021,01,15))));
			log.info("Cargando..." + repository.save(new Volunteer((long)5,"Berger","Emma","berger4743@test.com",LocalDate.of(2017,07,17))));
			log.info("Cargando..." + repository.save(new Volunteer((long)5,"Vargas","Anjolie","vargas2626@test.com",LocalDate.of(2016,07,29))));
			log.info("Cargando..." + repository.save(new Volunteer((long)3,"Caldwell","Amal","caldwell@test.com",LocalDate.of(2021,07,24))));
			log.info("Carga finalizada.");
		};
	}

}
