package com.gerardo.ecommerce.dto.in;

import jakarta.validation.constraints.NotBlank;

public class UserDtoIn {

    @NotBlank
    private String nome;
    @NotBlank
    private String cognome;
    @NotBlank
    private String email;
    @NotBlank
    private String pwd;
    @NotBlank
    private int eta;

    public UserDtoIn() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }
}
