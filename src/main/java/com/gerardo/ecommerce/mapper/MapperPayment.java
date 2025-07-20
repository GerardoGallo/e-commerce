package com.gerardo.ecommerce.mapper;

import com.gerardo.ecommerce.dto.out.PaymentDtoOut;
import com.gerardo.ecommerce.entity.Payment;

public class MapperPayment {

    public static PaymentDtoOut entityToDtoOut(Payment entity) {
        PaymentDtoOut dtoOut = new PaymentDtoOut();
        dtoOut.setMetodo(entity.getMetodo());
        dtoOut.setStatoPagamento(entity.getStatoPagamento());
        return dtoOut;
    }
}
