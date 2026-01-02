package com.company.attendance.mapper;

import com.company.attendance.dto.OrganizationDto;
import com.company.attendance.entity.Organization;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-02T15:53:12+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
public class OrganizationMapperImpl implements OrganizationMapper {

    @Override
    public Organization toEntity(OrganizationDto dto) {
        if ( dto == null ) {
            return null;
        }

        Organization.OrganizationBuilder organization = Organization.builder();

        organization.id( dto.getId() );
        organization.name( dto.getName() );
        organization.code( dto.getCode() );
        organization.logo( dto.getLogo() );
        organization.address( dto.getAddress() );
        organization.city( dto.getCity() );
        organization.state( dto.getState() );
        organization.country( dto.getCountry() );
        organization.pincode( dto.getPincode() );
        organization.contactEmail( dto.getContactEmail() );
        organization.contactPhone( dto.getContactPhone() );
        organization.website( dto.getWebsite() );
        organization.industry( dto.getIndustry() );
        organization.timezone( dto.getTimezone() );
        organization.dateFormat( dto.getDateFormat() );
        organization.timeFormat( dto.getTimeFormat() );
        organization.isActive( dto.getIsActive() );

        return organization.build();
    }

    @Override
    public OrganizationDto toDto(Organization entity) {
        if ( entity == null ) {
            return null;
        }

        OrganizationDto.OrganizationDtoBuilder organizationDto = OrganizationDto.builder();

        organizationDto.id( entity.getId() );
        organizationDto.name( entity.getName() );
        organizationDto.code( entity.getCode() );
        organizationDto.logo( entity.getLogo() );
        organizationDto.address( entity.getAddress() );
        organizationDto.city( entity.getCity() );
        organizationDto.state( entity.getState() );
        organizationDto.country( entity.getCountry() );
        organizationDto.pincode( entity.getPincode() );
        organizationDto.contactEmail( entity.getContactEmail() );
        organizationDto.contactPhone( entity.getContactPhone() );
        organizationDto.website( entity.getWebsite() );
        organizationDto.industry( entity.getIndustry() );
        organizationDto.timezone( entity.getTimezone() );
        organizationDto.dateFormat( entity.getDateFormat() );
        organizationDto.timeFormat( entity.getTimeFormat() );
        organizationDto.isActive( entity.getIsActive() );

        return organizationDto.build();
    }
}
