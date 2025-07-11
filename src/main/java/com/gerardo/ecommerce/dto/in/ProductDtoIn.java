package com.gerardo.ecommerce.dto.in;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProductDtoIn {


    @NotBlank
    private String nome;
    private int pezziDisponibili;
    private double prezzo;
    private int codeItem;
    @NotBlank
    private String descrizione;
    @NotNull
    private CategoryDtoIn category;

    public @NotBlank String getNome() {
        return nome;
    }

    public void setNome(@NotBlank String nome) {
        this.nome = nome;
    }

    public int getPezziDisponibili() {
        return pezziDisponibili;
    }

    public void setPezziDisponibili(int pezziDisponibili) {
        this.pezziDisponibili = pezziDisponibili;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public int getCodeItem() {
        return codeItem;
    }

    public void setCodeItem(int codeItem) {
        this.codeItem = codeItem;
    }

    public @NotBlank String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(@NotBlank String descrizione) {
        this.descrizione = descrizione;
    }

    public @NotNull CategoryDtoIn getCategory() {
        return category;
    }

    public void setCategory(@NotNull CategoryDtoIn category) {
        this.category = category;
    }
}