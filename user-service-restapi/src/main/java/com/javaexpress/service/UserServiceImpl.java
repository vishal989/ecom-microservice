package com.javaexpress.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaexpress.exception.UserNotFoundException;
import com.javaexpress.model.User;
import com.javaexpress.repository.UserRepository;

@Service
public class UserServiceImpl {
 
	//Service -> Repository (DAO Layer)
	
	@Autowired
	private UserRepository userRepository;
	
	public void createUser(User user) {
		userRepository.save(user);
		// save is used for creating new record or updating existing record
	}
	
	
	public User updateUser(Integer userId,User user) {
		user.setUserId(userId);
		Optional<User> optional = userRepository.findById(userId);
		if(optional.isPresent()) {
			return userRepository.save(user);
		} else {
			throw new UserNotFoundException("User Not Exists in Db");
		}
	}
	
	
	public List<User> fetchAllUsers() {
		return userRepository.findAll();
	}


	public User findById(Integer userId) {
		return userRepository.findById(userId)
				.orElseThrow(() -> new UserNotFoundException("User Not Found in Db"));
	}

	public void delete(Integer userId) {
		userRepository.deleteById(userId);
	}
	
}
