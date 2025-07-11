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


    public Payment() {
    }

    public Payment(int id, String metodo, StatoPagamento statoPagamento, LocalDateTime dataPagamento, Order order) {
        this.id = id;
        this.metodo = metodo;
        this.statoPagamento = statoPagamento;
        this.dataPagamento = dataPagamento;
        this.order = order;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public StatoPagamento getStatoPagamento() {
        return statoPagamento;
    }

    public void setStatoPagamento(StatoPagamento statoPagamento) {
        this.statoPagamento = statoPagamento;
    }

    public LocalDateTime getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDateTime dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
