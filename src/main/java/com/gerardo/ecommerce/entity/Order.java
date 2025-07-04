package com.gerardo.ecommerce.entity;

import jakarta.persistence.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDateTime dataOrdine;

    @Enumerated(EnumType.STRING)
    private StatoOrdine statoOrdine;
    private double prezzoOrdine;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderitem;

    @OneToOne(mappedBy = "order")
    private Payment payment;
}
