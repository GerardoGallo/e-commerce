package com.gerardo.ecommerce.entity;

import jakarta.persistence.*;

@Entity
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
