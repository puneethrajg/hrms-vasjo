package com.vasjo.hrms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vasjo.hrms.entity.Timesheet;

public interface TimesheetRepository extends JpaRepository<Timesheet, Long> {

}
