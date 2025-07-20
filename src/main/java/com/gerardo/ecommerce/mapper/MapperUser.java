package com.gerardo.ecommerce.mapper;

import com.gerardo.ecommerce.dto.in.UserDtoIn;
import com.gerardo.ecommerce.dto.out.UserDtoOut;
import com.gerardo.ecommerce.entity.User;

public class MapperUser {

    public static UserDtoOut entityToDtoOut(User user) {
        UserDtoOut dtoOut = new UserDtoOut();
        dtoOut.setNome(user.getNome());
        dtoOut.setCognome(user.getCognome());
        dtoOut.setEta(user.getEta());
        dtoOut.setListaRuoli(user.getRoles());
        dtoOut.setAddress(MapperAddress.entityToDtoOut(user.getAddress()));
        return dtoOut;
    }

    public static User dtoOutToEntity(UserDtoOut dtoOut) {
        User entity = new User();
        entity.setNome(dtoOut.getNome());
        entity.setCognome(dtoOut.getCognome());
        entity.setEta(dtoOut.getEta());
        return entity;
    }

    public static User dtoInToEntity(UserDtoIn dtoIn) {
        User entity = new User();
        entity.setNome(dtoIn.getNome());
        entity.setCognome(dtoIn.getCognome());
        entity.setEmail(dtoIn.getEmail());
        entity.setEta(dtoIn.getEta());
        return entity;
    }
}
