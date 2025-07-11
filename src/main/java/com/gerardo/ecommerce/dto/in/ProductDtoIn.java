package com.gerardo.ecommerce.dto.in;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDtoIn {


    private String nome;
    private int pezziDisponibili;
    private double prezzo;
    private int codeItem;
    private String descrizione;
    private CategoryDtoIn category;
}