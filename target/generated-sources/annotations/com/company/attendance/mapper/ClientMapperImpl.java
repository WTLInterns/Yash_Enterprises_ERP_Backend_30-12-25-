package com.company.attendance.mapper;

import com.company.attendance.dto.ClientDto;
import com.company.attendance.entity.Client;
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
public class ClientMapperImpl implements ClientMapper {

    @Override
    public ClientDto toDto(Client client) {
        if ( client == null ) {
            return null;
        }

        ClientDto clientDto = new ClientDto();

        clientDto.setName( client.getName() );
        clientDto.setEmail( client.getEmail() );
        clientDto.setId( client.getId() );
        clientDto.setContactPhone( client.getContactPhone() );
        clientDto.setAddress( client.getAddress() );
        clientDto.setNotes( client.getNotes() );
        clientDto.setIsActive( client.getIsActive() );
        clientDto.setCreatedAt( client.getCreatedAt() );
        clientDto.setUpdatedAt( client.getUpdatedAt() );

        return clientDto;
    }

    @Override
    public Client toEntity(ClientDto clientDto) {
        if ( clientDto == null ) {
            return null;
        }

        Client.ClientBuilder client = Client.builder();

        client.id( clientDto.getId() );
        client.name( clientDto.getName() );
        client.email( clientDto.getEmail() );
        client.contactPhone( clientDto.getContactPhone() );
        client.address( clientDto.getAddress() );
        client.notes( clientDto.getNotes() );
        client.isActive( clientDto.getIsActive() );
        client.createdAt( clientDto.getCreatedAt() );
        client.updatedAt( clientDto.getUpdatedAt() );

        return client.build();
    }

    @Override
    public void updateEntityFromDto(ClientDto clientDto, Client client) {
        if ( clientDto == null ) {
            return;
        }

        client.setId( clientDto.getId() );
        client.setName( clientDto.getName() );
        client.setEmail( clientDto.getEmail() );
        client.setContactPhone( clientDto.getContactPhone() );
        client.setAddress( clientDto.getAddress() );
        client.setNotes( clientDto.getNotes() );
        client.setIsActive( clientDto.getIsActive() );
        client.setCreatedAt( clientDto.getCreatedAt() );
        client.setUpdatedAt( clientDto.getUpdatedAt() );
    }

    @Override
    public List<ClientDto> toDtoList(List<Client> clients) {
        if ( clients == null ) {
            return null;
        }

        List<ClientDto> list = new ArrayList<ClientDto>( clients.size() );
        for ( Client client : clients ) {
            list.add( toDto( client ) );
        }

        return list;
    }

    @Override
    public List<Client> toEntityList(List<ClientDto> clientDtos) {
        if ( clientDtos == null ) {
            return null;
        }

        List<Client> list = new ArrayList<Client>( clientDtos.size() );
        for ( ClientDto clientDto : clientDtos ) {
            list.add( toEntity( clientDto ) );
        }

        return list;
    }
}
