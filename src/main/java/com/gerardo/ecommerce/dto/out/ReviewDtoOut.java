package com.gerardo.ecommerce.dto.out;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDtoOut {

    private int voto;
    private String commento;
    private LocalDateTime data;
    private UserDtoOut user;
    private ProductDtoOut product;
}
