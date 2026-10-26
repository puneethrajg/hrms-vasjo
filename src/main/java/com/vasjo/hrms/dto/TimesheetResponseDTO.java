package com.vasjo.hrms.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class TimesheetResponseDTO {
	
	private Long id;
	
	private Long userId;
	
	private LocalDate weekStart;
	
	private String status;
	
	private Double totalHours;
	
	private Double overtimeHours;
	
	private String rejectionReason;
	
	public TimesheetResponseDTO() {
		
	}

	public TimesheetResponseDTO(Long id, Long userId, LocalDate weekStart, String status, Double totalHours,
			Double overtimeHours, String rejectionReason) {
		this.id = id;
		this.userId = userId;
		this.weekStart = weekStart;
		this.status = status;
		this.totalHours = totalHours;
		this.overtimeHours = overtimeHours;
		this.rejectionReason = rejectionReason;
	}
	
	
	
}
