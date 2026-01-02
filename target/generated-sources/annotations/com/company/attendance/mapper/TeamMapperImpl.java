package com.company.attendance.mapper;

import com.company.attendance.dto.TeamDto;
import com.company.attendance.entity.Team;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-02T15:53:11+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class TeamMapperImpl implements TeamMapper {

    @Override
    public TeamDto toDto(Team team) {
        if ( team == null ) {
            return null;
        }

        TeamDto teamDto = new TeamDto();

        teamDto.setId( team.getId() );
        teamDto.setName( team.getName() );
        teamDto.setAddress( team.getAddress() );
        teamDto.setCity( team.getCity() );
        teamDto.setState( team.getState() );
        teamDto.setPincode( team.getPincode() );

        return teamDto;
    }

    @Override
    public Team toEntity(TeamDto dto) {
        if ( dto == null ) {
            return null;
        }

        Team.TeamBuilder team = Team.builder();

        team.id( dto.getId() );
        team.name( dto.getName() );
        team.address( dto.getAddress() );
        team.city( dto.getCity() );
        team.state( dto.getState() );
        team.pincode( dto.getPincode() );

        return team.build();
    }
}
