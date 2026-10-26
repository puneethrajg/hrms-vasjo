package com.vasjo.hrms.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vasjo.hrms.dto.UserRequestDTO;
import com.vasjo.hrms.dto.UserResponseDTO;
import com.vasjo.hrms.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {

		this.userService = userService;

	}

	@GetMapping
	public List<UserResponseDTO> getAllUsers() {

		return userService.getAllUsers();
	}

	@PostMapping
	public UserResponseDTO createUser(@Valid @RequestBody UserRequestDTO userRequest) {



		return userService.saveUser(userRequest);
	}

}
