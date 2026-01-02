package com.company.attendance.mapper;

import com.company.attendance.dto.CaseDto;
import com.company.attendance.entity.Case;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-02T15:53:13+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class CaseMapperImpl implements CaseMapper {

    @Override
    public CaseDto toDto(Case caseEntity) {
        if ( caseEntity == null ) {
            return null;
        }

        CaseDto caseDto = new CaseDto();

        caseDto.setId( caseEntity.getId() );
        caseDto.setCaseNumber( caseEntity.getCaseNumber() );
        caseDto.setTitle( caseEntity.getTitle() );
        caseDto.setDescription( caseEntity.getDescription() );
        if ( caseEntity.getStatus() != null ) {
            caseDto.setStatus( caseEntity.getStatus().name() );
        }
        if ( caseEntity.getPriority() != null ) {
            caseDto.setPriority( caseEntity.getPriority().name() );
        }
        caseDto.setCreatedAt( caseEntity.getCreatedAt() );
        caseDto.setUpdatedAt( caseEntity.getUpdatedAt() );

        return caseDto;
    }

    @Override
    public Case toEntity(CaseDto caseDto) {
        if ( caseDto == null ) {
            return null;
        }

        Case.CaseBuilder case1 = Case.builder();

        case1.id( caseDto.getId() );
        case1.caseNumber( caseDto.getCaseNumber() );
        case1.title( caseDto.getTitle() );
        case1.description( caseDto.getDescription() );
        if ( caseDto.getStatus() != null ) {
            case1.status( Enum.valueOf( Case.CaseStatus.class, caseDto.getStatus() ) );
        }
        if ( caseDto.getPriority() != null ) {
            case1.priority( Enum.valueOf( Case.Priority.class, caseDto.getPriority() ) );
        }
        case1.createdAt( caseDto.getCreatedAt() );
        case1.updatedAt( caseDto.getUpdatedAt() );

        return case1.build();
    }

    @Override
    public void updateEntityFromDto(CaseDto caseDto, Case caseEntity) {
        if ( caseDto == null ) {
            return;
        }

        caseEntity.setId( caseDto.getId() );
        caseEntity.setCaseNumber( caseDto.getCaseNumber() );
        caseEntity.setTitle( caseDto.getTitle() );
        caseEntity.setDescription( caseDto.getDescription() );
        if ( caseDto.getStatus() != null ) {
            caseEntity.setStatus( Enum.valueOf( Case.CaseStatus.class, caseDto.getStatus() ) );
        }
        else {
            caseEntity.setStatus( null );
        }
        if ( caseDto.getPriority() != null ) {
            caseEntity.setPriority( Enum.valueOf( Case.Priority.class, caseDto.getPriority() ) );
        }
        else {
            caseEntity.setPriority( null );
        }
        caseEntity.setCreatedAt( caseDto.getCreatedAt() );
        caseEntity.setUpdatedAt( caseDto.getUpdatedAt() );
    }

    @Override
    public List<CaseDto> toDtoList(List<Case> cases) {
        if ( cases == null ) {
            return null;
        }

        List<CaseDto> list = new ArrayList<CaseDto>( cases.size() );
        for ( Case case1 : cases ) {
            list.add( toDto( case1 ) );
        }

        return list;
    }

    @Override
    public List<Case> toEntityList(List<CaseDto> caseDtos) {
        if ( caseDtos == null ) {
            return null;
        }

        List<Case> list = new ArrayList<Case>( caseDtos.size() );
        for ( CaseDto caseDto : caseDtos ) {
            list.add( toEntity( caseDto ) );
        }

        return list;
    }
}
