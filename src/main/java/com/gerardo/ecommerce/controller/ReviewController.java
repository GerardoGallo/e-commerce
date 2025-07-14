package com.gerardo.ecommerce.controller;

import com.gerardo.ecommerce.dto.in.ReviewDtoIn;
import com.gerardo.ecommerce.dto.out.ReviewDtoOut;
import com.gerardo.ecommerce.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("find-by-id/{id}")
    public ResponseEntity<List<ReviewDtoOut>> findByIdProduct(@PathVariable(name = "id") int idProduct){
        return ResponseEntity.ok(reviewService.findByIdProduct(idProduct));
    }

    @PostMapping("/add-review")
    public ResponseEntity<ReviewDtoOut> addReview(@RequestBody ReviewDtoIn dtoIn){
        return ResponseEntity.ok(reviewService.addReview(dtoIn));
    }

    @PutMapping("/modify-review/{reviewId}")
    public ResponseEntity<ReviewDtoOut> modifyReview(@RequestBody ReviewDtoIn dtoIn, @PathVariable int reviewId){
        return ResponseEntity.ok(reviewService.modifyReview(dtoIn,reviewId));
    }

    @DeleteMapping("/delete-review/{reviewId}")
    public ResponseEntity<ReviewDtoOut> deleteReview(@PathVariable int reviewId){
        return ResponseEntity.ok(reviewService.deleteReview(reviewId));
    }
}
