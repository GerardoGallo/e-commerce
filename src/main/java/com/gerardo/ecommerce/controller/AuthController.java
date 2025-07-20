package com.gerardo.ecommerce.controller;

import com.gerardo.ecommerce.dto.in.LoginDtoIn;
import com.gerardo.ecommerce.dto.in.UserDtoIn;
import com.gerardo.ecommerce.dto.out.LoginDtoOut;
import com.gerardo.ecommerce.dto.out.UserDtoOut;
import com.gerardo.ecommerce.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;


    @PostMapping("/register")
    public ResponseEntity<UserDtoOut> register(@RequestBody UserDtoIn dtoIn) {
        return ResponseEntity.ok(authService.register(dtoIn));
    }

    @PostMapping("/login")
    ResponseEntity<LoginDtoOut> login(@RequestBody LoginDtoIn loginDtoIn) {
        return ResponseEntity.ok(authService.login(loginDtoIn));
    }
}
