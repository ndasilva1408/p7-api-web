package com.example.p7apiweb.DAO;

import com.example.p7apiweb.entities.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.List;

@RepositoryRestResource
@CrossOrigin("*")
public interface BookRepository extends JpaRepository<Book, Long> {

    Book findBookById(Long id);

    @RestResource(path="/byProv")
    List<Book> findBooksByProvenance(Long bibliothequeId);

    @RestResource(path = "/byAuteur")
    List<Book> findByAuteurContains(@Param("mc") String auteur);

    @RestResource(path = "/byAuteurPage")
    Page<Book> findByAuteurContains(@Param("mc") String auteur, Pageable pageable);


    @RestResource(path = "/byTitrePage")
    Page<Book> findByTitreContains(@Param("mc") String titre, Pageable pageable);

    @RestResource(path = "/byEditionPage")
    Page<Book> findByEditionContains(@Param("mc") String edition, Pageable pageable);

    //Marche
    @RestResource(path = "/find")
    @Query( "SELECT c FROM Book c   WHERE (c.edition LIKE %?1%  OR c.titre LIKE %?1% OR c.auteur LIKE %?1%)")
    Page<Book> customFind( String mc,Pageable pageable);

    //Marche mais gere pas les ortographes proches
    @RestResource(path ="/find2")
    Page<Book> findByEditionContainsIgnoreCaseOrTitreContainsIgnoreCaseOrAuteurContainsIgnoreCase(@Param ("mc")String edition,
                                                                    @Param ("mc") String titre,
                                                                    @Param ("mc") String auteur,
                                                                    Pageable pageable);

}
