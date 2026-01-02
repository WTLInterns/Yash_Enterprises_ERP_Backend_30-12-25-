package com.company.attendance.mapper;

import com.company.attendance.dto.CaseDocumentDto;
import com.company.attendance.entity.CaseDocument;
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
public class CaseDocumentMapperImpl implements CaseDocumentMapper {

    @Override
    public CaseDocumentDto toDto(CaseDocument document) {
        if ( document == null ) {
            return null;
        }

        CaseDocumentDto caseDocumentDto = new CaseDocumentDto();

        caseDocumentDto.setId( document.getId() );
        caseDocumentDto.setDocumentName( document.getDocumentName() );
        caseDocumentDto.setDescription( document.getDescription() );
        caseDocumentDto.setFileName( document.getFileName() );
        caseDocumentDto.setFilePath( document.getFilePath() );
        caseDocumentDto.setFileType( document.getFileType() );
        caseDocumentDto.setFileSize( document.getFileSize() );
        caseDocumentDto.setCreatedAt( document.getCreatedAt() );
        caseDocumentDto.setUpdatedAt( document.getUpdatedAt() );

        return caseDocumentDto;
    }

    @Override
    public CaseDocument toEntity(CaseDocumentDto documentDto) {
        if ( documentDto == null ) {
            return null;
        }

        CaseDocument.CaseDocumentBuilder caseDocument = CaseDocument.builder();

        caseDocument.id( documentDto.getId() );
        caseDocument.documentName( documentDto.getDocumentName() );
        caseDocument.fileName( documentDto.getFileName() );
        caseDocument.filePath( documentDto.getFilePath() );
        caseDocument.fileType( documentDto.getFileType() );
        caseDocument.fileSize( documentDto.getFileSize() );
        caseDocument.description( documentDto.getDescription() );
        caseDocument.createdAt( documentDto.getCreatedAt() );
        caseDocument.updatedAt( documentDto.getUpdatedAt() );

        return caseDocument.build();
    }

    @Override
    public void updateEntityFromDto(CaseDocumentDto documentDto, CaseDocument document) {
        if ( documentDto == null ) {
            return;
        }

        document.setFileName( documentDto.getFileName() );
        document.setFilePath( documentDto.getFilePath() );
        document.setFileType( documentDto.getFileType() );
        document.setFileSize( documentDto.getFileSize() );
        document.setId( documentDto.getId() );
        document.setDocumentName( documentDto.getDocumentName() );
        document.setDescription( documentDto.getDescription() );
        document.setCreatedAt( documentDto.getCreatedAt() );
        document.setUpdatedAt( documentDto.getUpdatedAt() );
    }

    @Override
    public List<CaseDocumentDto> toDtoList(List<CaseDocument> documents) {
        if ( documents == null ) {
            return null;
        }

        List<CaseDocumentDto> list = new ArrayList<CaseDocumentDto>( documents.size() );
        for ( CaseDocument caseDocument : documents ) {
            list.add( toDto( caseDocument ) );
        }

        return list;
    }

    @Override
    public List<CaseDocument> toEntityList(List<CaseDocumentDto> documentDtos) {
        if ( documentDtos == null ) {
            return null;
        }

        List<CaseDocument> list = new ArrayList<CaseDocument>( documentDtos.size() );
        for ( CaseDocumentDto caseDocumentDto : documentDtos ) {
            list.add( toEntity( caseDocumentDto ) );
        }

        return list;
    }
}
