package com.gerardo.ecommerce.mapper;

import com.gerardo.ecommerce.dto.out.UserDtoOut;
import com.gerardo.ecommerce.entity.User;

public class MapperUser {

    public static UserDtoOut entityToDtoOut(User user) {
        UserDtoOut dtoOut = new UserDtoOut();
        dtoOut.setNome(user.getNome());
        dtoOut.setCognome(user.getCognome());
        dtoOut.setEta(user.getEta());
        return dtoOut;
    }
}
