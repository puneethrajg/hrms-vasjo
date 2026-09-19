package com.vasjo.hrms.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProjectRequestDTO {

	@NotBlank(message = "Project name required!")
	private String name;

	private String description;

	@NotNull(message = "Start Date is required!")
	private LocalDate startDate;

	@NotNull(message = "End Date is required!")
	private LocalDate endDate;

	private String status;

	public ProjectRequestDTO() {

	}

	public ProjectRequestDTO(String name, String description, LocalDate startDate, LocalDate endDate, String status) {

		this.name = name;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
	}

}
