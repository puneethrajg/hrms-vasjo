package com.vasjo.hrms.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TimesheetEntryRequestDTO {

	@NotNull
	private Long timesheetId;

	@NotNull
	private LocalDate entryDate;

	@NotNull
	private Double hours;

	private String note;

	public TimesheetEntryRequestDTO() {
	}

	public TimesheetEntryRequestDTO(Long timesheetId, LocalDate entryDate, Double hours, String note) {
		this.timesheetId = timesheetId;
		this.entryDate = entryDate;
		this.hours = hours;
		this.note = note;
	}
}