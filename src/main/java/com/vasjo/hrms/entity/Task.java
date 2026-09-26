package com.vasjo.hrms.entity;

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
public class Task {
	
	@ManyToOne
	@JoinColumn(name = "project_id")
	private Project project;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String description;
	
	private String status;

	public Task() {
		
	}
	
	public Task(Long id, String name, String description, String status) {
		
		this.id = id;
		this.name = name;
		this.description = description;
		this.status = status;
	}
	
	
	
	
	
}
