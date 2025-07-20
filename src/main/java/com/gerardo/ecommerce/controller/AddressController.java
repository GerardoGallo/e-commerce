package com.gerardo.ecommerce.controller;

import com.gerardo.ecommerce.dto.in.AddressDtoIn;
import com.gerardo.ecommerce.dto.out.AddressDtoOut;
import com.gerardo.ecommerce.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping("/add-address-to-user")
    public ResponseEntity<AddressDtoOut> addAddressToUser(@RequestBody AddressDtoIn dtoIn){
        return ResponseEntity.ok(addressService.addAddressToUser(dtoIn));
    }
}
