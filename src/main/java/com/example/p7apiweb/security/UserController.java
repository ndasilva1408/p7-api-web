package com.example.p7apiweb.security;

import com.example.p7apiweb.DAO.ClientRepository;
import com.example.p7apiweb.entities.Client;
import com.example.p7apiweb.service.AccountService;
import com.example.p7apiweb.viewmodel.ClientModel;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Base64;

@RestController
@CrossOrigin

public class UserController {

    @Autowired
    ClientRepository clientRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    AccountService accountService;


    @RequestMapping("/login")

  /*  public boolean login(@RequestBody Client client
    ) {
        System.out.println(client.getLogin() + client.getPassword());


        Client client2 = clientRepository.findClientByLoginEqualsAndPasswordEquals(client.getLogin(), client.getPassword());


        if (client2 == null)
            return false;
        else

            return
                    client.getLogin().equals(client2.getLogin()) && client.getPassword().equals(client2.getPassword());
    }*/
  // username +Password recup depuis form , sous classe ClientModel , need to etre recup en token
  public boolean login(@RequestBody ClientModel clientModel) {
        System.out.println(clientModel.getUsername()+clientModel.getPassword());




  Client client = clientRepository.findClientByLoginEqualsAndPasswordEquals(clientModel.getUsername(),clientModel.getPassword());

  if (client == null)
      return false;
  else

     return
             clientModel.getUsername().equals(client.getLogin()) && clientModel.getPassword().equals(client.getPassword());
    }

    @PostMapping("/register")
    public Client register(@RequestBody ClientForm clientForm){
        return accountService.saveUser(clientForm.getLogin(),clientForm.getPassword(),
                clientForm.getMail(),clientForm.getPrenom(),clientForm.getNom(),clientForm.getAdresse());
}


    }




// Permet de renvoyer les données sous form de Json
class ClientForm {

    private String login;
    private String password;


    private String mail;
    private String nom;
    private String prenom;
    private String adresse;

    //GETTER AND SETTER


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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
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

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}

