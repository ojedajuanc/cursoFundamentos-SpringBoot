package com.fundamentos.SpringBoot.fundamentos.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fundamentos.SpringBoot.fundamentos.persistence.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	//Ejemplo de Query con JPQL
	@Query("SELECT u FROM User u WHERE u.email =?1")
	Optional<User> findByUserEmail(String email);
	
	@Query("SELECT u FROM User u WHERE u.email LIKE ?1%")
	List<User> findAndSort(String email, Sort sort);

}
