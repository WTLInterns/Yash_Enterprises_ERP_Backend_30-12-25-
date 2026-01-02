package com.company.attendance.mapper;

import com.company.attendance.dto.AnnouncementDto;
import com.company.attendance.entity.Announcement;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-02T15:53:11+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class AnnouncementMapperImpl implements AnnouncementMapper {

    @Override
    public Announcement toEntity(AnnouncementDto dto) {
        if ( dto == null ) {
            return null;
        }

        Announcement.AnnouncementBuilder announcement = Announcement.builder();

        announcement.id( dto.getId() );
        announcement.title( dto.getTitle() );
        announcement.content( dto.getContent() );
        announcement.type( dto.getType() );
        announcement.publishFrom( dto.getPublishFrom() );
        announcement.publishTo( dto.getPublishTo() );
        announcement.isActive( dto.getIsActive() );
        announcement.isPinned( dto.getIsPinned() );
        announcement.createdAt( dto.getCreatedAt() );
        announcement.updatedAt( dto.getUpdatedAt() );
        announcement.createdBy( dto.getCreatedBy() );
        announcement.updatedBy( dto.getUpdatedBy() );

        return announcement.build();
    }

    @Override
    public AnnouncementDto toDto(Announcement entity) {
        if ( entity == null ) {
            return null;
        }

        AnnouncementDto.AnnouncementDtoBuilder announcementDto = AnnouncementDto.builder();

        announcementDto.id( entity.getId() );
        announcementDto.title( entity.getTitle() );
        announcementDto.content( entity.getContent() );
        announcementDto.type( entity.getType() );
        announcementDto.publishFrom( entity.getPublishFrom() );
        announcementDto.publishTo( entity.getPublishTo() );
        announcementDto.isActive( entity.getIsActive() );
        announcementDto.isPinned( entity.getIsPinned() );
        announcementDto.createdAt( entity.getCreatedAt() );
        announcementDto.updatedAt( entity.getUpdatedAt() );
        announcementDto.createdBy( entity.getCreatedBy() );
        announcementDto.updatedBy( entity.getUpdatedBy() );

        return announcementDto.build();
    }

    @Override
    public void updateEntityFromDto(AnnouncementDto dto, Announcement entity) {
        if ( dto == null ) {
            return;
        }

        entity.setId( dto.getId() );
        entity.setTitle( dto.getTitle() );
        entity.setCreatedAt( dto.getCreatedAt() );
        entity.setUpdatedAt( dto.getUpdatedAt() );
        entity.setContent( dto.getContent() );
        entity.setType( dto.getType() );
        entity.setPublishFrom( dto.getPublishFrom() );
        entity.setPublishTo( dto.getPublishTo() );
        entity.setIsActive( dto.getIsActive() );
        entity.setIsPinned( dto.getIsPinned() );
        entity.setCreatedBy( dto.getCreatedBy() );
        entity.setUpdatedBy( dto.getUpdatedBy() );
    }
}
