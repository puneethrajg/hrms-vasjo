package com.vasjo.hrms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.vasjo.hrms.dto.TaskRequestDTO;
import com.vasjo.hrms.dto.TaskResponseDTO;
import com.vasjo.hrms.entity.Task;
import com.vasjo.hrms.repository.TaskRepository;


@Service
public class TaskService {

	private final TaskRepository taskRepository;

	public TaskService(TaskRepository taskRepository) {

		this.taskRepository = taskRepository;
	}

	public List<TaskResponseDTO> getAllTasks() {

		 List<Task> tasks = taskRepository.findAll();
		 
		 List<TaskResponseDTO> responseList = new ArrayList<>();
		 
		 for(Task task: tasks) {
			 
			 TaskResponseDTO response = new TaskResponseDTO(
					 	task.getId(),
					 	task.getName(),
					 	task.getDescription(),
					 	task.getStatus()
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

		Task savedTask = taskRepository.save(task);

		return new TaskResponseDTO (
				savedTask.getId(),
				savedTask.getName(),
				savedTask.getDescription(),
				savedTask.getStatus()
				
				);
	}

}
