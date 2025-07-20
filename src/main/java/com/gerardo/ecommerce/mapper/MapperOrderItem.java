package com.gerardo.ecommerce.mapper;

import com.gerardo.ecommerce.dto.out.OrderDtoOut;
import com.gerardo.ecommerce.dto.out.OrderItemDtoOut;
import com.gerardo.ecommerce.entity.OrderItem;

import java.util.List;
import java.util.stream.Collectors;

public class MapperOrderItem {

    public static OrderItemDtoOut entityToDtoOut(OrderItem entity) {
        OrderItemDtoOut dtoOut = new OrderItemDtoOut();
        //dtoOut.setOrder(MapperOrder.entityToDtoOut(entity.getOrder()));
        dtoOut.setProduct(MapperProduct.entityToDtoOut(entity.getProduct()));
        dtoOut.setQuantity(entity.getQuantity());
        dtoOut.setPrezzo(entity.getPrezzo());
        return dtoOut;
    }

    public static List<OrderItemDtoOut> listEntityToListDtoOut(List<OrderItem> listEntity){
      return listEntity.stream().map(MapperOrderItem::entityToDtoOut).collect(Collectors.toList());
    }
}
