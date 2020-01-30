package com.example.p7apiweb;

import com.example.p7apiweb.DAO.BibliothequeRepository;
import com.example.p7apiweb.DAO.BilletRepository;
import com.example.p7apiweb.DAO.BookRepository;
import com.example.p7apiweb.DAO.ClientRepository;
import com.example.p7apiweb.entities.Bibliotheque;
import com.example.p7apiweb.entities.Book;
import com.example.p7apiweb.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.*;

@SpringBootApplication
public class P7ApiWebApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(P7ApiWebApplication.class, args);
        BookRepository bookRepository = ctx.getBean(BookRepository.class);
        BibliothequeRepository bibliothequeRepository =ctx.getBean(BibliothequeRepository.class);



       /* Book b = new Book();

       b=bookRepository.findBookById(Long.parseLong("1"));
       b.setProvenance(bibliothequeRepository.findBibliothequeById(Long.parseLong("1")));
        bookRepository.save (b);
        b=bookRepository.findBookById(Long.parseLong("2"));
        b.setProvenance(bibliothequeRepository.findBibliothequeById(Long.parseLong("2")));
        bookRepository.save (b);
        b=bookRepository.findBookById(Long.parseLong("3"));
        b.setProvenance(bibliothequeRepository.findBibliothequeById(Long.parseLong("2")));
        bookRepository.save (b);
        b=bookRepository.findBookById(Long.parseLong("4"));
        b.setProvenance(bibliothequeRepository.findBibliothequeById(Long.parseLong("2")));
        bookRepository.save (b);
        b=bookRepository.findBookById(Long.parseLong("5"));
        b.setProvenance(bibliothequeRepository.findBibliothequeById(Long.parseLong("4")));
        bookRepository.save (b);
        b=bookRepository.findBookById(Long.parseLong("6"));
        b.setProvenance(bibliothequeRepository.findBibliothequeById(Long.parseLong("4")));
        bookRepository.save (b);
        b=bookRepository.findBookById(Long.parseLong("7"));
        b.setProvenance(bibliothequeRepository.findBibliothequeById(Long.parseLong("2")));
        bookRepository.save (b);
        b=bookRepository.findBookById(Long.parseLong("8"));
        b.setProvenance(bibliothequeRepository.findBibliothequeById(Long.parseLong("1")));
        bookRepository.save (b);
        b=bookRepository.findBookById(Long.parseLong("9"));
        b.setProvenance(bibliothequeRepository.findBibliothequeById(Long.parseLong("3")));
        bookRepository.save (b);
        b=bookRepository.findBookById(Long.parseLong("10"));
        b.setProvenance(bibliothequeRepository.findBibliothequeById(Long.parseLong("1")));
        bookRepository.save (b);
        b=bookRepository.findBookById(Long.parseLong("11"));
        b.setProvenance(bibliothequeRepository.findBibliothequeById(Long.parseLong("1")));
        bookRepository.save (b);
        b=bookRepository.findBookById(Long.parseLong("12"));
        b.setProvenance(bibliothequeRepository.findBibliothequeById(Long.parseLong("1")));
        bookRepository.save (b);
        b=bookRepository.findBookById(Long.parseLong("13"));
        b.setProvenance(bibliothequeRepository.findBibliothequeById(Long.parseLong("4")));
        bookRepository.save (b);
        b=bookRepository.findBookById(Long.parseLong("14"));
        b.setProvenance(bibliothequeRepository.findBibliothequeById(Long.parseLong("2")));
        bookRepository.save (b);


        b=bookRepository.findBookById(Long.parseLong("15"));
        b.setProvenance(bibliothequeRepository.findBibliothequeById(Long.parseLong("1")));
        bookRepository.save (b);
        b=bookRepository.findBookById(Long.parseLong("16"));
        b.setProvenance(bibliothequeRepository.findBibliothequeById(Long.parseLong("3")));
        bookRepository.save (b);
        b=bookRepository.findBookById(Long.parseLong("17"));
        b.setProvenance(bibliothequeRepository.findBibliothequeById(Long.parseLong("3")));
        bookRepository.save (b);
        b=bookRepository.findBookById(Long.parseLong("18"));
        b.setProvenance(bibliothequeRepository.findBibliothequeById(Long.parseLong("1")));
        bookRepository.save (b);
        b=bookRepository.findBookById(Long.parseLong("19"));
        b.setProvenance(bibliothequeRepository.findBibliothequeById(Long.parseLong("1")));
        bookRepository.save (b);
        b=bookRepository.findBookById(Long.parseLong("20"));
        b.setProvenance(bibliothequeRepository.findBibliothequeById(Long.parseLong("1")));
        bookRepository.save (b);
        b=bookRepository.findBookById(Long.parseLong("21"));
        b.setProvenance(bibliothequeRepository.findBibliothequeById(Long.parseLong("1")));
        bookRepository.save (b);
        b=bookRepository.findBookById(Long.parseLong("22"));
        b.setProvenance(bibliothequeRepository.findBibliothequeById(Long.parseLong("2")));
        bookRepository.save (b);
        b=bookRepository.findBookById(Long.parseLong("23"));
        b.setProvenance(bibliothequeRepository.findBibliothequeById(Long.parseLong("1")));
        bookRepository.save (b);
        b=bookRepository.findBookById(Long.parseLong("24"));
        b.setProvenance(bibliothequeRepository.findBibliothequeById(Long.parseLong("3")));
        bookRepository.save (b);
        b=bookRepository.findBookById(Long.parseLong("25"));
        b.setProvenance(bibliothequeRepository.findBibliothequeById(Long.parseLong("3")));
        bookRepository.save (b);
        b=bookRepository.findBookById(Long.parseLong("26"));
        b.setProvenance(bibliothequeRepository.findBibliothequeById(Long.parseLong("4")));
        bookRepository.save (b);
        b=bookRepository.findBookById(Long.parseLong("27"));
        b.setProvenance(bibliothequeRepository.findBibliothequeById(Long.parseLong("4")));
        bookRepository.save (b);
        b=bookRepository.findBookById(Long.parseLong("28"));
        b.setProvenance(bibliothequeRepository.findBibliothequeById(Long.parseLong("3")));
        bookRepository.save (b);*/






        ;


    }
}


