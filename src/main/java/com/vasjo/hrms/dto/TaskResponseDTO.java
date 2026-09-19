package com.vasjo.hrms.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TaskResponseDTO {

	private Long id;

	private String name;

	private String description;

	private String status;

	public TaskResponseDTO() {

	}

	public TaskResponseDTO(Long id, String name, String description, String status) {

		this.id = id;
		this.name = name;
		this.description = description;
		this.status = status;
	}

}
