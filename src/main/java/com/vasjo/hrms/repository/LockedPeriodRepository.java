package com.vasjo.hrms.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vasjo.hrms.entity.LockedPeriod;

public interface LockedPeriodRepository extends JpaRepository<LockedPeriod, Long>{

	boolean existsByWeekStartAndLockedTrue(LocalDate weekStart);
	
	boolean existsByWeekStart(LocalDate weekStart);

	Optional<LockedPeriod> findByWeekStart(LocalDate weekStart);
}
