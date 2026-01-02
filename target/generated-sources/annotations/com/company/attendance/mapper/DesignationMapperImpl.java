package com.company.attendance.mapper;

import com.company.attendance.dto.DesignationDto;
import com.company.attendance.entity.Designation;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-02T15:53:13+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
public class DesignationMapperImpl implements DesignationMapper {

    @Override
    public Designation toEntity(DesignationDto dto) {
        if ( dto == null ) {
            return null;
        }

        Designation.DesignationBuilder designation = Designation.builder();

        designation.id( dto.getId() );
        designation.name( dto.getName() );
        designation.code( dto.getCode() );
        designation.description( dto.getDescription() );
        designation.level( dto.getLevel() );
        designation.isActive( dto.getIsActive() );
        designation.createdAt( dto.getCreatedAt() );
        designation.updatedAt( dto.getUpdatedAt() );
        designation.createdBy( dto.getCreatedBy() );
        designation.updatedBy( dto.getUpdatedBy() );

        return designation.build();
    }

    @Override
    public DesignationDto toDto(Designation entity) {
        if ( entity == null ) {
            return null;
        }

        DesignationDto.DesignationDtoBuilder designationDto = DesignationDto.builder();

        designationDto.id( entity.getId() );
        designationDto.name( entity.getName() );
        designationDto.code( entity.getCode() );
        designationDto.description( entity.getDescription() );
        designationDto.level( entity.getLevel() );
        designationDto.isActive( entity.getIsActive() );
        designationDto.createdAt( entity.getCreatedAt() );
        designationDto.updatedAt( entity.getUpdatedAt() );
        designationDto.createdBy( entity.getCreatedBy() );
        designationDto.updatedBy( entity.getUpdatedBy() );

        return designationDto.build();
    }
}
