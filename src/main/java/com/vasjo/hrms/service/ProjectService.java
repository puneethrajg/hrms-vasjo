package com.vasjo.hrms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.vasjo.hrms.dto.ProjectRequestDTO;
import com.vasjo.hrms.dto.ProjectResponseDTO;
import com.vasjo.hrms.entity.Project;
import com.vasjo.hrms.repository.ProjectRepository;


@Service
public class ProjectService {

	private final ProjectRepository projectRepository;

	public ProjectService(ProjectRepository projectRepository) {

		this.projectRepository = projectRepository;
	}

	public List<ProjectResponseDTO> getAllProjects() {

        List<Project> projects = projectRepository.findAll();

        List<ProjectResponseDTO> responseList = new ArrayList<>();

        for (Project project : projects) {

            ProjectResponseDTO response = new ProjectResponseDTO(
                    project.getId(),
                    project.getName(),
                    project.getDescription(),
                    project.getStartDate(),
                    project.getEndDate(),
                    project.getStatus()
            );

            responseList.add(response);
        }

        return responseList;
    }


	public ProjectResponseDTO saveProject(ProjectRequestDTO projectRequest) {

		Project project = new Project();
		
		project.setName(projectRequest.getName());
		project.setDescription(projectRequest.getDescription());
		project.setStartDate(projectRequest.getStartDate());
		project.setEndDate(projectRequest.getEndDate());
		project.setStatus(projectRequest.getStatus());
		
		Project savedProject = projectRepository.save(project);
		
		return new ProjectResponseDTO(
				savedProject.getId(),
				savedProject.getName(),
				savedProject.getDescription(),
				savedProject.getStartDate(),
				savedProject.getEndDate(),
				savedProject.getStatus()
				
				);
				
	}

}
