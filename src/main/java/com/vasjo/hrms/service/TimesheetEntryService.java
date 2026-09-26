package com.vasjo.hrms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vasjo.hrms.dto.TimesheetEntryRequestDTO;
import com.vasjo.hrms.entity.Timesheet;
import com.vasjo.hrms.entity.TimesheetEntry;
import com.vasjo.hrms.repository.TimesheetEntryRepository;
import com.vasjo.hrms.repository.TimesheetRepository;

@Service
public class TimesheetEntryService {
	
	private final TimesheetEntryRepository timesheetentryRepository;
	
	private final TimesheetRepository timesheetRepository;
	
	public TimesheetEntryService (TimesheetEntryRepository timesheetentryRepository, TimesheetRepository timesheetRepository) {
		
		this.timesheetentryRepository = timesheetentryRepository;
		this.timesheetRepository = timesheetRepository;
	}
	
	
	public List<TimesheetEntry> getAllEntries() {
		
		return timesheetentryRepository.findAll();
	}
	
	public TimesheetEntry saveEntry(TimesheetEntryRequestDTO timesheetEntryRequest) {
		
		
		TimesheetEntry entry = new TimesheetEntry();
		
		entry.setEntryDate(timesheetEntryRequest.getEntryDate());
		entry.setHours(timesheetEntryRequest.getHours());
		entry.setNote(timesheetEntryRequest.getNote());
		
		Timesheet timeSheet = timesheetRepository
				.findById(timesheetEntryRequest.getTimesheetId())
				.orElseThrow();
		
		entry.setTimesheet(timeSheet);
		
		return timesheetentryRepository.save(entry);
		
	}

}
