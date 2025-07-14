package com.gerardo.ecommerce.utility;

import com.gerardo.ecommerce.entity.User;
import com.gerardo.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class UserUtility {

    @Autowired
    private UserRepository userRepository;

    //Il seguente metodo recupera la email dell utente che sta utilizzando l applicazione
    public String getEmailOfUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String email = "";
        if (principal instanceof UserDetails) {
            email = ((UserDetails) principal).getUsername();
        }
        return email;
    }

    //recupera l utente che sta usando l applicazione
    public User fetchAuthenticatedUser() {
        return userRepository.findByEmail(getEmailOfUser())
                .orElseThrow(() -> new RuntimeException("Utente non trovato"));
    }
}
