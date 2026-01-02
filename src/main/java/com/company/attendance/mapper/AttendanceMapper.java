package com.company.attendance.mapper;

import com.company.attendance.dto.AttendanceDto;
import com.company.attendance.entity.Attendance;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface AttendanceMapper {

    @Mapping(target = "employeeId", source = "employee.id")
    @Mapping(target = "status", source = "status")
    AttendanceDto toDto(Attendance attendance);
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "employee", ignore = true)
    Attendance toEntity(AttendanceDto dto);
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "employee", ignore = true)
    void updateEntityFromDto(AttendanceDto dto, @MappingTarget Attendance attendance);
}

