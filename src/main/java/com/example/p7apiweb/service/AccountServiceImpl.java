package com.example.p7apiweb.service;

import com.example.p7apiweb.DAO.ClientRepository;
import com.example.p7apiweb.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    ClientRepository clientRepository;

    @Override
    public Client saveUser(String login,String password,String nom,String prenom,
                           String mail, String adresse) {
        Client user = clientRepository.findClientByLoginEquals(login);
        if(user != null ) throw new RuntimeException("User already exists");
        Client newClient= new Client();
        newClient.setLogin(login);
        newClient.setPassword(bCryptPasswordEncoder.encode(password));
        newClient.setNom(nom);
        newClient.setPrenom(prenom);
        newClient.setMail(mail);
        newClient.setAdresse(adresse);
        newClient.setRoles("INVITE");
        clientRepository.save(newClient);

        return newClient;
    }
}
