package com.fundamentos.SpringBoot.fundamentos.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fundamentos.SpringBoot.fundamentos.persistence.entity.User;
import com.fundamentos.SpringBoot.fundamentos.services.UserService;

@RestController
@RequestMapping("api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public ResponseEntity<List<User>> getAll() {
		List<User> usersList = userService.findAll();
		return new ResponseEntity<List<User>>(usersList, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<User>> getUser(@PathVariable("id") Long id) {
		Optional<User> user = userService.findUserById(id);
		return new ResponseEntity<Optional<User>>(user, HttpStatus.OK);
	}
	
	@PostMapping("/save")
	public ResponseEntity<User> createUser(@RequestBody User newUser){
		User savedUser = userService.addUser(newUser);
		return new ResponseEntity<User>(savedUser, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Optional<User>> updateUser(
			@PathVariable("id") Long id, @RequestBody User updatedUser){
		Optional<User> user = userService.updateUser(id, updatedUser);
		return new ResponseEntity<Optional<User>>(user, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable Long id){
		userService.deleteUser(id);
		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}
	
	
	
	
}
