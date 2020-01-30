package com.example.p7apiweb.entities;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @OneToMany(mappedBy = "client",fetch = FetchType.LAZY)
    List<Billet> billetReservation;
    String nom;
    String prenom;
    String mail;
    String adresse;
    String login;
    // Juste lu, jamais enregistre dans le header
    @JsonProperty(access=JsonProperty.Access.WRITE_ONLY)
    String password;
    String roles;


    //Constructor

    public Client() {
    }
    public Client(Long id,String nom,String prenom,
            String mail,
            String adresse,
            String login,
            String password,
            List<Billet> billetReservation,
            String roles
        ) {
    }

    //GETTER & SETTER


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Billet> getBilletReservation() {
        return billetReservation;
    }

    public void setBilletReservation(List<Billet> billetReservation) {
        this.billetReservation = billetReservation;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
}
