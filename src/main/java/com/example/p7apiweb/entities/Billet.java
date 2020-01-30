package com.example.p7apiweb.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Billet implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    Client client;
    @OneToOne
    Book book;
    String date;
}
