package com.vasjo.hrms.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.vasjo.hrms.entity.LockedPeriod;
import com.vasjo.hrms.repository.LockedPeriodRepository;

@Service
public class LockedPeriodService {

	private final LockedPeriodRepository lockedperiodRepository;
	
	public LockedPeriodService(LockedPeriodRepository lockedperiodRepository) {
		
		this.lockedperiodRepository = lockedperiodRepository;
	}
	public LockedPeriod lockPeriod(LocalDate weekStart) {
		
		if(lockedperiodRepository.existsByWeekStart(weekStart)) {
			
			throw new RuntimeException("A record already exists for this Week!");
		}
		
		LockedPeriod lockedPeriod = new LockedPeriod();
		lockedPeriod.setWeekStart(weekStart);
		lockedPeriod.setLocked(true);
		
		return lockedperiodRepository.save(lockedPeriod);
		
	}
	
	public LockedPeriod unlockPeriod(LocalDate weekStart) {
		
		LockedPeriod lockedPeriod = lockedperiodRepository
                .findByWeekStart(weekStart)
                .orElseThrow(() -> new RuntimeException(
                        "No record found for this week"));
		
		lockedPeriod.setLocked(false);
		
		return lockedperiodRepository.save(lockedPeriod);
	}
	
	public boolean isPeriodLocked(LocalDate weekStart) {
		
		return lockedperiodRepository
				.existsByWeekStartAndLockedTrue(weekStart);
	}
	
}
