package com.example.p7apiweb.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.DETACH})
    List<Genre> genre;

    @ManyToOne
    Bibliotheque provenance;

    String titre;
    Integer quantite;
    boolean disponible;
    String edition;
    String auteur;
    Integer anneeParution;
    String description;
    String urlimg;


}
