package com.company.attendance.mapper;

import com.company.attendance.dto.RoleDto;
import com.company.attendance.entity.Role;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-02T15:53:12+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class RoleMapperImpl implements RoleMapper {

    @Override
    public Role toEntity(RoleDto dto) {
        if ( dto == null ) {
            return null;
        }

        Role.RoleBuilder role = Role.builder();

        role.id( dto.getId() );
        role.name( dto.getName() );
        role.description( dto.getDescription() );
        role.displayName( dto.getDisplayName() );
        role.isActive( dto.getIsActive() );
        role.isDefault( dto.getIsDefault() );

        return role.build();
    }

    @Override
    public RoleDto toDto(Role entity) {
        if ( entity == null ) {
            return null;
        }

        RoleDto.RoleDtoBuilder roleDto = RoleDto.builder();

        roleDto.id( entity.getId() );
        roleDto.name( entity.getName() );
        roleDto.description( entity.getDescription() );
        roleDto.displayName( entity.getDisplayName() );
        roleDto.isActive( entity.getIsActive() );
        roleDto.isDefault( entity.getIsDefault() );

        return roleDto.build();
    }
}
