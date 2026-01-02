package com.company.attendance.mapper;

import com.company.attendance.dto.PolicyDto;
import com.company.attendance.entity.Policy;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-02T15:53:12+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
public class PolicyMapperImpl implements PolicyMapper {

    @Override
    public Policy toEntity(PolicyDto dto) {
        if ( dto == null ) {
            return null;
        }

        Policy.PolicyBuilder policy = Policy.builder();

        policy.id( dto.getId() );
        policy.name( dto.getName() );
        policy.code( dto.getCode() );
        policy.description( dto.getDescription() );
        policy.type( dto.getType() );
        policy.content( dto.getContent() );
        policy.isActive( dto.getIsActive() );
        policy.isMandatory( dto.getIsMandatory() );
        policy.effectiveFrom( dto.getEffectiveFrom() );
        policy.effectiveTo( dto.getEffectiveTo() );
        policy.createdAt( dto.getCreatedAt() );
        policy.updatedAt( dto.getUpdatedAt() );
        policy.createdBy( dto.getCreatedBy() );
        policy.updatedBy( dto.getUpdatedBy() );

        return policy.build();
    }

    @Override
    public PolicyDto toDto(Policy entity) {
        if ( entity == null ) {
            return null;
        }

        PolicyDto.PolicyDtoBuilder policyDto = PolicyDto.builder();

        policyDto.id( entity.getId() );
        policyDto.name( entity.getName() );
        policyDto.code( entity.getCode() );
        policyDto.description( entity.getDescription() );
        policyDto.type( entity.getType() );
        policyDto.content( entity.getContent() );
        policyDto.isActive( entity.getIsActive() );
        policyDto.isMandatory( entity.getIsMandatory() );
        policyDto.effectiveFrom( entity.getEffectiveFrom() );
        policyDto.effectiveTo( entity.getEffectiveTo() );
        policyDto.createdAt( entity.getCreatedAt() );
        policyDto.updatedAt( entity.getUpdatedAt() );
        policyDto.createdBy( entity.getCreatedBy() );
        policyDto.updatedBy( entity.getUpdatedBy() );

        return policyDto.build();
    }
}
