package com.example.p7apiweb.mapper;

import com.example.p7apiweb.DTO.GenreDTO;
import com.example.p7apiweb.entities.Genre;
import org.mapstruct.Mapper;

@Mapper
public interface GenreMapper {
    GenreDTO toGenre(Genre entity);
    Genre toDTO(GenreDTO dto);
}
