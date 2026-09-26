package com.vasjo.hrms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vasjo.hrms.dto.TimesheetRequestDTO;
import com.vasjo.hrms.entity.Timesheet;
import com.vasjo.hrms.entity.User;
import com.vasjo.hrms.repository.TimesheetRepository;
import com.vasjo.hrms.repository.UserRepository;

@Service
public class TimesheetService {
	
	private final TimesheetRepository timesheetRepository;
	
	private final UserRepository userRepository;
	
	public TimesheetService(TimesheetRepository timesheetRepository, UserRepository userRepository) {
		
		this.timesheetRepository = timesheetRepository;
		this.userRepository = userRepository;
	}
	
	public List<Timesheet> getAllTimesheets() {
		
		return timesheetRepository.findAll();
	}
	
	public Timesheet saveTimesheet(TimesheetRequestDTO timesheetRequest) {
		
		Timesheet timesheet = new Timesheet();
		
		timesheet.setWeekStart(timesheetRequest.getWeekStart());
		timesheet.setStatus(timesheetRequest.getStatus());
		
		User user = userRepository
				.findById(timesheetRequest.getUserId())
				.orElseThrow();
		
		timesheet.setUser(user);
		
		return timesheetRepository.save(timesheet);
	}
	
	
	

}
