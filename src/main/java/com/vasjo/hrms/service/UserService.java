package com.vasjo.hrms.service;

import java.util.List;

import org.springframework.stereotype.Service;


import com.vasjo.hrms.entity.User;
import com.vasjo.hrms.repository.UserRepository;

@Service
public class UserService {
	
	private final UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		
		this.userRepository = userRepository;
	}
	
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	public User saveUser(User user) {
		
		return userRepository.save(user);
	}

}
