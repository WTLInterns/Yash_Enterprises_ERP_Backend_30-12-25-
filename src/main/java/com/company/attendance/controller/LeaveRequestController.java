package com.company.attendance.controller;
import com.company.attendance.dto.LeaveRequestDto;
import com.company.attendance.entity.LeaveRequest;
import com.company.attendance.mapper.LeaveRequestMapper;
import com.company.attendance.service.LeaveRequestService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/api/leaves")
@RequiredArgsConstructor
public class LeaveRequestController {
    private final LeaveRequestService leaveRequestService;
    private final LeaveRequestMapper leaveRequestMapper;

    @GetMapping
    public ResponseEntity<List<LeaveRequestDto>> listLeaves() {
        var leaves = leaveRequestService.findAll();
        var dtos = leaves.stream().map(leaveRequestMapper::toDto).collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LeaveRequestDto> getLeave(@PathVariable Long id) {
        return leaveRequestService.findById(id)
                .map(leaveRequestMapper::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<LeaveRequestDto> createLeave(@Valid @RequestBody LeaveRequestDto dto) {
        LeaveRequest leave = leaveRequestMapper.toEntity(dto);
        LeaveRequest saved = leaveRequestService.save(leave);
        return ResponseEntity.ok(leaveRequestMapper.toDto(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LeaveRequestDto> updateLeave(@PathVariable Long id, @Valid @RequestBody LeaveRequestDto dto) {
        LeaveRequest leave = leaveRequestMapper.toEntity(dto);
        LeaveRequest updated = leaveRequestService.update(id, leave);
        return ResponseEntity.ok(leaveRequestMapper.toDto(updated));
    }

    @PutMapping("/{id}/approve")
    public ResponseEntity<LeaveRequestDto> approveLeave(@PathVariable Long id) {
        LeaveRequest approved = leaveRequestService.approve(id);
        return ResponseEntity.ok(leaveRequestMapper.toDto(approved));
    }

    @PutMapping("/{id}/reject")
    public ResponseEntity<LeaveRequestDto> rejectLeave(@PathVariable Long id) {
        LeaveRequest rejected = leaveRequestService.reject(id);
        return ResponseEntity.ok(leaveRequestMapper.toDto(rejected));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLeave(@PathVariable Long id) {
        leaveRequestService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

