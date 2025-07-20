package com.gerardo.ecommerce.entity;

import jakarta.persistence.*;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String indirizzo;
    private int nCivico;
    private String nazionalita;
    private String comune;
    private String provincia;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Address() {
    }

    public Address(String indirizzo, int nCivico, String nazionalita, String comune, String provincia) {
        this.indirizzo = indirizzo;
        this.nCivico = nCivico;
        this.nazionalita = nazionalita;
        this.comune = comune;
        this.provincia = provincia;
    }

    public Address(int id, String indirizzo, int nCivico, String nazionalita, String comune, String provincia, User user) {
        this.id = id;
        this.indirizzo = indirizzo;
        this.nCivico = nCivico;
        this.nazionalita = nazionalita;
        this.comune = comune;
        this.provincia = provincia;
        this.user = user;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public int getnCivico() {
        return nCivico;
    }

    public void setnCivico(int nCivico) {
        this.nCivico = nCivico;
    }

    public String getNazionalita() {
        return nazionalita;
    }

    public void setNazionalita(String nazionalita) {
        this.nazionalita = nazionalita;
    }

    public String getComune() {
        return comune;
    }

    public void setComune(String comune) {
        this.comune = comune;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
