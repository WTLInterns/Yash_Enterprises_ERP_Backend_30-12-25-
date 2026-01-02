package com.company.attendance.mapper;

import com.company.attendance.dto.FormDto;
import com.company.attendance.entity.Form;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-02T15:53:12+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class FormMapperImpl implements FormMapper {

    @Override
    public FormDto toDto(Form form) {
        if ( form == null ) {
            return null;
        }

        FormDto formDto = new FormDto();

        formDto.setId( form.getId() );
        formDto.setName( form.getName() );
        formDto.setSchema( form.getSchema() );
        formDto.setCreatedBy( form.getCreatedBy() );
        formDto.setIsActive( form.getIsActive() );

        return formDto;
    }

    @Override
    public Form toEntity(FormDto dto) {
        if ( dto == null ) {
            return null;
        }

        Form.FormBuilder form = Form.builder();

        form.id( dto.getId() );
        form.name( dto.getName() );
        form.schema( dto.getSchema() );
        form.createdBy( dto.getCreatedBy() );
        form.isActive( dto.getIsActive() );

        return form.build();
    }
}
