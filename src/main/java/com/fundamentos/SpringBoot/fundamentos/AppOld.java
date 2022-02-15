package com.fundamentos.SpringBoot.fundamentos;

/**@SpringBootApplication
public class AppOld implements CommandLineRunner {
	
	private UserRepository userRepository;
	
	private final Log LOGGER = LogFactory.getLog(this.getClass());
	private ComponentDependency componentDependency;
	private MyBean1 myBean;
	private BeanWithDependencies beanWithDependencie;
	private NombreCompleto nombreCompleto;
	private User u1;


	
	 Se utiliza el annotation Qualifier para que SpringBoot sepa a qué componente
	 llamar cuando dos o más tienen misma implementación
	 
	public App(@Qualifier("component2Impl") ComponentDependency componentDependency,
			MyBean1 myBean, BeanWithDependencies beanWithDependencie, NombreCompleto nombreCompleto,
			User u1) {
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.beanWithDependencie = beanWithDependencie;
		this.nombreCompleto = nombreCompleto;
		this.u1 = u1;
	}

	public AppOld(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(AppOld.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		saveUsersInDataBase();
		getInfoFromJPQL();
		getInfoFromQueryMethod();
	}
	
	public void saveUsersInDataBase() {
		User u1 = new User("Juan", "test1@mail.com", LocalDate.of(1980, 03, 15));
		User u2 = new User("Mariano", "test2@mail.com", LocalDate.of(1955,03, 15));
		User u3 = new User("Sandra", "test3@mail.com", LocalDate.of(1999, 03, 15));
		User u4 = new User("Monica", "test4@mail.com", LocalDate.of(2003, 03, 15));
		User u5 = new User("Emilio", "test5@mail.com", LocalDate.of(1995, 03, 15));
		
		List<User> usersList = Arrays.asList(u1, u2, u3, u4, u5);
		userRepository.saveAll(usersList);
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
	
	private void getInfoFromQueryMethod() {
		userRepository.findByNameNotLike("Juan")
				.stream()
				.forEach((user)->LOGGER.info("Usuario con query method: " + user.getName()));
				
		LOGGER.info("ID Usuario con query method: "+ userRepository.findById((long) 3));
		
	}

}*/
