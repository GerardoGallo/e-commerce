package com.gerardo.ecommerce.mapper;

import com.gerardo.ecommerce.dto.out.AddressDtoOut;
import com.gerardo.ecommerce.entity.Address;

public class MapperAddress {

    public static AddressDtoOut entityToDtoOut(Address entity){
        if (entity == null){
            throw new RuntimeException("Entity == null");
        }
        AddressDtoOut dtoOut = new AddressDtoOut();
        dtoOut.setNazionalita(entity.getNazionalita());
        dtoOut.setIndirizzo(entity.getIndirizzo());
        dtoOut.setComune(entity.getComune());
        dtoOut.setnCivico(entity.getnCivico());
        dtoOut.setProvincia(entity.getProvincia());
        return dtoOut;
    }
}
