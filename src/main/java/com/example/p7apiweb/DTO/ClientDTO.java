package com.example.p7apiweb.DTO;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class ClientDTO {
    Long id;
    List<BilletDTO> billetReservation;
    String nom;
    String prenom;
    String mail;
    String adresse;
    String username;
    String password;
    String roles;

}
