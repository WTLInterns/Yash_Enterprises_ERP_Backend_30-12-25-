package com.company.attendance.mapper;

import com.company.attendance.dto.PermissionDto;
import com.company.attendance.entity.Permission;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-02T15:53:13+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
public class PermissionMapperImpl implements PermissionMapper {

    @Override
    public Permission toEntity(PermissionDto dto) {
        if ( dto == null ) {
            return null;
        }

        Permission.PermissionBuilder permission = Permission.builder();

        permission.id( dto.getId() );
        permission.name( dto.getName() );
        permission.displayName( dto.getDisplayName() );
        permission.description( dto.getDescription() );
        permission.module( dto.getModule() );
        permission.resource( dto.getResource() );
        permission.action( dto.getAction() );
        permission.isActive( dto.getIsActive() );

        return permission.build();
    }

    @Override
    public PermissionDto toDto(Permission entity) {
        if ( entity == null ) {
            return null;
        }

        PermissionDto.PermissionDtoBuilder permissionDto = PermissionDto.builder();

        permissionDto.id( entity.getId() );
        permissionDto.name( entity.getName() );
        permissionDto.displayName( entity.getDisplayName() );
        permissionDto.description( entity.getDescription() );
        permissionDto.module( entity.getModule() );
        permissionDto.resource( entity.getResource() );
        permissionDto.action( entity.getAction() );
        permissionDto.isActive( entity.getIsActive() );

        return permissionDto.build();
    }
}
