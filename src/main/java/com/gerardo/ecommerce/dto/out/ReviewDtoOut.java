package com.gerardo.ecommerce.dto.out;

import java.time.LocalDateTime;

public class ReviewDtoOut {

    private int voto;
    private String commento;
    private LocalDateTime data;
    private UserDtoOut user;
    private ProductDtoOut product;

    public ReviewDtoOut() {
    }

    public int getVoto() {
        return voto;
    }

    public void setVoto(int voto) {
        this.voto = voto;
    }

    public String getCommento() {
        return commento;
    }

    public void setCommento(String commento) {
        this.commento = commento;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public UserDtoOut getUser() {
        return user;
    }

    public void setUser(UserDtoOut user) {
        this.user = user;
    }

    public ProductDtoOut getProduct() {
        return product;
    }

    public void setProduct(ProductDtoOut product) {
        this.product = product;
    }
}
