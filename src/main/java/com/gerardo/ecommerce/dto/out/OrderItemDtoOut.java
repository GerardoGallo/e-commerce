package com.gerardo.ecommerce.dto.out;

public class OrderItemDtoOut {

    private int quantity;
    private double prezzo;
    private OrderDtoOut order;
    private ProductDtoOut product;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public OrderDtoOut getOrder() {
        return order;
    }

    public void setOrder(OrderDtoOut order) {
        this.order = order;
    }

    public ProductDtoOut getProduct() {
        return product;
    }

    public void setProduct(ProductDtoOut product) {
        this.product = product;
    }
}
