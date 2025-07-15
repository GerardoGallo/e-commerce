package com.gerardo.ecommerce.dto.out;

import com.gerardo.ecommerce.entity.Role;

import java.util.List;

public class UserDtoOut {

    private String nome;
    private String cognome;
    private int eta;
    private List<Role> listaRuoli;

    public UserDtoOut() {
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

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    public List<Role> getListaRuoli() {
        return listaRuoli;
    }

    public void setListaRuoli(List<Role> listaRuoli) {
        this.listaRuoli = listaRuoli;
    }
}
