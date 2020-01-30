package com.example.p7apiweb.mapper;

import com.example.p7apiweb.DTO.BibliothequeDTO;
import com.example.p7apiweb.entities.Bibliotheque;
import org.mapstruct.Mapper;

@Mapper
public interface BibliothequeMapper {
    BibliothequeDTO toBibliotheque(Bibliotheque entity);
    Bibliotheque toDTO(BibliothequeDTO dto);
}
