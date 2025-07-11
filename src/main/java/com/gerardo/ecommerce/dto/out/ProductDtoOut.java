package com.gerardo.ecommerce.dto.out;

import java.util.List;

public class ProductDtoOut {


    private String nome;
    private int pezziDisponibili;
    private double prezzo;
    private String descrizione;
    private CategoryDtoOut category;
    private List<ReviewDtoOut> review;

    public ProductDtoOut() {
    }

    public ProductDtoOut(String nome, int pezziDisponibili, double prezzo, String descrizione, CategoryDtoOut category, List<ReviewDtoOut> review) {
        this.nome = nome;
        this.pezziDisponibili = pezziDisponibili;
        this.prezzo = prezzo;
        this.descrizione = descrizione;
        this.category = category;
        this.review = review;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
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

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public CategoryDtoOut getCategory() {
        return category;
    }

    public void setCategory(CategoryDtoOut category) {
        this.category = category;
    }

    public List<ReviewDtoOut> getReview() {
        return review;
    }

    public void setReview(List<ReviewDtoOut> review) {
        this.review = review;
    }
}
