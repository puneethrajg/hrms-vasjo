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
	
	private Long projectId;
	
	public TaskRequestDTO() {
		
	}

	public TaskRequestDTO(String name, String description, String status, Long projectId) {
		
		this.name = name;
		this.description = description;
		this.status = status;
		this.projectId = projectId;
	}
	
	

}
