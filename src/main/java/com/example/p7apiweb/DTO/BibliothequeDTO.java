package com.example.p7apiweb.DTO;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class BibliothequeDTO {
    Long id;
    List<BookDTO> bookDTOList;
    String adresse;
}
