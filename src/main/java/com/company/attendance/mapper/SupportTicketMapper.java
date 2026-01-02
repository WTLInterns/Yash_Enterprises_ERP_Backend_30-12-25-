package com.company.attendance.mapper;

import com.company.attendance.dto.SupportTicketDto;
import com.company.attendance.entity.SupportTicket;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SupportTicketMapper {
    
    @Mapping(target = "priority", source = "priority")
    @Mapping(target = "status", source = "status")
    SupportTicketDto toDto(SupportTicket entity);
    
    @Mapping(target = "priority", source = "priority")
    @Mapping(target = "status", source = "status")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    SupportTicket toEntity(SupportTicketDto dto);
    
    @Mapping(target = "priority", source = "priority")
    @Mapping(target = "status", source = "status")
    void updateEntityFromDto(SupportTicketDto dto, @MappingTarget SupportTicket entity);
}
