package com.gerardo.ecommerce.mapper;

import com.gerardo.ecommerce.dto.out.CartDtoOut;
import com.gerardo.ecommerce.dto.out.CartItemDtoOut;
import com.gerardo.ecommerce.entity.Cart;

public class MapperCart {

    public static Cart dtoOutToEntity(CartDtoOut dtoOut) {
        Cart entity = new Cart();
        entity.setCartItem(MapperCartItem.listDtoOutToListEntity(dtoOut.getCartItem()));
        return entity;
    }

    public static CartDtoOut entityToDtoOut(Cart entity) {
        if (entity==null){
            return new CartDtoOut();
        }
        CartDtoOut dtoOut = new CartDtoOut();
        dtoOut.setCartItem(MapperCartItem.listEntityToListDtoOut(entity.getCartItem()));
        return dtoOut;
    }

}
