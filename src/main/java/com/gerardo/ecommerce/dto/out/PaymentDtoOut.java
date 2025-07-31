package com.gerardo.ecommerce.dto.out;

import com.gerardo.ecommerce.enums.StatoPagamento;

public class PaymentDtoOut {

    private String metodo;//inteso come metodo di pagamento ,es. tipo di carta ecc
    private StatoPagamento statoPagamento;

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

}
