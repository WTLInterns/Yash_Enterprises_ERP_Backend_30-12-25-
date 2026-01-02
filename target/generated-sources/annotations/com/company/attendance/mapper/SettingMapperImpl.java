package com.company.attendance.mapper;

import com.company.attendance.dto.SettingDto;
import com.company.attendance.entity.Setting;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-02T15:53:11+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class SettingMapperImpl implements SettingMapper {

    @Override
    public SettingDto toDto(Setting o) {
        if ( o == null ) {
            return null;
        }

        SettingDto settingDto = new SettingDto();

        settingDto.setId( o.getId() );
        settingDto.setKey( o.getKey() );
        settingDto.setValue( o.getValue() );

        return settingDto;
    }

    @Override
    public Setting toEntity(SettingDto dto) {
        if ( dto == null ) {
            return null;
        }

        Setting.SettingBuilder setting = Setting.builder();

        setting.id( dto.getId() );
        setting.key( dto.getKey() );
        setting.value( dto.getValue() );

        return setting.build();
    }
}
