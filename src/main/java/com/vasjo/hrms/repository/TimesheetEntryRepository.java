package com.vasjo.hrms.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vasjo.hrms.entity.Timesheet;
import com.vasjo.hrms.entity.TimesheetEntry;

@Repository
public interface TimesheetEntryRepository extends JpaRepository<TimesheetEntry, Long>{
	
	boolean existsByTimesheetAndEntryDate(Timesheet timesheet, LocalDate entryDate);
	
	List<TimesheetEntry> findByTimesheet(Timesheet timesheet);

}
