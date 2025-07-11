package com.gerardo.ecommerce.controller;

import com.gerardo.ecommerce.dto.in.ProductDtoIn;
import com.gerardo.ecommerce.dto.out.ProductDtoOut;
import com.gerardo.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/admin/create-product")
    public ResponseEntity<ProductDtoOut> createProduct(@RequestBody ProductDtoIn productDtoIn){
        return ResponseEntity.ok(productService.createProduct(productDtoIn));
    }

    @PutMapping("/admin/update-product/{codeItem}")
    public ResponseEntity<ProductDtoOut> updateProduct(@RequestBody ProductDtoIn productDtoIn, @PathVariable int codeItem){
        return ResponseEntity.ok(productService.updateProduct(productDtoIn, codeItem));
    }


    @DeleteMapping("/admin/delete-product/{codeItem}")
    public ResponseEntity<ProductDtoOut> deleteProduct(@PathVariable int codeItem){
        return ResponseEntity.ok(productService.deleteProduct(codeItem));
    }


}
