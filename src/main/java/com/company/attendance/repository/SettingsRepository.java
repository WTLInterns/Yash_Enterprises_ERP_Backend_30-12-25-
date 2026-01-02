package com.company.attendance.repository;

import com.company.attendance.entity.Settings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SettingsRepository extends JpaRepository<Settings, Long> {
    
    Optional<Settings> findBySettingKey(String settingKey);
    
    List<Settings> findByCategory(String category);
    
    @Query("SELECT s FROM Settings s WHERE s.category = :category AND s.isEditable = true")
    List<Settings> findEditableSettingsByCategory(@Param("category") String category);
    
    @Query("SELECT DISTINCT s.category FROM Settings s ORDER BY s.category")
    List<String> findAllCategories();
    
    @Query("SELECT COUNT(s) FROM Settings s WHERE s.settingKey = :settingKey")
    boolean existsBySettingKey(@Param("settingKey") String settingKey);
}
