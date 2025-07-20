package com.gerardo.ecommerce.dto.out;

public class AddressDtoOut {

    private String indirizzo;
    private int nCivico;
    private String nazionalita;
    private String comune;
    private String provincia;

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
}
