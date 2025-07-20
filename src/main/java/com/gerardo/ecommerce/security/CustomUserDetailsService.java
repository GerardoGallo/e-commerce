package com.gerardo.ecommerce.security;

import com.gerardo.ecommerce.entity.User;
import com.gerardo.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User myUser = userRepository.findByEmail(username)
                .orElseThrow(() -> new RuntimeException(String.format("User con email %s non trovato", username)));
       /* List<GrantedAuthority> authorities = new ArrayList<>();
        for (Role s: myUser.getRoles()){
            authorities.add(new SimpleGrantedAuthority("ROLE_"+s.name()));
        }*/
        return new CustomUserDetails(myUser);
    }
}
