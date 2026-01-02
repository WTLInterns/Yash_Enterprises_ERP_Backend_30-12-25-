package com.company.attendance.mapper;

import com.company.attendance.dto.SupportTicketDto;
import com.company.attendance.entity.SupportTicket;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-02T15:53:13+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class SupportTicketMapperImpl implements SupportTicketMapper {

    @Override
    public SupportTicketDto toDto(SupportTicket entity) {
        if ( entity == null ) {
            return null;
        }

        SupportTicketDto supportTicketDto = new SupportTicketDto();

        supportTicketDto.setPriority( entity.getPriority() );
        supportTicketDto.setStatus( entity.getStatus() );
        supportTicketDto.setId( entity.getId() );
        supportTicketDto.setSubject( entity.getSubject() );
        supportTicketDto.setDescription( entity.getDescription() );
        supportTicketDto.setCategory( entity.getCategory() );
        supportTicketDto.setCreatedAt( entity.getCreatedAt() );
        supportTicketDto.setUpdatedAt( entity.getUpdatedAt() );
        supportTicketDto.setCreatedBy( entity.getCreatedBy() );
        supportTicketDto.setAssignedTo( entity.getAssignedTo() );
        supportTicketDto.setResolution( entity.getResolution() );

        return supportTicketDto;
    }

    @Override
    public SupportTicket toEntity(SupportTicketDto dto) {
        if ( dto == null ) {
            return null;
        }

        SupportTicket.SupportTicketBuilder supportTicket = SupportTicket.builder();

        supportTicket.priority( dto.getPriority() );
        supportTicket.status( dto.getStatus() );
        supportTicket.subject( dto.getSubject() );
        supportTicket.description( dto.getDescription() );
        supportTicket.category( dto.getCategory() );
        supportTicket.createdBy( dto.getCreatedBy() );
        supportTicket.assignedTo( dto.getAssignedTo() );
        supportTicket.resolution( dto.getResolution() );

        return supportTicket.build();
    }

    @Override
    public void updateEntityFromDto(SupportTicketDto dto, SupportTicket entity) {
        if ( dto == null ) {
            return;
        }

        entity.setPriority( dto.getPriority() );
        entity.setStatus( dto.getStatus() );
        entity.setId( dto.getId() );
        entity.setSubject( dto.getSubject() );
        entity.setDescription( dto.getDescription() );
        entity.setCategory( dto.getCategory() );
        entity.setCreatedAt( dto.getCreatedAt() );
        entity.setUpdatedAt( dto.getUpdatedAt() );
        entity.setCreatedBy( dto.getCreatedBy() );
        entity.setAssignedTo( dto.getAssignedTo() );
        entity.setResolution( dto.getResolution() );
    }
}
