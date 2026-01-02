package com.company.attendance.mapper;

import com.company.attendance.dto.ShiftDto;
import com.company.attendance.entity.Shift;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-02T15:53:12+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
public class ShiftMapperImpl implements ShiftMapper {

    @Override
    public Shift toEntity(ShiftDto dto) {
        if ( dto == null ) {
            return null;
        }

        Shift.ShiftBuilder shift = Shift.builder();

        shift.id( dto.getId() );
        shift.name( dto.getName() );
        shift.code( dto.getCode() );
        shift.startTime( dto.getStartTime() );
        shift.endTime( dto.getEndTime() );
        shift.breakStartTime( dto.getBreakStartTime() );
        shift.breakEndTime( dto.getBreakEndTime() );
        shift.gracePeriodInMinutes( dto.getGracePeriodInMinutes() );
        shift.overtimeThresholdInMinutes( dto.getOvertimeThresholdInMinutes() );
        shift.isOverTimeAllowed( dto.getIsOverTimeAllowed() );
        shift.isActive( dto.getIsActive() );
        shift.description( dto.getDescription() );
        shift.createdAt( dto.getCreatedAt() );
        shift.updatedAt( dto.getUpdatedAt() );
        shift.createdBy( dto.getCreatedBy() );
        shift.updatedBy( dto.getUpdatedBy() );

        return shift.build();
    }

    @Override
    public ShiftDto toDto(Shift entity) {
        if ( entity == null ) {
            return null;
        }

        ShiftDto.ShiftDtoBuilder shiftDto = ShiftDto.builder();

        shiftDto.id( entity.getId() );
        shiftDto.name( entity.getName() );
        shiftDto.code( entity.getCode() );
        shiftDto.startTime( entity.getStartTime() );
        shiftDto.endTime( entity.getEndTime() );
        shiftDto.breakStartTime( entity.getBreakStartTime() );
        shiftDto.breakEndTime( entity.getBreakEndTime() );
        shiftDto.gracePeriodInMinutes( entity.getGracePeriodInMinutes() );
        shiftDto.overtimeThresholdInMinutes( entity.getOvertimeThresholdInMinutes() );
        shiftDto.isOverTimeAllowed( entity.getIsOverTimeAllowed() );
        shiftDto.isActive( entity.getIsActive() );
        shiftDto.description( entity.getDescription() );
        shiftDto.createdAt( entity.getCreatedAt() );
        shiftDto.updatedAt( entity.getUpdatedAt() );
        shiftDto.createdBy( entity.getCreatedBy() );
        shiftDto.updatedBy( entity.getUpdatedBy() );

        return shiftDto.build();
    }

    @Override
    public List<ShiftDto> toDtoList(List<Shift> entities) {
        if ( entities == null ) {
            return null;
        }

        List<ShiftDto> list = new ArrayList<ShiftDto>( entities.size() );
        for ( Shift shift : entities ) {
            list.add( toDto( shift ) );
        }

        return list;
    }
}
