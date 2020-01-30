package com.example.p7apiweb.mapper;

import com.example.p7apiweb.DTO.BookDTO;
import com.example.p7apiweb.entities.Book;
import org.mapstruct.Mapper;

@Mapper
public interface BookMapper {

    BookDTO toBook(Book entity);
    Book toDTO(BookDTO dto);
}
