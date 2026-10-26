package com.vasjo.hrms.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TimesheetEntryResponseDTO {

	private Long id;
	private Long timesheetId;
	private LocalDate entryDate;
	private Double hours;
	private String note;

	public TimesheetEntryResponseDTO() {
	}

	public TimesheetEntryResponseDTO(Long id, Long timesheetId, LocalDate entryDate, Double hours, String note) {
		this.id = id;
		this.timesheetId = timesheetId;
		this.entryDate = entryDate;
		this.hours = hours;
		this.note = note;
	}
}