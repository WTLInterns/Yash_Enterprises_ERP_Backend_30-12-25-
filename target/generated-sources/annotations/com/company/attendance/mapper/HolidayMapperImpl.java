package com.company.attendance.mapper;

import com.company.attendance.dto.HolidayDto;
import com.company.attendance.entity.Holiday;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-02T15:53:13+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
public class HolidayMapperImpl implements HolidayMapper {

    @Override
    public Holiday toEntity(HolidayDto dto) {
        if ( dto == null ) {
            return null;
        }

        Holiday.HolidayBuilder holiday = Holiday.builder();

        holiday.id( dto.getId() );
        holiday.name( dto.getName() );
        holiday.description( dto.getDescription() );
        holiday.date( dto.getDate() );
        holiday.type( dto.getType() );
        holiday.isOptional( dto.getIsOptional() );
        holiday.isActive( dto.getIsActive() );
        holiday.createdAt( dto.getCreatedAt() );
        holiday.updatedAt( dto.getUpdatedAt() );
        holiday.createdBy( dto.getCreatedBy() );
        holiday.updatedBy( dto.getUpdatedBy() );

        return holiday.build();
    }

    @Override
    public HolidayDto toDto(Holiday entity) {
        if ( entity == null ) {
            return null;
        }

        HolidayDto.HolidayDtoBuilder holidayDto = HolidayDto.builder();

        holidayDto.id( entity.getId() );
        holidayDto.name( entity.getName() );
        holidayDto.description( entity.getDescription() );
        holidayDto.date( entity.getDate() );
        holidayDto.type( entity.getType() );
        holidayDto.isOptional( entity.getIsOptional() );
        holidayDto.isActive( entity.getIsActive() );
        holidayDto.createdAt( entity.getCreatedAt() );
        holidayDto.updatedAt( entity.getUpdatedAt() );
        holidayDto.createdBy( entity.getCreatedBy() );
        holidayDto.updatedBy( entity.getUpdatedBy() );

        return holidayDto.build();
    }
}
