package com.company.attendance.controller;

import com.company.attendance.dto.SettingsDto;
import com.company.attendance.service.SettingsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/settings")
@RequiredArgsConstructor
@Slf4j
public class SettingsController {
    
    private final SettingsService settingsService;
    
    @GetMapping
    public ResponseEntity<List<SettingsDto>> getAllSettings() {
        log.info("GET /api/settings - Fetching all settings");
        List<SettingsDto> settings = settingsService.getAllSettings();
        return ResponseEntity.ok(settings);
    }
    
    @GetMapping("/category/{category}")
    public ResponseEntity<List<SettingsDto>> getSettingsByCategory(@PathVariable String category) {
        log.info("GET /api/settings/category/{} - Fetching settings for category", category);
        List<SettingsDto> settings = settingsService.getSettingsByCategory(category);
        return ResponseEntity.ok(settings);
    }
    
    @GetMapping("/key/{key}")
    public ResponseEntity<SettingsDto> getSettingByKey(@PathVariable String key) {
        log.info("GET /api/settings/key/{} - Fetching setting by key", key);
        try {
            SettingsDto setting = settingsService.getSettingByKey(key);
            return ResponseEntity.ok(setting);
        } catch (RuntimeException e) {
            log.error("Error fetching setting: {}", e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }
    
    @PutMapping("/key/{key}")
    public ResponseEntity<SettingsDto> updateSetting(@PathVariable String key, @RequestBody Map<String, String> request) {
        log.info("PUT /api/settings/key/{} - Updating setting", key);
        try {
            String value = request.get("value");
            SettingsDto updatedSetting = settingsService.updateSetting(key, value);
            return ResponseEntity.ok(updatedSetting);
        } catch (RuntimeException e) {
            log.error("Error updating setting: {}", e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
    
    @PutMapping("/category/{category}")
    public ResponseEntity<List<SettingsDto>> updateCategorySettings(@PathVariable String category, @RequestBody Map<String, String> updates) {
        log.info("PUT /api/settings/category/{} - Updating settings for category", category);
        try {
            List<SettingsDto> updatedSettings = settingsService.updateCategorySettings(category, updates);
            return ResponseEntity.ok(updatedSettings);
        } catch (Exception e) {
            log.error("Error updating category settings: {}", e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
    
    @GetMapping("/general")
    public ResponseEntity<Map<String, Object>> getGeneralSettings() {
        log.info("GET /api/settings/general - Fetching general settings");
        Map<String, Object> settings = settingsService.getGeneralSettings();
        return ResponseEntity.ok(settings);
    }
    
    @GetMapping("/security")
    public ResponseEntity<Map<String, Object>> getSecuritySettings() {
        log.info("GET /api/settings/security - Fetching security settings");
        Map<String, Object> settings = settingsService.getSecuritySettings();
        return ResponseEntity.ok(settings);
    }
    
    @GetMapping("/notifications")
    public ResponseEntity<Map<String, Object>> getNotificationSettings() {
        log.info("GET /api/settings/notifications - Fetching notification settings");
        Map<String, Object> settings = settingsService.getNotificationSettings();
        return ResponseEntity.ok(settings);
    }
    
    @GetMapping("/system")
    public ResponseEntity<Map<String, Object>> getSystemSettings() {
        log.info("GET /api/settings/system - Fetching system settings");
        Map<String, Object> settings = settingsService.getSystemSettings();
        return ResponseEntity.ok(settings);
    }
    
    @PutMapping("/general")
    public ResponseEntity<Map<String, Object>> updateGeneralSettings(@RequestBody Map<String, String> updates) {
        log.info("PUT /api/settings/general - Updating general settings");
        try {
            settingsService.updateCategorySettings("general", updates);
            Map<String, Object> settings = settingsService.getGeneralSettings();
            return ResponseEntity.ok(settings);
        } catch (Exception e) {
            log.error("Error updating general settings: {}", e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
    
    @PutMapping("/security")
    public ResponseEntity<Map<String, Object>> updateSecuritySettings(@RequestBody Map<String, Object> updates) {
        log.info("PUT /api/settings/security - Updating security settings");
        try {
            // Convert object values to strings for the service
            Map<String, String> stringUpdates = updates.entrySet().stream()
                    .collect(Collectors.toMap(
                            Map.Entry::getKey,
                            entry -> entry.getValue().toString()
                    ));
            settingsService.updateCategorySettings("security", stringUpdates);
            Map<String, Object> settings = settingsService.getSecuritySettings();
            return ResponseEntity.ok(settings);
        } catch (Exception e) {
            log.error("Error updating security settings: {}", e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
    
    @PutMapping("/notifications")
    public ResponseEntity<Map<String, Object>> updateNotificationSettings(@RequestBody Map<String, Boolean> updates) {
        log.info("PUT /api/settings/notifications - Updating notification settings");
        try {
            Map<String, String> stringUpdates = updates.entrySet().stream()
                    .collect(Collectors.toMap(
                            Map.Entry::getKey,
                            entry -> entry.getValue().toString()
                    ));
            settingsService.updateCategorySettings("notifications", stringUpdates);
            Map<String, Object> settings = settingsService.getNotificationSettings();
            return ResponseEntity.ok(settings);
        } catch (Exception e) {
            log.error("Error updating notification settings: {}", e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
    
    @PutMapping("/system")
    public ResponseEntity<Map<String, Object>> updateSystemSettings(@RequestBody Map<String, Object> updates) {
        log.info("PUT /api/settings/system - Updating system settings");
        try {
            Map<String, String> stringUpdates = updates.entrySet().stream()
                    .collect(Collectors.toMap(
                            Map.Entry::getKey,
                            entry -> entry.getValue().toString()
                    ));
            settingsService.updateCategorySettings("system", stringUpdates);
            Map<String, Object> settings = settingsService.getSystemSettings();
            return ResponseEntity.ok(settings);
        } catch (Exception e) {
            log.error("Error updating system settings: {}", e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
    
    @PostMapping("/initialize")
    public ResponseEntity<Void> initializeDefaultSettings() {
        log.info("POST /api/settings/initialize - Initializing default settings");
        settingsService.initializeDefaultSettings();
        return ResponseEntity.ok().build();
    }
}
