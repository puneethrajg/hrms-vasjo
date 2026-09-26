package com.vasjo.hrms.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TimesheetRequestDTO {
	
	@NotNull
	private Long userId;
	
	@NotNull
	private LocalDate weekStart;
	
	private String status;
	
	public TimesheetRequestDTO() {
		
		
	}

	public TimesheetRequestDTO(Long userId, LocalDate weekStart, String status) {
		this.userId = userId;
		this.weekStart = weekStart;
		this.status = status;
	}
	
	

}
