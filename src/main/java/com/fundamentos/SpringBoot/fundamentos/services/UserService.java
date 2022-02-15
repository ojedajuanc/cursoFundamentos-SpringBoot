package com.fundamentos.SpringBoot.fundamentos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fundamentos.SpringBoot.fundamentos.persistence.entity.User;

@Service
public interface UserService {
	
	List<User> findAll();
	
	Optional<User> findUserById(Long id);
	
	User addUser(User user);
	
	Optional<User> updateUser(Long id, User updatedUser);
	
	void deleteUser(Long id);

}
