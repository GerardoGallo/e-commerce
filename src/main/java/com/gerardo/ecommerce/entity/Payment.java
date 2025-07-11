package com.gerardo.ecommerce.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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
