package com.gerardo.ecommerce.controller;

import com.gerardo.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("find-by-email/{email}")
    private ResponseEntity<?> findByEmail(@PathVariable String email){
        return ResponseEntity.ok(userRepository.findByEmail(email));
    }
}
