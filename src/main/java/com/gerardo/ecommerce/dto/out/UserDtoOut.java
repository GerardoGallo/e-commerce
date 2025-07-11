package com.gerardo.ecommerce.dto.out;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDtoOut {

    private String nome;
    private String cognome;
    private int eta;
}
