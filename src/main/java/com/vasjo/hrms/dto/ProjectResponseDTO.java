package com.vasjo.hrms.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProjectResponseDTO {

	private Long id;

	private String name;

	private String description;

	private LocalDate startDate;

	private LocalDate endDate;

	private String status;

	public ProjectResponseDTO() {

	}

	public ProjectResponseDTO(Long id, String name, String description, LocalDate startDate, LocalDate endDate,
			String status) {

		this.id = id;
		this.name = name;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
	}

}
