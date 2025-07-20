package com.gerardo.ecommerce.mapper;

import com.gerardo.ecommerce.dto.out.OrderDtoOut;
import com.gerardo.ecommerce.entity.Order;

import java.util.List;
import java.util.stream.Collectors;

public class MapperOrder {

    public static OrderDtoOut entityToDtoOut(Order entity) {
        OrderDtoOut dtoOut = new OrderDtoOut();
        dtoOut.setUser(MapperUser.entityToDtoOut(entity.getUser()));
        dtoOut.setAddress(MapperAddress.entityToDtoOut(entity.getAddress()));
        dtoOut.setOrderitem(MapperOrderItem.listEntityToListDtoOut(entity.getOrderitem()));
        dtoOut.setDataOrdine(entity.getDataOrdine());
        dtoOut.setStatoOrdine(entity.getStatoOrdine());
        dtoOut.setPrezzoOrdine(entity.getPrezzoOrdine());
        dtoOut.setPayment(MapperPayment.entityToDtoOut(entity.getPayment()));
        return dtoOut;
    }

    public static List<OrderDtoOut> listEntityToListDtoOut(List<Order> listEntity) {
        return listEntity.stream().map(MapperOrder::entityToDtoOut).collect(Collectors.toList());
    }
}
