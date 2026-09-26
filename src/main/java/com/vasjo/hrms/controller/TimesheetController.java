package com.vasjo.hrms.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vasjo.hrms.dto.TimesheetRequestDTO;
import com.vasjo.hrms.entity.Timesheet;
import com.vasjo.hrms.service.TimesheetService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/timesheets")
public class TimesheetController {
	
	private final TimesheetService timesheetService;
	
	public TimesheetController(TimesheetService timesheetService) {
		
		this.timesheetService = timesheetService;
	}
	
	@GetMapping
	public List<Timesheet> getAllTimesheets() {
		
		return timesheetService.getAllTimesheets();
	}
	
	@PostMapping
	public Timesheet saveTimesheet(@Valid @RequestBody TimesheetRequestDTO timesheetRequest) {
		
		return timesheetService.saveTimesheet(timesheetRequest);
		
	}

}
