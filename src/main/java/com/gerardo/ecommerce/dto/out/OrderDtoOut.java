package com.gerardo.ecommerce.dto.out;

import com.gerardo.ecommerce.entity.*;

import java.time.LocalDateTime;
import java.util.List;

public class OrderDtoOut {

    private LocalDateTime dataOrdine;
    private StatoOrdine statoOrdine;
    private double prezzoOrdine;
    private UserDtoOut user;
    private AddressDtoOut address;
    private List<OrderItemDtoOut> orderitem;
    private PaymentDtoOut payment;

    public LocalDateTime getDataOrdine() {
        return dataOrdine;
    }

    public void setDataOrdine(LocalDateTime dataOrdine) {
        this.dataOrdine = dataOrdine;
    }

    public StatoOrdine getStatoOrdine() {
        return statoOrdine;
    }

    public void setStatoOrdine(StatoOrdine statoOrdine) {
        this.statoOrdine = statoOrdine;
    }

    public double getPrezzoOrdine() {
        return prezzoOrdine;
    }

    public void setPrezzoOrdine(double prezzoOrdine) {
        this.prezzoOrdine = prezzoOrdine;
    }

    public UserDtoOut getUser() {
        return user;
    }

    public void setUser(UserDtoOut user) {
        this.user = user;
    }

    public AddressDtoOut getAddress() {
        return address;
    }

    public void setAddress(AddressDtoOut address) {
        this.address = address;
    }

    public List<OrderItemDtoOut> getOrderitem() {
        return orderitem;
    }

    public void setOrderitem(List<OrderItemDtoOut> orderitem) {
        this.orderitem = orderitem;
    }

    public PaymentDtoOut getPayment() {
        return payment;
    }

    public void setPayment(PaymentDtoOut payment) {
        this.payment = payment;
    }
}
