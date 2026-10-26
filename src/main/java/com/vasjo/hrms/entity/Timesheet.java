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
public class Timesheet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	private LocalDate weekStart;
	
	private String status;
	
	private Double totalHours;
	
	private Double overtimeHours;
	
	private String rejectionReason;
	
	public Timesheet() {
		
	}

	public Timesheet(Long id, User user, LocalDate weekStart, String status, Double totalHours, Double overtimeHours,String rejectionReason) {
		this.id = id;
		this.user = user;
		this.weekStart = weekStart;
		this.status = status;
		this.totalHours = totalHours;
		this.overtimeHours = overtimeHours;
		this.rejectionReason = rejectionReason;
	}
	
	

}
