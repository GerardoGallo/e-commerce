package com.gerardo.ecommerce.controller;

import com.gerardo.ecommerce.dto.in.ProductDtoIn;
import com.gerardo.ecommerce.dto.in.ProductDtoInSpecification;
import com.gerardo.ecommerce.dto.out.ProductDtoOut;
import com.gerardo.ecommerce.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("find-all")
    public ResponseEntity<List<ProductDtoOut>> findAll(@RequestBody ProductDtoInSpecification specification){
        return ResponseEntity.ok(productService.findAll(specification));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDtoOut> getProductById(@PathVariable int id){
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @PostMapping("/admin/create-product")
    public ResponseEntity<ProductDtoOut> createProduct(@RequestBody @Valid ProductDtoIn productDtoIn){
        return ResponseEntity.ok(productService.createProduct(productDtoIn));
    }

    @PutMapping("/admin/update-product/{codeItem}")
    public ResponseEntity<ProductDtoOut> updateProduct(@RequestBody @Valid ProductDtoIn productDtoIn, @PathVariable int codeItem){
        return ResponseEntity.ok(productService.updateProduct(productDtoIn, codeItem));
    }

    @PutMapping("/admin/update-pezziDisponibili-product/{codeItem}")
    public ResponseEntity<ProductDtoOut> uodatePezziDisponibili(@PathVariable int codeItem){
        return ResponseEntity.ok(productService.uodatePezziDisponibili(codeItem));
    }

    @DeleteMapping("/admin/delete-product/{codeItem}")
    public ResponseEntity<ProductDtoOut> deleteProduct(@PathVariable int codeItem){
        return ResponseEntity.ok(productService.deleteProduct(codeItem));
    }


}
