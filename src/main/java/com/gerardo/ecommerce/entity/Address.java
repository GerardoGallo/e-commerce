package com.gerardo.ecommerce.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String indirizzo;
    private int nCivico;
    private String nazionalita;
    private String comune;
    private String provincia;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

}
