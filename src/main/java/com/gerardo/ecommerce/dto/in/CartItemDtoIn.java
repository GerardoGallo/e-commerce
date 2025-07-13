package com.gerardo.ecommerce.dto.in;

import com.gerardo.ecommerce.entity.Product;

public class CartItemDtoIn {

    private ProductDtoIn product;

    public CartItemDtoIn() {
    }

    public CartItemDtoIn(ProductDtoIn product) {
        this.product = product;
    }

    public ProductDtoIn getProduct() {
        return product;
    }

    public void setProduct(ProductDtoIn product) {
        this.product = product;
    }
}
