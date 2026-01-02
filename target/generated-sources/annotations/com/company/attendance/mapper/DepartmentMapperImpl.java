package com.company.attendance.mapper;

import com.company.attendance.dto.DepartmentDto;
import com.company.attendance.entity.Department;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-02T15:53:11+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
public class DepartmentMapperImpl implements DepartmentMapper {

    @Override
    public Department toEntity(DepartmentDto dto) {
        if ( dto == null ) {
            return null;
        }

        Department.DepartmentBuilder department = Department.builder();

        department.id( dto.getId() );
        department.name( dto.getName() );
        department.code( dto.getCode() );
        department.description( dto.getDescription() );
        department.headOfDepartmentId( dto.getHeadOfDepartmentId() );
        department.isActive( dto.getIsActive() );
        department.createdAt( dto.getCreatedAt() );
        department.updatedAt( dto.getUpdatedAt() );
        department.createdBy( dto.getCreatedBy() );
        department.updatedBy( dto.getUpdatedBy() );

        return department.build();
    }

    @Override
    public DepartmentDto toDto(Department entity) {
        if ( entity == null ) {
            return null;
        }

        DepartmentDto.DepartmentDtoBuilder departmentDto = DepartmentDto.builder();

        departmentDto.id( entity.getId() );
        departmentDto.name( entity.getName() );
        departmentDto.code( entity.getCode() );
        departmentDto.description( entity.getDescription() );
        departmentDto.headOfDepartmentId( entity.getHeadOfDepartmentId() );
        departmentDto.isActive( entity.getIsActive() );
        departmentDto.createdAt( entity.getCreatedAt() );
        departmentDto.updatedAt( entity.getUpdatedAt() );
        departmentDto.createdBy( entity.getCreatedBy() );
        departmentDto.updatedBy( entity.getUpdatedBy() );

        return departmentDto.build();
    }
}
