package com.company.attendance.service;

import com.company.attendance.dto.SettingsDto;
import com.company.attendance.entity.Settings;
import com.company.attendance.mapper.SettingsMapper;
import com.company.attendance.repository.SettingsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class SettingsService {
    
    private final SettingsRepository settingsRepository;
    private final SettingsMapper settingsMapper;
    
    public List<SettingsDto> getAllSettings() {
        log.info("Fetching all settings");
        List<Settings> settings = settingsRepository.findAll();
        return settings.stream()
                .map(settingsMapper::toDto)
                .collect(Collectors.toList());
    }
    
    public List<SettingsDto> getSettingsByCategory(String category) {
        log.info("Fetching settings for category: {}", category);
        List<Settings> settings = settingsRepository.findEditableSettingsByCategory(category);
        return settings.stream()
                .map(settingsMapper::toDto)
                .collect(Collectors.toList());
    }
    
    public SettingsDto getSettingByKey(String key) {
        log.info("Fetching setting with key: {}", key);
        Settings setting = settingsRepository.findBySettingKey(key)
                .orElseThrow(() -> new RuntimeException("Setting not found with key: " + key));
        return settingsMapper.toDto(setting);
    }

    public SettingsDto updateSetting(String key, String value) {
        log.info("Updating setting with key: {} to value: {}", key, value);
        Settings setting = settingsRepository.findBySettingKey(key)
                .orElseThrow(() -> new RuntimeException("Setting not found with key: " + key));
        
        if (!Boolean.TRUE.equals(setting.getIsEditable())) {
            throw new RuntimeException("Setting is not editable: " + key);
        }
        
        setting.setValue(value);
        Settings updatedSetting = settingsRepository.save(setting);
        log.info("Updated setting with key: {}", updatedSetting.getSettingKey());
        return settingsMapper.toDto(updatedSetting);
    }
    
    public List<SettingsDto> updateCategorySettings(String category, Map<String, String> updates) {
        log.info("Updating settings for category: {}", category);
        List<Settings> existingSettings = settingsRepository.findEditableSettingsByCategory(category);
        
        List<Settings> updatedSettings = existingSettings.stream()
                .map(setting -> {
                    if (updates.containsKey(setting.getSettingKey())) {
                        setting.setValue(updates.get(setting.getSettingKey()));
                    }
                    return setting;
                })
                .collect(Collectors.toList());
        
        List<Settings> savedSettings = settingsRepository.saveAll(updatedSettings);
        log.info("Updated {} settings for category: {}", savedSettings.size(), category);
        
        return savedSettings.stream()
                .map(settingsMapper::toDto)
                .collect(Collectors.toList());
    }
    
    public Map<String, Object> getGeneralSettings() {
        log.info("Fetching general settings");
        List<Settings> settings = settingsRepository.findByCategory("general");
        return settings.stream()
                .collect(Collectors.toMap(Settings::getSettingKey, Settings::getValue));
    }
    
    public Map<String, Object> getSecuritySettings() {
        log.info("Fetching security settings");
        List<Settings> settings = settingsRepository.findByCategory("security");
        return settings.stream()
                .collect(Collectors.toMap(Settings::getSettingKey, Settings::getValue));
    }
    
    public Map<String, Object> getNotificationSettings() {
        log.info("Fetching notification settings");
        List<Settings> settings = settingsRepository.findByCategory("notifications");
        return settings.stream()
                .collect(Collectors.toMap(Settings::getSettingKey, setting -> {
                    // Convert boolean strings to boolean
                    if ("true".equals(setting.getValue()) || "false".equals(setting.getValue())) {
                        return Boolean.parseBoolean(setting.getValue());
                    }
                    return setting.getValue();
                }));
    }
    
    public Map<String, Object> getSystemSettings() {
        log.info("Fetching system settings");
        List<Settings> settings = settingsRepository.findByCategory("system");
        return settings.stream()
                .collect(Collectors.toMap(Settings::getSettingKey, setting -> {
                        // Convert numeric strings to integers
                        try {
                            return Integer.parseInt(setting.getValue());
                        } catch (NumberFormatException e) {
                            return setting.getValue();
                        }
                }));
    }
    
    public void initializeDefaultSettings() {
        log.info("Initializing default settings");
        
        // General Settings
        saveIfNotExists("general", "companyName", "Yash Enterprises", "Company name", "string", true);
        saveIfNotExists("general", "email", "admin@yashenterprises.com", "Company email", "string", true);
        saveIfNotExists("general", "phone", "+91-9876543210", "Company phone", "string", true);
        saveIfNotExists("general", "address", "123 Business Street, Mumbai, India", "Company address", "string", true);
        saveIfNotExists("general", "timezone", "Asia/Kolkata", "Timezone", "string", true);
        saveIfNotExists("general", "dateFormat", "DD/MM/YYYY", "Date format", "string", true);
        saveIfNotExists("general", "language", "English", "Language", "string", true);
        
        // Security Settings
        saveIfNotExists("security", "twoFactorAuth", "false", "Enable two-factor authentication", "boolean", true);
        saveIfNotExists("security", "sessionTimeout", "30", "Session timeout in minutes", "string", true);
        saveIfNotExists("security", "passwordPolicy", "medium", "Password policy strength", "string", true);
        saveIfNotExists("security", "loginAttempts", "5", "Maximum login attempts", "string", true);
        saveIfNotExists("security", "lockoutDuration", "15", "Lockout duration in minutes", "string", true);
        
        // Notification Settings
        saveIfNotExists("notifications", "emailNotifications", "true", "Enable email notifications", "boolean", true);
        saveIfNotExists("notifications", "smsNotifications", "false", "Enable SMS notifications", "boolean", true);
        saveIfNotExists("notifications", "pushNotifications", "true", "Enable push notifications", "boolean", true);
        saveIfNotExists("notifications", "attendanceAlerts", "true", "Enable attendance alerts", "boolean", true);
        saveIfNotExists("notifications", "leaveAlerts", "true", "Enable leave alerts", "boolean", true);
        saveIfNotExists("notifications", "reportAlerts", "false", "Enable report alerts", "boolean", true);
        
        // System Settings
        saveIfNotExists("system", "maintenanceMode", "false", "Maintenance mode", "boolean", true);
        saveIfNotExists("system", "backupFrequency", "daily", "Backup frequency", "string", true);
        saveIfNotExists("system", "logRetention", "30", "Log retention in days", "string", true);
        saveIfNotExists("system", "maxFileSize", "10", "Maximum file size in MB", "string", true);
        saveIfNotExists("system", "concurrentUsers", "100", "Concurrent users limit", "string", true);
        
        log.info("Default settings initialized successfully");
    }
    
    private void saveIfNotExists(String category, String key, String value, String description, String dataType, Boolean isEditable) {
        if (!settingsRepository.existsBySettingKey(key)) {
            Settings setting = Settings.builder()
                    .category(category)
                    .settingKey(key)
                    .value(value)
                    .description(description)
                    .dataType(dataType)
                    .isEditable(isEditable)
                    .build();
            settingsRepository.save(setting);
            log.info("Created default setting: {} = {}", key, value);
        }
    }
}
