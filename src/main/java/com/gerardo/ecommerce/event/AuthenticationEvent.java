package com.gerardo.ecommerce.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationEvent {

    private static final Logger log = LoggerFactory. getLogger(AuthenticationEvent.class);

    @EventListener
    public void onSuccess(AuthenticationSuccessEvent successEvent){
        log.info("Bravo sei stato autenticato {}",successEvent.getAuthentication());
    }

    @EventListener
    public void fallito(AbstractAuthenticationFailureEvent failureEvent){
        log.info("fallito {}",failureEvent.getAuthentication());
    }
}
