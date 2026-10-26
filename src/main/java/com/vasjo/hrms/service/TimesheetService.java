package com.vasjo.hrms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.vasjo.hrms.dto.TimesheetRejectionRequestDTO;
import com.vasjo.hrms.dto.TimesheetRequestDTO;
import com.vasjo.hrms.dto.TimesheetResponseDTO;
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
	
	public List<TimesheetResponseDTO> getAllTimesheets() {
			
		List<Timesheet> timeSheet = timesheetRepository.findAll();
		

		
		List<TimesheetResponseDTO> responseList = new ArrayList<>();
		
		for(Timesheet timesheet : timeSheet) {
			
			TimesheetResponseDTO response = new TimesheetResponseDTO(
					timesheet.getId(),
					timesheet.getUser().getId(),
					timesheet.getWeekStart(),
					timesheet.getStatus(),
					timesheet.getTotalHours(),
					timesheet.getOvertimeHours(),
					timesheet.getRejectionReason()
					
					
					);
			responseList.add(response);
			
		}
		
		return responseList;
	}
	
	public TimesheetResponseDTO saveTimesheet(TimesheetRequestDTO timesheetRequest) {
		
		Timesheet timesheet = new Timesheet();
		
		timesheet.setWeekStart(timesheetRequest.getWeekStart());
		timesheet.setStatus("DRAFT");
		
		User user = userRepository
				.findById(timesheetRequest.getUserId())
				.orElseThrow();
		
//		Business Logic - 01 -> Duplicate Weekly Timesheet Prevention.
		if (timesheetRepository.existsByUserAndWeekStart(
		        user,
		        timesheetRequest.getWeekStart())) {

		    throw new RuntimeException(
		            "Timesheet already exists for this user and week");
		}
		
		timesheet.setUser(user);
		
		Timesheet savedTimesheet = timesheetRepository.save(timesheet);
		return new TimesheetResponseDTO(
				savedTimesheet.getId(),
				savedTimesheet.getUser().getId(),
				savedTimesheet.getWeekStart(),
				savedTimesheet.getStatus(),
				savedTimesheet.getTotalHours(),
				savedTimesheet.getOvertimeHours(),
				savedTimesheet.getRejectionReason()
				);
	}
	
	public TimesheetResponseDTO submitTimesheet(Long timesheetId) {
		
		Timesheet timeSheet = timesheetRepository
				.findById(timesheetId)
				.orElseThrow();
		
		if(!"DRAFT".equals(timeSheet.getStatus())) {
			
			throw new RuntimeException ("Status must be DRAFT");
		}
			timeSheet.setStatus("SUBMITTED");
		
		timesheetRepository.save(timeSheet);
		
		return new TimesheetResponseDTO(
				timeSheet.getId(),
				timeSheet.getUser().getId(),
				timeSheet.getWeekStart(),
				timeSheet.getStatus(),
				timeSheet.getTotalHours(),
				timeSheet.getOvertimeHours(),
				timeSheet.getRejectionReason()
				
				);
		
	}
	
	public TimesheetResponseDTO approveTimesheet(Long timesheetId)  {
		
		Timesheet timeSheet = timesheetRepository
				.findById(timesheetId)
				.orElseThrow();
		
		if(!"SUBMITTED".equals(timeSheet.getStatus())) {
			
			throw new RuntimeException("Status must be SUBMITTED!");
		}
		
		timeSheet.setStatus("APPROVED");
		
		timesheetRepository.save(timeSheet);
		
		return new TimesheetResponseDTO(
				timeSheet.getId(),
				timeSheet.getUser().getId(),
				timeSheet.getWeekStart(),
				timeSheet.getStatus(),
				timeSheet.getTotalHours(),
				timeSheet.getOvertimeHours(),
				timeSheet.getRejectionReason()
				);
				
		
	}
	
	public TimesheetResponseDTO rejectTimesheet(Long timesheetId, TimesheetRejectionRequestDTO rejectionRequest) {
		
		Timesheet timeSheet = timesheetRepository
				.findById(timesheetId)
				.orElseThrow();
		
		if(!"SUBMITTED".equals(timeSheet.getStatus())) {
			
			throw new RuntimeException("Status must be SUBMITTED!");
		}
		
		timeSheet.setRejectionReason(
			    rejectionRequest.getRejectionReason()
			);
		
		timeSheet.setStatus("REJECTED");
		
		timesheetRepository.save(timeSheet);
		
		return new TimesheetResponseDTO(
				timeSheet.getId(),
				timeSheet.getUser().getId(),
				timeSheet.getWeekStart(),
				timeSheet.getStatus(),
				timeSheet.getTotalHours(),
				timeSheet.getOvertimeHours(),
				timeSheet.getRejectionReason()
				);
	}
	
	public TimesheetResponseDTO reopenTimesheet(Long timesheetId) {
		
		Timesheet timeSheet = timesheetRepository
				.findById(timesheetId)
				.orElseThrow();
		
		if(!"REJECTED".equals(timeSheet.getStatus()) ) {
			
			throw new RuntimeException("Status must be REJECTED");
		}
		timeSheet.setStatus("DRAFT");
		
		timeSheet.setRejectionReason(null);
		
		timesheetRepository.save(timeSheet);
		
		return new TimesheetResponseDTO(
				timeSheet.getId(),
				timeSheet.getUser().getId(),
				timeSheet.getWeekStart(),
				timeSheet.getStatus(),
				timeSheet.getTotalHours(),
				timeSheet.getOvertimeHours(),
				timeSheet.getRejectionReason()
				);
	}
	
	
	
	
	
	
	

}
