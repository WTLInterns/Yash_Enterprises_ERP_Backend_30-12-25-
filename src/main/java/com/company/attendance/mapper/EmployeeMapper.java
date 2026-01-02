package com.company.attendance.mapper;

import com.company.attendance.dto.EmployeeDto;
import com.company.attendance.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    @Mapping(target = "passwordHash", ignore = true)
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "team", ignore = true)
    @Mapping(target = "designation", ignore = true)
    @Mapping(target = "reportingManager", ignore = true)
    @Mapping(target = "organization", ignore = true)
    @Mapping(target = "department", ignore = true)
    @Mapping(target = "shift", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    Employee toEntity(EmployeeDto dto);
    
    @Mapping(target = "roleId", ignore = true)
    @Mapping(target = "roleName", ignore = true)
    @Mapping(target = "teamId", ignore = true)
    @Mapping(target = "teamName", ignore = true)
    @Mapping(target = "designationId", ignore = true)
    @Mapping(target = "designationName", ignore = true)
    @Mapping(target = "reportingManagerId", ignore = true)
    @Mapping(target = "reportingManagerName", ignore = true)
    @Mapping(target = "organizationId", ignore = true)
    @Mapping(target = "organizationName", ignore = true)
    @Mapping(target = "departmentId", ignore = true)
    @Mapping(target = "departmentName", ignore = true)
    @Mapping(target = "shiftId", ignore = true)
    @Mapping(target = "shiftName", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    EmployeeDto toDto(Employee entity);

    @Mapping(target = "passwordHash", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "userId", ignore = true)
    @Mapping(target = "employeeId", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    void updateEntityFromDto(EmployeeDto dto, @MappingTarget Employee entity);
}
