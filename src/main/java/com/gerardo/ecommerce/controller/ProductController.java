package com.gerardo.ecommerce.controller;

import com.gerardo.ecommerce.dto.in.ProductDtoIn;
import com.gerardo.ecommerce.dto.out.ProductDtoOut;
import com.gerardo.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    public ResponseEntity<ProductDtoOut> createProduct(ProductDtoIn productDtoIn){
        return ResponseEntity.ok(productService.createProduct(productDtoIn));
    }
}
