package com.example.p7apiweb.DTO;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class BookDTO {
    Long id;
    List<GenreDTO> genre;
    String titre;
    Integer quantite;
    boolean disponible;
    String edition;
    String auteur;
    Integer anneeParution;
    String description;
    String urlimg;
}
