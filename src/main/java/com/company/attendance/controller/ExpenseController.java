package com.company.attendance.controller;
import com.company.attendance.dto.ExpenseDto;
import com.company.attendance.entity.Expense;
import com.company.attendance.mapper.ExpenseMapper;
import com.company.attendance.service.ExpenseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/api/expenses")
@RequiredArgsConstructor
public class ExpenseController {
    private final ExpenseService expenseService;
    private final ExpenseMapper expenseMapper;
    @GetMapping
    public ResponseEntity<List<ExpenseDto>> listExpenses() {
        var expenses = expenseService.findAll();
        var dtos = expenses.stream().map(expenseMapper::toDto).collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ExpenseDto> getExpense(@PathVariable Long id) {
        return expenseService.findById(id)
                .map(expenseMapper::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<ExpenseDto> createExpense(@Valid @RequestBody ExpenseDto dto) {
        Expense expense = expenseService.save(expenseMapper.toEntity(dto));
        return ResponseEntity.ok(expenseMapper.toDto(expense));
    }
    @PutMapping("/{id}")
    public ResponseEntity<ExpenseDto> updateExpense(@PathVariable Long id, @Valid @RequestBody ExpenseDto dto) {
        Expense expense = expenseMapper.toEntity(dto);
        Expense updated = expenseService.update(id, expense);
        return ResponseEntity.ok(expenseMapper.toDto(updated));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExpense(@PathVariable Long id) {
        expenseService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

