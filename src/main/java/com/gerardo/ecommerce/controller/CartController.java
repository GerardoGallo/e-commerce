package com.gerardo.ecommerce.controller;

import com.gerardo.ecommerce.dto.in.CartItemDtoIn;
import com.gerardo.ecommerce.dto.out.CartDtoOut;
import com.gerardo.ecommerce.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/add-item-to-cart")
    public ResponseEntity<CartDtoOut> additemToCart(@RequestBody CartItemDtoIn cartItemDtoIn){
        return ResponseEntity.ok(cartService.additemToCart(cartItemDtoIn));
    }

    @PutMapping("/update-quantity/{codeItem}")
    public ResponseEntity<CartDtoOut> updateQuantity(@PathVariable int codeItem){
        return ResponseEntity.ok(cartService.updateQuantityOfAProduct(codeItem));
    }

    @GetMapping("find-cart-of-an-user")
    public ResponseEntity<CartDtoOut> findCartOfUser(){
        return ResponseEntity.ok(cartService.findCartOfAnUser());
    }

    @DeleteMapping("delete-item-to-cart/{codeItem}")
    public ResponseEntity<CartDtoOut> deleteItemToCart(@PathVariable int codeItem){
        return ResponseEntity.ok(cartService.deleteItemToCart(codeItem));
    }


}
