package com.company.attendance.controller;

import com.company.attendance.dto.RoleDto;
import com.company.attendance.entity.Role;
import com.company.attendance.mapper.RoleMapper;
import com.company.attendance.service.RoleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/roles")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class RoleController {

    private final RoleService roleService;
    private final RoleMapper roleMapper;

    @GetMapping
    public ResponseEntity<List<RoleDto>> getAllRoles() {
        List<Role> roles = roleService.findAll();
        List<RoleDto> dtos = roles.stream()
                .map(roleMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleDto> getRoleById(@PathVariable Long id) {
        return roleService.findById(id)
                .map(roleMapper::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<RoleDto> createRole(@Valid @RequestBody RoleDto dto) {
        Role role = roleMapper.toEntity(dto);
        Role saved = roleService.save(role);
        return ResponseEntity.ok(roleMapper.toDto(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoleDto> updateRole(@PathVariable Long id, @Valid @RequestBody RoleDto dto) {
        Role role = roleMapper.toEntity(dto);
        Role updated = roleService.update(id, role);
        return ResponseEntity.ok(roleMapper.toDto(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable Long id) {
        roleService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<RoleDto> getRoleByName(@PathVariable String name) {
        return roleService.findByName(name)
                .map(roleMapper::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/active/{isActive}")
    public ResponseEntity<List<RoleDto>> getRolesByStatus(@PathVariable Boolean isActive) {
        List<Role> roles = roleService.findByIsActive(isActive);
        List<RoleDto> dtos = roles.stream()
                .map(roleMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }
}

