package com.company.attendance.controller;

import com.company.attendance.dto.AttendanceDto;
import com.company.attendance.service.AttendanceService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/reports")
@RequiredArgsConstructor
public class ReportsController {
    private final AttendanceService attendanceService;

    @GetMapping("/attendance")
    public void exportAttendanceReport(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
                                   @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to,
                                   @RequestParam(required = false) Long teamId,
                                   @RequestParam(defaultValue = "csv") String format,
                                   HttpServletResponse response) throws IOException {
        List<AttendanceDto> records = attendanceService.getAttendanceByDateRange(from, to, teamId);
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename=attendance-report.csv");
        try (var writer = response.getWriter()) {
            writer.println("Employee ID,Date,Status");
            for (var r : records) {
                writer.printf("%s,%s,%s%n", r.getEmployeeId(), r.getDate(), r.getStatus());
            }
        }
    }

    @GetMapping("/salary")
    public ResponseEntity<?> exportSalaryReport(@RequestParam String month,
                                            @RequestParam(required = false) Long teamId) {
        return ResponseEntity.ok("Salary report would be generated here");
    }
}
