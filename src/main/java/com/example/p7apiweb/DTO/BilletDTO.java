package com.example.p7apiweb.DTO;


import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class BilletDTO {
    Long id;
    ClientDTO client;
    BookDTO book;
    String date;
}
