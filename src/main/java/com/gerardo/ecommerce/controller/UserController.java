package com.gerardo.ecommerce.controller;

import com.gerardo.ecommerce.dto.in.UserDtoIn;
import com.gerardo.ecommerce.dto.out.UserDtoOut;
import com.gerardo.ecommerce.repository.UserRepository;
import com.gerardo.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/find-by-email/{email}")
    private ResponseEntity<?> findByEmail(@PathVariable String email){
        return ResponseEntity.ok(userService.findByEmail(email));
    }

    @PostMapping("/register")
    public ResponseEntity<UserDtoOut> register(@RequestBody UserDtoIn dtoIn){
        return ResponseEntity.ok(userService.register(dtoIn));
    }

    @GetMapping("/admin/a")
    public String a(){
        return "entrato";
    }
}
