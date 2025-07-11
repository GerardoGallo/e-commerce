package com.gerardo.ecommerce.dto.out;

import com.gerardo.ecommerce.entity.Review;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDtoOut {


    private String nome;
    private int pezziDisponibili;
    private double prezzo;
    private String descrizione;
    private CategoryDtoOut category;
    private List<ReviewDtoOut> review;
}
