package com.vasjo.hrms.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vasjo.hrms.dto.TimesheetEntryRequestDTO;
import com.vasjo.hrms.dto.TimesheetEntryResponseDTO;
import com.vasjo.hrms.dto.TimesheetEntryUpdateRequestDTO;
import com.vasjo.hrms.service.TimesheetEntryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/timesheet-entries")
public class TimesheetEntryController {
	
	private final TimesheetEntryService timesheetentryService;
	
	public TimesheetEntryController(TimesheetEntryService timesheetentryService) {
		
		this.timesheetentryService = timesheetentryService;
	}
	
	@GetMapping
	public List<TimesheetEntryResponseDTO> getAllEntries() {
		
		return timesheetentryService.getAllEntries();
	}
	
	@PostMapping
	public TimesheetEntryResponseDTO saveEntry(@Valid @RequestBody TimesheetEntryRequestDTO timesheetentryRequest) {
		
		return timesheetentryService.saveEntry(timesheetentryRequest);
	}
	
	@PatchMapping("/{id}")
	public TimesheetEntryResponseDTO updateEntry(@PathVariable Long id, @Valid @RequestBody TimesheetEntryUpdateRequestDTO updateRequest) {
		
		return timesheetentryService.updateEntry(id, updateRequest);
	}
	
}
