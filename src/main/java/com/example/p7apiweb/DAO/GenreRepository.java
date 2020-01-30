package com.example.p7apiweb.DAO;

import com.example.p7apiweb.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin("*")
public interface GenreRepository extends JpaRepository<Genre,Long> {
}
