package com.example.p7apiweb.service;

import com.example.p7apiweb.entities.Client;

public interface AccountService {
    public Client saveUser(String login,String password,String nom,String prenom,
                           String mail, String adresse);
}
