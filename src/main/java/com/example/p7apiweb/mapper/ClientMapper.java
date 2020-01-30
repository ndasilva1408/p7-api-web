package com.example.p7apiweb.mapper;

import com.example.p7apiweb.DTO.ClientDTO;
import com.example.p7apiweb.entities.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ClientMapper {

    ClientDTO toClient(Client entity);
    Client toDTO(ClientDTO dto);
}
