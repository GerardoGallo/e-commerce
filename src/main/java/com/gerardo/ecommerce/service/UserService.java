package com.gerardo.ecommerce.service;

import com.gerardo.ecommerce.dto.in.UserDtoIn;
import com.gerardo.ecommerce.dto.out.UserDtoOut;
import com.gerardo.ecommerce.entity.User;
import com.gerardo.ecommerce.mapper.MapperUser;
import com.gerardo.ecommerce.repository.CartRepository;
import com.gerardo.ecommerce.repository.UserRepository;
import com.gerardo.ecommerce.utility.UserUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserUtility userUtility;

    public UserDtoOut findByEmail(String email) {
        User user = checkCurrentUser(email);
        return MapperUser.entityToDtoOut(user);
    }

    private User checkCurrentUser(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException(String.format("User con email %s non trovato", email)));

        User authenticatedUser = userUtility.fetchAuthenticatedUser();

        if (user != authenticatedUser){
            throw new RuntimeException("Questo non è il tuo profilo");
        }
        return user;
    }

    public UserDtoOut modifyDataUser(UserDtoIn dtoIn, String email) {
        User user = checkCurrentUser(email);
        //decidere quali campi puo aggiornare l utente

        return MapperUser.entityToDtoOut(user);
    }
}
