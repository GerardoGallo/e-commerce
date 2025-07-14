package com.gerardo.ecommerce.dto.in;

import java.time.LocalDateTime;

public class ProductDtoInSpecification {

    private String nome;
    private int pezziDisponibili;
    private double minPrice;
    private double maxPrice;
    private String categoryName;
    private int rewiewMinVote;
    private int rewiewMaxVote;
    private LocalDateTime minDate;
    private LocalDateTime maxDate;

    public ProductDtoInSpecification() {
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

    public double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(double minPrice) {
        this.minPrice = minPrice;
    }

    public double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getRewiewMinVote() {
        return rewiewMinVote;
    }

    public void setRewiewMinVote(int rewiewMinVote) {
        this.rewiewMinVote = rewiewMinVote;
    }

    public int getRewiewMaxVote() {
        return rewiewMaxVote;
    }

    public void setRewiewMaxVote(int rewiewMaxVote) {
        this.rewiewMaxVote = rewiewMaxVote;
    }

    public LocalDateTime getMinDate() {
        return minDate;
    }

    public void setMinDate(LocalDateTime minDate) {
        this.minDate = minDate;
    }

    public LocalDateTime getMaxDate() {
        return maxDate;
    }

    public void setMaxDate(LocalDateTime maxDate) {
        this.maxDate = maxDate;
    }
}
