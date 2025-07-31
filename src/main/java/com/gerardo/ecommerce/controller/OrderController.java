package com.gerardo.ecommerce.controller;

import com.gerardo.ecommerce.dto.in.PaymentDtoIn;
import com.gerardo.ecommerce.dto.out.OrderDtoOut;
import com.gerardo.ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/get-user-orders")
    public ResponseEntity<List<OrderDtoOut>> getUserOrders(){
        return ResponseEntity.ok(orderService.getUserOrders());
    }

    @GetMapping("/get-user-orders-by-id/{id}")
    public ResponseEntity<OrderDtoOut> getUserOrdersByIdOrder(@PathVariable int id){
        return ResponseEntity.ok(orderService.getUserOrdersByIdOrder(id));
    }

    @PostMapping("/create-order-by-cart")
    public ResponseEntity<OrderDtoOut> createOrderByCart(@RequestBody PaymentDtoIn tipoPagamento){
        return ResponseEntity.ok(orderService.makeOrderByCart(tipoPagamento));
    }

}
