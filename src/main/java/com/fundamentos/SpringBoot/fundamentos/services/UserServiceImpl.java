package com.fundamentos.SpringBoot.fundamentos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fundamentos.SpringBoot.fundamentos.persistence.entity.User;
import com.fundamentos.SpringBoot.fundamentos.persistence.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository repository;

	@Override
	public List<User> findAll() {
		return repository.findAll();
	}

	@Override
	public Optional<User> findUserById(Long id) {
		Optional<User> user = repository.findById(id);
		return user;
	}

	@Override
	public User addUser(User user) {
		return repository.save(user);
	}

	@Override
	public Optional<User> updateUser(Long id, User updatedUser) {
		return repository.findById(id)
			.map(user -> {
				user.setName(updatedUser.getName());
				user.setEmail(updatedUser.getEmail());
				user.setBirthday(updatedUser.getBirthday());
				return repository.save(user);
			});	
	}

	@Override
	public void deleteUser(Long id) {
		repository.deleteById(id);
	}
	
	

}
