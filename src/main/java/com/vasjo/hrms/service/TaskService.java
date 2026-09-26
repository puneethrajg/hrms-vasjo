package com.vasjo.hrms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.vasjo.hrms.dto.TaskRequestDTO;
import com.vasjo.hrms.dto.TaskResponseDTO;
import com.vasjo.hrms.entity.Project;
import com.vasjo.hrms.entity.Task;
import com.vasjo.hrms.repository.ProjectRepository;
import com.vasjo.hrms.repository.TaskRepository;


@Service
public class TaskService {

	private final TaskRepository taskRepository;
	
	private final ProjectRepository projectRepository;

	public TaskService(TaskRepository taskRepository, ProjectRepository projectRepository) {

		this.taskRepository = taskRepository;
		this.projectRepository = projectRepository;
	}

	public List<TaskResponseDTO> getAllTasks() {

		 List<Task> tasks = taskRepository.findAll();
		 
		 List<TaskResponseDTO> responseList = new ArrayList<>();
		 
		 for(Task task: tasks) {
			 
			 TaskResponseDTO response = new TaskResponseDTO(
					 	task.getId(),
					 	task.getName(),
					 	task.getDescription(),
					 	task.getStatus(),
					 	task.getProject().getId()
					 );
			 
			 responseList.add(response);
		 }
		 return responseList;
	}

	public TaskResponseDTO saveTask(TaskRequestDTO taskRequest) {

		Task task = new Task();

		task.setName(taskRequest.getName());
		task.setDescription(taskRequest.getDescription());
		task.setStatus(taskRequest.getStatus());
		
		Project project = projectRepository
				.findById(taskRequest.getProjectId())
				.orElseThrow();
		
		task.setProject(project);

		Task savedTask = taskRepository.save(task);

		return new TaskResponseDTO (
				savedTask.getId(),
				savedTask.getName(),
				savedTask.getDescription(),
				savedTask.getStatus(),
				savedTask.getProject().getId()
				
				);
	}

}
