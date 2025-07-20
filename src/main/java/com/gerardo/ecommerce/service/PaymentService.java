package com.gerardo.ecommerce.service;

import com.gerardo.ecommerce.dto.in.PaymentDtoIn;
import com.gerardo.ecommerce.dto.out.PaymentDtoOut;
import com.gerardo.ecommerce.entity.Payment;
import com.gerardo.ecommerce.entity.StatoPagamento;
import com.gerardo.ecommerce.mapper.MapperPayment;
import com.gerardo.ecommerce.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public PaymentDtoOut addMethodPayment(PaymentDtoIn dtoIn) {
        Payment newPayment = new Payment();
        newPayment.setMetodo(dtoIn.getMetodo());
        newPayment.setStatoPagamento(StatoPagamento.valueOf(dtoIn.getStatoPagamento()));
        Payment save = paymentRepository.save(newPayment);
        return MapperPayment.entityToDtoOut(save);
    }
}
