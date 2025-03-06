package com.javaexpress.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.javaexpress.model.User;
import com.javaexpress.service.UserServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserServiceImpl userServiceImpl;
	
	// http://localhost:8080/api/users/create - POST
	// knowledge purpose i am demonstrating - DTO Patterns
	// json -> entity and entity -> json
	// below method need to improve using DTO Pattern  - tommrow session
	@PostMapping("/create")
	@ResponseStatus(code = HttpStatus.CREATED) // 201
	public void createUser(@RequestBody @Valid User user) {
		userServiceImpl.createUser(user);
	}
	
	@GetMapping("/fetchUsers")
	public List<User> fetchAllUsers() {
		return userServiceImpl.fetchAllUsers();
	}
	
	@GetMapping("/{userId}")
	public User findById(@PathVariable Integer userId) {
		return userServiceImpl.findById(userId);
	}
	// http://localhost:8085/api/users/4
	
	@PutMapping("/{userId}")
	public User update(@PathVariable Integer userId,@RequestBody User user) {
		return userServiceImpl.updateUser(userId, user);
	}
	
	@DeleteMapping("/{userId}")
	public void delete(@PathVariable Integer userId) {
		userServiceImpl.delete(userId);
	}
}
