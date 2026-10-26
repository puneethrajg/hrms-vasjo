package com.vasjo.hrms.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.vasjo.hrms.dto.TimesheetEntryRequestDTO;
import com.vasjo.hrms.dto.TimesheetEntryResponseDTO;
import com.vasjo.hrms.dto.TimesheetEntryUpdateRequestDTO;
import com.vasjo.hrms.entity.Timesheet;
import com.vasjo.hrms.entity.TimesheetEntry;
import com.vasjo.hrms.repository.TimesheetEntryRepository;
import com.vasjo.hrms.repository.TimesheetRepository;

@Service
public class TimesheetEntryService {
	
	private final TimesheetEntryRepository timesheetentryRepository;
	
	private final TimesheetRepository timesheetRepository;
	
	private final LockedPeriodService lockedperiodService;
	
	public TimesheetEntryService (TimesheetEntryRepository timesheetentryRepository, TimesheetRepository timesheetRepository, LockedPeriodService lockedperiodService) {
		
		this.timesheetentryRepository = timesheetentryRepository;
		this.timesheetRepository = timesheetRepository;
		this.lockedperiodService = lockedperiodService;
	}
	
	
	public List<TimesheetEntryResponseDTO> getAllEntries() {

		List<TimesheetEntry> entries = timesheetentryRepository.findAll();

		List<TimesheetEntryResponseDTO> responseList = new ArrayList<>();

		for (TimesheetEntry entry : entries) {

			TimesheetEntryResponseDTO response = new TimesheetEntryResponseDTO(

					entry.getId(),

					entry.getTimesheet().getId(),

					entry.getEntryDate(),

					entry.getHours(),

					entry.getNote()

			);
			responseList.add(response);
		}
		return responseList;
	}
	public TimesheetEntryResponseDTO saveEntry(TimesheetEntryRequestDTO timesheetEntryRequest) {
		
		
		TimesheetEntry timesheetEntry = new TimesheetEntry();
		
		timesheetEntry.setEntryDate(timesheetEntryRequest.getEntryDate());
		timesheetEntry.setHours(timesheetEntryRequest.getHours());
		timesheetEntry.setNote(timesheetEntryRequest.getNote());
		
		Timesheet timeSheet = timesheetRepository
				.findById(timesheetEntryRequest.getTimesheetId())
				.orElseThrow();
		
		if(lockedperiodService.isPeriodLocked(timeSheet.getWeekStart())) {
			
			throw new RuntimeException("Timesheet period is locked!");
		}
		
		if (!"DRAFT".equals(timeSheet.getStatus())) {
		    throw new RuntimeException("Only DRAFT timesheets can be edited");
		}
		
		timesheetEntry.setTimesheet(timeSheet);
		
		if(timesheetentryRepository.existsByTimesheetAndEntryDate(timeSheet, timesheetEntryRequest.getEntryDate())) {
			
			throw new RuntimeException("An Entry already exists for this Date!");
		}
		
//		Business Logic Rule 03 -> Entry Date Validation is done
		LocalDate weekStart = timeSheet.getWeekStart();
		LocalDate weekEnd = weekStart.plusDays(6);
		
		if(timesheetEntryRequest.getEntryDate().isBefore(weekStart) || timesheetEntryRequest.getEntryDate().isAfter(weekEnd)) {
			
			throw new RuntimeException("Entry Date must be in the Valid Week Range!");
		}
		
//		Business Logic Rule 02 -> Hours Validation is done
		if(timesheetEntryRequest.getHours() < 0.0 || 
				timesheetEntryRequest.getHours() > 24.0) {
			
			throw new RuntimeException("Hours must be between 0 and 24!!");
		}
		
		TimesheetEntry savedTimesheetEntry = timesheetentryRepository.save(timesheetEntry);
		
//		Business Logic Rule 04 -> Total Hours Calculation is done
//		Business Logic Rule 04 -> Over Time Hours Calculation is done
		List<TimesheetEntry> entries = timesheetentryRepository.findByTimesheet(timeSheet);
		
		double totalHours = 0.0;
		double overtimeHours = 0.0;
		
		for(TimesheetEntry entry : entries) {
			totalHours += entry.getHours();
			
			if(entry.getHours() > 8.0) {
				
				overtimeHours += entry.getHours() - 8;
			}
		}
		timeSheet.setOvertimeHours(overtimeHours);
		
		timeSheet.setTotalHours(totalHours);
		timesheetRepository.save(timeSheet);
		
		
		
		return new TimesheetEntryResponseDTO(
				savedTimesheetEntry.getId(),
				savedTimesheetEntry.getTimesheet().getId(),
				savedTimesheetEntry.getEntryDate(),
				savedTimesheetEntry.getHours(),
				savedTimesheetEntry.getNote()
				);
	}
	public TimesheetEntryResponseDTO updateEntry(Long id,TimesheetEntryUpdateRequestDTO updateRequest) {

		
		TimesheetEntry entry = timesheetentryRepository
				.findById(id)
				.orElseThrow();
		
		Timesheet timeSheet = entry.getTimesheet();
		
	if(lockedperiodService.isPeriodLocked(timeSheet.getWeekStart())) {
			
			throw new RuntimeException("Timesheet period is locked!");
		}
		
		 // 3. Only DRAFT timesheets can be edited
		if(!"DRAFT".equals(timeSheet.getStatus()) ) {
			
			throw new RuntimeException("Status must be DRAFT");
		}
		entry.setHours(updateRequest.getHours());
		entry.setNote(updateRequest.getNote());
		
		timesheetentryRepository.save(entry);
		
	    List<TimesheetEntry> entries = timesheetentryRepository
	            .findByTimesheet(timeSheet);
		
		double totalHours = 0.0;
		double overtimeHours = 0.0;

		for(TimesheetEntry currentEntry : entries) {
			totalHours += entry.getHours();
			
			if(currentEntry.getHours() > 8.0) {
				
				overtimeHours += currentEntry.getHours() - 8;
			}else {
				overtimeHours = 0;
			}
		}
		timeSheet.setOvertimeHours(overtimeHours);
		
		timeSheet.setTotalHours(totalHours);
		timesheetRepository.save(timeSheet);
		

		return new TimesheetEntryResponseDTO(
				entry.getId(),
				entry.getTimesheet().getId(),
				entry.getEntryDate(),
				entry.getHours(),
				entry.getNote()
				);
		
		
	}

}
