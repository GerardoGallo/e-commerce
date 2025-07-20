package com.gerardo.ecommerce.controller;

import com.gerardo.ecommerce.dto.in.PaymentDtoIn;
import com.gerardo.ecommerce.dto.out.PaymentDtoOut;
import com.gerardo.ecommerce.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/add-method-payment")
    public ResponseEntity<PaymentDtoOut> addMethodPayment(@RequestBody PaymentDtoIn dtoIn){
        return ResponseEntity.ok(paymentService.addMethodPayment(dtoIn));
    }

}
