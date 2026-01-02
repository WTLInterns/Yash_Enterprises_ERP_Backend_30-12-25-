package com.company.attendance.service;

import com.company.attendance.dto.AttendanceDto;
import com.company.attendance.entity.Attendance;
import com.company.attendance.mapper.AttendanceMapper;
import com.company.attendance.repository.AttendanceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AttendanceService {

    private final AttendanceRepository attendanceRepository;
    private final AttendanceMapper attendanceMapper;

    public Attendance save(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }

    public List<Attendance> findAttendanceOfEmployee(Long employeeId, LocalDate from, LocalDate to) {
        return attendanceRepository.findByEmployeeIdAndDateBetween(employeeId, from, to);
    }

    public List<Attendance> findByDate(LocalDate date) {
        return attendanceRepository.findByDate(date);
    }

    public List<AttendanceDto> getAttendanceByDateRange(LocalDate from, LocalDate to, Long teamId) {
        List<Attendance> records;
        if (teamId != null) {
            records = attendanceRepository.findByDateBetweenAndTeamId(from, to, teamId);
        } else {
            records = attendanceRepository.findByDateBetween(from, to);
        }
        return records.stream().map(attendanceMapper::toDto).collect(Collectors.toList());
    }

    public List<Attendance> bulkSave(List<Attendance> attendances) {
        return attendanceRepository.saveAll(attendances);
    }

    public Map<String, Object> getDashboardSummary(LocalDate date) {
        Map<String, Object> summary = new HashMap<>();
        var all = attendanceRepository.findByDate(date);
        summary.put("date", date);
        summary.put("totalEmployees", all.size());
        summary.put("punchedIn", all.stream().filter(a -> "PUNCHED_IN".equals(a.getStatus().toString())).count());
        return summary;
    }
}
