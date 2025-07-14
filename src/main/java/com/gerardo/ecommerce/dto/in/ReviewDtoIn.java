package com.gerardo.ecommerce.dto.in;

public class ReviewDtoIn {

    private int voto;
    private String commento;
    private int codeItemProduct;

    public ReviewDtoIn() {
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

    public int getCodeItemProduct() {
        return codeItemProduct;
    }

    public void setCodeItemProduct(int codeItemProduct) {
        this.codeItemProduct = codeItemProduct;
    }
}
