package com.vasjo.hrms.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TaskRequestDTO {
	
	@NotBlank(message = "Task name should not be empty!")
	private String name;
	
	private String description;
	
	private String status;
	
	public TaskRequestDTO() {
		
	}

	public TaskRequestDTO(String name, String description, String status) {
		
		this.name = name;
		this.description = description;
		this.status = status;
	}
	
	

}
