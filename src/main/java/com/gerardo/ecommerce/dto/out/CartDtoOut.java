package com.gerardo.ecommerce.dto.out;

import com.gerardo.ecommerce.entity.CartItem;

import java.util.List;

public class CartDtoOut {

    private List<CartItemDtoOut> cartItem;

    public CartDtoOut(){}

    public CartDtoOut(List<CartItemDtoOut> cartItem) {
        this.cartItem = cartItem;
    }

    public List<CartItemDtoOut> getCartItem() {
        return cartItem;
    }

    public void setCartItem(List<CartItemDtoOut> cartItem) {
        this.cartItem = cartItem;
    }
}
