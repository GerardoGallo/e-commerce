package com.gerardo.ecommerce.mapper;

import com.gerardo.ecommerce.dto.out.CartItemDtoOut;
import com.gerardo.ecommerce.entity.Cart;
import com.gerardo.ecommerce.entity.CartItem;

import java.util.List;
import java.util.stream.Collectors;

public class MapperCartItem {

    public static CartItem dtoOutToEntity(CartItemDtoOut dtoOut) {
        CartItem entity = new CartItem();
        entity.setQuantity(dtoOut.getQuantity());
        entity.setProduct(MapperProduct.dtoOutToEntity(dtoOut.getProduct()));
        return entity;
    }

    public static List<CartItem> listDtoOutToListEntity(List<CartItemDtoOut> listDtoOut) {
        return listDtoOut.stream().map(MapperCartItem::dtoOutToEntity).collect(Collectors.toList());
    }

    public static CartItemDtoOut entityToDtoOut(CartItem entity) {
        CartItemDtoOut dtoOut = new CartItemDtoOut();
        dtoOut.setQuantity(entity.getQuantity());
        dtoOut.setProduct(MapperProduct.entityToDtoOut(entity.getProduct()));
        return dtoOut;
    }

    public static List<CartItemDtoOut> listEntityToListDtoOut(List<CartItem> listEntity) {
        return listEntity.stream().map(MapperCartItem::entityToDtoOut).collect(Collectors.toList());
    }
}
