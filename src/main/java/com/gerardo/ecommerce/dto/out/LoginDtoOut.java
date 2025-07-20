package com.gerardo.ecommerce.dto.out;

public class LoginDtoOut {

    private String token;

    public LoginDtoOut(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
