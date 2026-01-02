package com.company.attendance.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SupportTicketDto {
    private Long id;
    private String subject;
    private String description;
    private String priority;
    private String status;
    private String category;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Long createdBy;
    private Long assignedTo;
    private String resolution;
}
