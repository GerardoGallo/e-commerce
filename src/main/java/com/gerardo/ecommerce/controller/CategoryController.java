package com.gerardo.ecommerce.controller;

import com.gerardo.ecommerce.dto.in.CategoryDtoIn;
import com.gerardo.ecommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/admin/add-category")
    public ResponseEntity<?> addCategory(@RequestBody CategoryDtoIn dtoIn){
        return ResponseEntity.ok(categoryService.addCategory(dtoIn));
    }

    @PutMapping("/admin/update-category")
    public ResponseEntity<?> updateCategory(@RequestBody CategoryDtoIn categoryDtoIn, @RequestParam String name){
        return ResponseEntity.ok(categoryService.updateCategory(categoryDtoIn, name));
    }

    @DeleteMapping("/admin/delete-category")
    public ResponseEntity<?> deleteCategory(@RequestParam String name){
        return ResponseEntity.ok(categoryService.deleteCategory(name));
    }
}
