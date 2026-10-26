package com.vasjo.hrms.dto;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TimesheetEntryUpdateRequestDTO {
	
	@NotNull(message = "Hours are required")
	@DecimalMin(value = "0.0", message = "Hours cannot be negative")
	@DecimalMax(value = "24.0", message = "Hours cannot exceed 24")
	private Double hours;
	
	private String note;
}
