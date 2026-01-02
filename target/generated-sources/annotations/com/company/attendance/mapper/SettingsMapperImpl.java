package com.company.attendance.mapper;

import com.company.attendance.dto.SettingsDto;
import com.company.attendance.entity.Settings;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-02T15:53:12+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class SettingsMapperImpl implements SettingsMapper {

    @Override
    public SettingsDto toDto(Settings entity) {
        if ( entity == null ) {
            return null;
        }

        SettingsDto settingsDto = new SettingsDto();

        settingsDto.setId( entity.getId() );
        settingsDto.setCategory( entity.getCategory() );
        settingsDto.setValue( entity.getValue() );
        settingsDto.setDescription( entity.getDescription() );
        settingsDto.setDataType( entity.getDataType() );
        settingsDto.setIsEditable( entity.getIsEditable() );

        return settingsDto;
    }

    @Override
    public Settings toEntity(SettingsDto dto) {
        if ( dto == null ) {
            return null;
        }

        Settings.SettingsBuilder settings = Settings.builder();

        settings.category( dto.getCategory() );
        settings.value( dto.getValue() );
        settings.description( dto.getDescription() );
        settings.dataType( dto.getDataType() );
        settings.isEditable( dto.getIsEditable() );

        return settings.build();
    }

    @Override
    public void updateEntityFromDto(SettingsDto dto, Settings entity) {
        if ( dto == null ) {
            return;
        }

        entity.setCategory( dto.getCategory() );
        entity.setValue( dto.getValue() );
        entity.setDescription( dto.getDescription() );
        entity.setDataType( dto.getDataType() );
        entity.setIsEditable( dto.getIsEditable() );
    }
}
