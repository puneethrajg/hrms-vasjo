
package com.vasjo.hrms.controller;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.*;

import com.vasjo.hrms.entity.LockedPeriod;
import com.vasjo.hrms.service.LockedPeriodService;

@RestController
@RequestMapping("/api/locked-periods")
public class LockedPeriodController {

    private final LockedPeriodService lockedperiodService;

    public LockedPeriodController(
            LockedPeriodService lockedperiodService) {
        this.lockedperiodService = lockedperiodService;
    }

    @PostMapping
    public LockedPeriod lockPeriod(
            @RequestParam LocalDate weekStart) {
        return lockedperiodService.lockPeriod(weekStart);
    }

    @PatchMapping("/unlock")
    public LockedPeriod unlockPeriod(
            @RequestParam LocalDate weekStart) {
        return lockedperiodService.unlockPeriod(weekStart);
    }
}
