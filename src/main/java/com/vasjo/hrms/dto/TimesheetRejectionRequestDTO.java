package com.vasjo.hrms.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TimesheetRejectionRequestDTO {
	
	@NotBlank(message = "Rejection reason is required!")
	private String rejectionReason;

	
}
