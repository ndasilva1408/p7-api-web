package com.example.p7apiweb.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Bibliotheque implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    Long id;
    @OneToMany(mappedBy = "provenance",fetch = FetchType.LAZY)
    List<Book> bookList;
    String adresse;
}
