package com.company.attendance.service;
import com.company.attendance.entity.Task;
import com.company.attendance.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    public Task save(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public Optional<Task> findById(Long id) {
        return taskRepository.findById(id);
    }

    public Task getById(Long id) {
        return taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
    }

    public Task update(Long id, Task updated) {
        Task existing = getById(id);
        return taskRepository.save(existing);
    }

    public void delete(Long id) {
        taskRepository.deleteById(id);
    }
}

