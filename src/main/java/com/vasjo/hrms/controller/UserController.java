package com.vasjo.hrms.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vasjo.hrms.dto.UserRequestDTO;
import com.vasjo.hrms.entity.User;
import com.vasjo.hrms.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/users")
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {

		this.userService = userService;

	}

	@GetMapping
	public List<User> getAllUsers() {

		return userService.getAllUsers();
	}

	@PostMapping
	public User createUser(@Valid @RequestBody UserRequestDTO userRequest) {

		User user = new User();

		user.setName(userRequest.getName());
		user.setEmail(userRequest.getEmail());
		user.setRole(userRequest.getRole());

		return userService.saveUser(user);
	}

}
