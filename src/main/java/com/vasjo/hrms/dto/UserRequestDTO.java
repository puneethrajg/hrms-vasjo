package com.vasjo.hrms.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDTO {

	@NotBlank(message = "Name is required!")
	private String name;

	@NotBlank(message = "E-Mail is required!")
	@Email(message = "Invalid email format!")
	private String email;

	@NotBlank(message = "Role is required!")
	private String role;

	public UserRequestDTO() {

	}

	public UserRequestDTO(String name, String email, String role) {

		this.email = email;
		this.name = name;
		this.role = role;
	}

}
