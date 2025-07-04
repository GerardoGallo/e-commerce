package com.gerardo.ecommerce.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String metodo;//inteso come metodo di pagamento ,es. tipo di carta ecc

    @Enumerated(EnumType.STRING)
    private StatoPagamento statoPagamento;

    private LocalDateTime dataPagamento;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;

}
