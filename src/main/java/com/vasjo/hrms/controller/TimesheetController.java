package com.vasjo.hrms.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vasjo.hrms.dto.TimesheetRejectionRequestDTO;
import com.vasjo.hrms.dto.TimesheetRequestDTO;
import com.vasjo.hrms.dto.TimesheetResponseDTO;
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
	public List<TimesheetResponseDTO> getAllTimesheets() {
		
		return timesheetService.getAllTimesheets();
	}
	
	@PostMapping
	public TimesheetResponseDTO saveTimesheet(@Valid @RequestBody TimesheetRequestDTO timesheetRequest) {
		
		return timesheetService.saveTimesheet(timesheetRequest);
		
	}
	
	@PostMapping("/{id}/submit")
	public TimesheetResponseDTO submitTimesheet(@PathVariable Long id) {
		
		return timesheetService.submitTimesheet(id);
	}
	
	@PostMapping("/{id}/approve")
	public TimesheetResponseDTO approveTimesheet(@PathVariable Long id) {
		
		return timesheetService.approveTimesheet(id);
	}
	
	@PostMapping("/{id}/reject")
	public TimesheetResponseDTO rejectTimesheet(@PathVariable Long id, 
								@Valid @RequestBody TimesheetRejectionRequestDTO rejectionRequest) {
		
		return timesheetService.rejectTimesheet(id, rejectionRequest);
	}
	
	@PostMapping("/{id}/reopen")
	public TimesheetResponseDTO reopenTimesheet(@PathVariable Long id) {
		
		return timesheetService.reopenTimesheet(id);
	}

}
