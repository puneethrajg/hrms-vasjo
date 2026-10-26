package com.vasjo.hrms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.vasjo.hrms.dto.UserRequestDTO;
import com.vasjo.hrms.dto.UserResponseDTO;
import com.vasjo.hrms.entity.User;
import com.vasjo.hrms.repository.UserRepository;

@Service
public class UserService {
	
	private final UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		
		this.userRepository = userRepository;
	}
	
	public List<UserResponseDTO> getAllUsers() {
		
		List<User> user = userRepository.findAll();
		
		List<UserResponseDTO> responseList = new ArrayList<>();
		
		for(User users : user) {
			
			UserResponseDTO response = new UserResponseDTO (
					users.getId(),
					users.getName(),
					users.getEmail(),
					users.getRole()
					);
			
			responseList.add(response);
					
		}
		return responseList;
	}
	
	public UserResponseDTO saveUser(UserRequestDTO userRequest) {
		User user = new User();
		
		user.setName(userRequest.getName());
		user.setEmail(userRequest.getEmail());
		user.setRole(userRequest.getRole());
		
		User savedUser = userRepository.save(user);
		return new UserResponseDTO(
				 savedUser.getId(),
				 savedUser.getName(),
				 savedUser.getEmail(),
				 savedUser.getRole()
				);
	}

}
