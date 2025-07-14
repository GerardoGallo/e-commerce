package com.gerardo.ecommerce.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class Config {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable);
        http.authorizeHttpRequests((auth ->
                auth.anyRequest().permitAll()));
        http.httpBasic(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails a = User.withUsername("a")
                .password("{noop}a")
                .roles("USER")
                .build();

        UserDetails g = User.withUsername("g")
                .password("{noop}g")
                .roles("USER")
                .build();

        UserDetails c = User.withUsername("c")
                .password("{noop}c")
                .roles("USER")
                .build();

        UserDetails z = User.withUsername("z")
                .password("{noop}z")
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(a, g, c, z);

    }
}
