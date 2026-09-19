package com.vasjo.hrms.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vasjo.hrms.dto.ProjectRequestDTO;
import com.vasjo.hrms.dto.ProjectResponseDTO;
import com.vasjo.hrms.service.ProjectService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

	private final ProjectService projectService;

	public ProjectController(ProjectService projectService) {

		this.projectService = projectService;
	}

	@GetMapping
	public List<ProjectResponseDTO> getAllProjects() {
		
		
		return projectService.getAllProjects();

	}
	
	@PostMapping
	public ProjectResponseDTO saveProject(@Valid @RequestBody ProjectRequestDTO projectRequest) {
		
	    return projectService.saveProject(projectRequest);
	}
	

}
