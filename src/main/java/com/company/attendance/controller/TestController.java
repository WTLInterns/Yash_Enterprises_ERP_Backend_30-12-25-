package com.company.attendance.controller;

import com.company.attendance.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/test")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class TestController {
    
    private final EmployeeRepository employeeRepository;
    
    @GetMapping("/health")
    public String health() {
        return "Backend is running!";
    }
    
    @GetMapping("/employees")
    public List<Map<String, Object>> getEmployees() {
        return employeeRepository.findAll().stream()
            .map(emp -> {
                Map<String, Object> map = new java.util.HashMap<>();
                map.put("id", emp.getId());
                map.put("name", emp.getFirstName() + " " + emp.getLastName());
                map.put("email", emp.getEmail());
                map.put("department", emp.getTeam() != null ? emp.getTeam().getName() : null);
                map.put("position", emp.getDesignation() != null ? emp.getDesignation().getName() : null);
                map.put("status", emp.getStatus() != null ? emp.getStatus().toString() : "ACTIVE");
                return map;
            })
            .collect(Collectors.toList());
    }
}
