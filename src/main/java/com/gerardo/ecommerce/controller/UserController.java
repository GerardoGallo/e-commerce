package com.gerardo.ecommerce.controller;

import com.gerardo.ecommerce.dto.in.UserDtoIn;
import com.gerardo.ecommerce.dto.out.UserDtoOut;
import com.gerardo.ecommerce.repository.UserRepository;
import com.gerardo.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/find-by-email/{email}")
    private ResponseEntity<UserDtoOut> findByEmail(@PathVariable String email){
        return ResponseEntity.ok(userService.findByEmail(email));
    }

    @PutMapping("/modify-data-user/{email}")
    private ResponseEntity<UserDtoOut> modifyDataUser(@RequestBody UserDtoIn dtoIn, @PathVariable String email){
        return ResponseEntity.ok(userService.modifyDataUser(dtoIn, email));
    }


    @GetMapping("/a")
    public String a(){
        return passwordEncoder.encode("password123");
    }
}
