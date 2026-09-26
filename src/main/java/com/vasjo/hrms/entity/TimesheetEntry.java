package com.vasjo.hrms.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class TimesheetEntry {
	
	
	@ManyToOne
	@JoinColumn(name = "timesheet_id")
	private Timesheet timesheet;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalDate entryDate;
	
	private Double hours;
	
	private String note;
	
	public TimesheetEntry() {
		
	}

	public TimesheetEntry(Timesheet timesheet, Long id, LocalDate entryDate, Double hours, String note) {
		this.timesheet = timesheet;
		this.id = id;
		this.entryDate = entryDate;
		this.hours = hours;
		this.note = note;
	}
	
	
	

}
