package com.company.attendance.controller;

import com.company.attendance.dto.EmployeeDto;
import com.company.attendance.entity.Employee;
import com.company.attendance.mapper.EmployeeMapper;
import com.company.attendance.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;
    private final EmployeeMapper employeeMapper;

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> listEmployees() {
        List<Employee> employees = employeeService.findAll();
        List<EmployeeDto> dtos = employees.stream()
                .map(employeeMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable Long id) {
        return employeeService.findById(id)
                .map(employeeMapper::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@Valid @RequestBody EmployeeDto dto) {
        Employee employee = employeeMapper.toEntity(dto);
        Employee saved = employeeService.save(employee);
        return ResponseEntity.ok(employeeMapper.toDto(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long id, @Valid @RequestBody EmployeeDto dto) {
        Employee employee = employeeMapper.toEntity(dto);
        Employee updated = employeeService.update(id, employee);
        return ResponseEntity.ok(employeeMapper.toDto(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        employeeService.delete(id);
        return ResponseEntity.ok().build();
    }
}
