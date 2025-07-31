package com.gerardo.ecommerce.service;

import com.gerardo.ecommerce.dto.in.LoginDtoIn;
import com.gerardo.ecommerce.dto.in.UserDtoIn;
import com.gerardo.ecommerce.dto.out.LoginDtoOut;
import com.gerardo.ecommerce.dto.out.UserDtoOut;
import com.gerardo.ecommerce.enums.Role;
import com.gerardo.ecommerce.entity.User;
import com.gerardo.ecommerce.mapper.MapperUser;
import com.gerardo.ecommerce.repository.UserRepository;
import com.gerardo.ecommerce.security.CustomUserDetails;
import com.gerardo.ecommerce.security.jwt.JwtService;
import com.gerardo.ecommerce.utility.UserUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AuthService {


    private static final Logger log = LoggerFactory.getLogger(AuthService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserUtility userUtility;

    @Autowired
    private JwtService jwtService;

    // in seguito l obiettivo è quello di far in modo che l utente che si vuole registrare
    // debba prima cliccare un link per confermare la mail
    public UserDtoOut register(UserDtoIn dtoIn) {
        Optional<User> byEmail = userRepository.findByEmail(dtoIn.getEmail());
        if (byEmail.isPresent()) {
            throw new RuntimeException(String.format("Utente con email %s già esistente", dtoIn.getEmail()));
        }
        User newUser = new User();
        newUser.setNome(dtoIn.getNome());
        newUser.setCognome(dtoIn.getCognome());
        newUser.setEta(dtoIn.getEta());
        newUser.setDataIscrizione(LocalDateTime.now());
        newUser.getRoles().add(Role.CUSTOMER);
        newUser.setEmail(dtoIn.getEmail());
        newUser.setPwd(passwordEncoder.encode(dtoIn.getPwd()));
        userRepository.save(newUser);
        return MapperUser.entityToDtoOut(newUser);

    }

    public LoginDtoOut login(LoginDtoIn loginDtoIn) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginDtoIn.getEmail(), loginDtoIn.getPwd());
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        log.info("before set {}", SecurityContextHolder.getContext().getAuthentication());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        User user = userUtility.fetchAuthenticatedUser();
        String jwtToken = jwtService.generateToken(new CustomUserDetails(user));
        log.info("after set {}", SecurityContextHolder.getContext().getAuthentication());
        return new LoginDtoOut(jwtToken);
    }
}
