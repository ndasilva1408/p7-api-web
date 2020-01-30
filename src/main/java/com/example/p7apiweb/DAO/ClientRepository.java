package com.example.p7apiweb.DAO;

import com.example.p7apiweb.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin

public interface ClientRepository extends JpaRepository<Client,Long> {
    @RestResource
    Client findClientByLoginEqualsAndPasswordEquals(String login,String Password);

    Client findClientByLoginEquals(@Param("username")  String login);

}
