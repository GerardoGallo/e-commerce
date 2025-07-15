package com.gerardo.ecommerce.service;

import com.gerardo.ecommerce.dto.in.UserDtoIn;
import com.gerardo.ecommerce.dto.out.UserDtoOut;
import com.gerardo.ecommerce.entity.Cart;
import com.gerardo.ecommerce.entity.Role;
import com.gerardo.ecommerce.entity.User;
import com.gerardo.ecommerce.mapper.MapperUser;
import com.gerardo.ecommerce.repository.CartRepository;
import com.gerardo.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CartRepository cartRepository;

    public UserDtoOut findByEmail(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException(String.format("User con email %s non trovato", email)));
        return MapperUser.entityToDtoOut(user);
    }

    public UserDtoOut register(UserDtoIn dtoIn) {
        Optional<User> byEmail = userRepository.findByEmail(dtoIn.getEmail());
        if (byEmail.isPresent()){
            throw new RuntimeException(String.format("Utente con email %s già esistente",dtoIn.getEmail()));
        }
        User newUser = new User();
        newUser.setNome(dtoIn.getNome());
        newUser.setCognome(dtoIn.getCognome());
        newUser.getRoles().add(Role.CUSTOMER);
        newUser.setEmail(dtoIn.getEmail());
        newUser.setPwd(passwordEncoder.encode(dtoIn.getPwd()));
        userRepository.save(newUser);
        return MapperUser.entityToDtoOut(newUser);

    }
}
