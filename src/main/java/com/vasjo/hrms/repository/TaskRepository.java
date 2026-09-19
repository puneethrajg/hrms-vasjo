package com.vasjo.hrms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vasjo.hrms.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
