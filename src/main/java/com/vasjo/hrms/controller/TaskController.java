package com.vasjo.hrms.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vasjo.hrms.dto.TaskRequestDTO;
import com.vasjo.hrms.dto.TaskResponseDTO;
import com.vasjo.hrms.service.TaskService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/tasks")
public class TaskController {
	
	private final TaskService taskService;
	
	public TaskController(TaskService taskService) {
		
		this.taskService = taskService;
	}
	
	@GetMapping
	public List<TaskResponseDTO> getAllTasks() {
		
		return taskService.getAllTasks();
	}
	
	@PostMapping
	public TaskResponseDTO saveTask(@Valid @RequestBody TaskRequestDTO taskRequest) {
		
		return taskService.saveTask(taskRequest);
	}

	
}
