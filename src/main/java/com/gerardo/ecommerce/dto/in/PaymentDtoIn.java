package com.gerardo.ecommerce.dto.in;

public class PaymentDtoIn {

    private String metodo;//inteso come metodo di pagamento ,es. tipo di carta ecc
    private String statoPagamento;

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public String getStatoPagamento() {
        return statoPagamento;
    }

    public void setStatoPagamento(String statoPagamento) {
        this.statoPagamento = statoPagamento;
    }
}
