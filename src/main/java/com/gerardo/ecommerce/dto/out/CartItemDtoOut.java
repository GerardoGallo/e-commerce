package com.gerardo.ecommerce.dto.out;

public class CartItemDtoOut {

    private ProductDtoOut product;
    private int quantity;

    public CartItemDtoOut() {
    }

    public CartItemDtoOut(ProductDtoOut product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public ProductDtoOut getProduct() {
        return product;
    }

    public void setProduct(ProductDtoOut product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
