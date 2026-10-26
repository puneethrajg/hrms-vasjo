package com.vasjo.hrms.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vasjo.hrms.entity.Timesheet;
import com.vasjo.hrms.entity.User;

public interface TimesheetRepository extends JpaRepository<Timesheet, Long> {
	
	 boolean existsByUserAndWeekStart(User user, LocalDate weekStart);
}
