package com.gerardo.ecommerce.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String cognome;
    private int eta;

    @Column(unique = true)
    private String email;
    private String pwd;
    @Enumerated(EnumType.STRING)
    private Role ruolo;

    @OneToOne(mappedBy = "user")
    private Cart cart;

    @OneToOne(mappedBy = "user")
    private Address address;

    @OneToMany(mappedBy = "user")
    private List<Order> order;

    @OneToMany(mappedBy = "user")
    private List<Review> review;
}
