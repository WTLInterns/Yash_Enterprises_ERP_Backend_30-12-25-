package com.company.attendance.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SettingsDto {
    private Long id;
    private String category;
    private String key;
    private String value;
    private String description;
    private String dataType;
    private Boolean isEditable;
}
