package com.example.p7apiweb.mapper;

import com.example.p7apiweb.DTO.BilletDTO;
import com.example.p7apiweb.entities.Billet;
import org.mapstruct.Mapper;

@Mapper
public interface BilletMapper {
    BilletDTO toBillet(Billet entity);
    Billet toDTO(BilletDTO dto);
}

