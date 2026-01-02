package com.company.attendance.controller;
import com.company.attendance.dto.TaskDto;
import com.company.attendance.entity.Task;
import com.company.attendance.mapper.TaskMapper;
import com.company.attendance.service.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;
    private final TaskMapper taskMapper;
    @GetMapping
    public ResponseEntity<List<TaskDto>> listTasks() {
        var tasks = taskService.findAll();
        var dtos = tasks.stream().map(taskMapper::toDto).collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }
    @GetMapping("/{id}")
    public ResponseEntity<TaskDto> getTask(@PathVariable Long id) {
        return taskService.findById(id)
                .map(taskMapper::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<TaskDto> createTask(@Valid @RequestBody TaskDto dto) {
        Task task = taskService.save(taskMapper.toEntity(dto));
        return ResponseEntity.ok(taskMapper.toDto(task));
    }
    @PutMapping("/{id}")
    public ResponseEntity<TaskDto> updateTask(@PathVariable Long id, @Valid @RequestBody TaskDto dto) {
        Task task = taskMapper.toEntity(dto);
        Task updated = taskService.update(id, task);
        return ResponseEntity.ok(taskMapper.toDto(updated));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

