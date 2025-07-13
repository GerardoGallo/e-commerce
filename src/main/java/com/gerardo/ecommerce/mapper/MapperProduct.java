package com.gerardo.ecommerce.mapper;

import com.gerardo.ecommerce.dto.in.ProductDtoIn;
import com.gerardo.ecommerce.dto.out.ProductDtoOut;
import com.gerardo.ecommerce.entity.Product;

import java.util.Map;

public class MapperProduct {

    public static Product dtoInToEntity(ProductDtoIn productDtoIn) {
        Product entity = new Product();
        entity.setNome(productDtoIn.getNome());
        entity.setPrezzo(productDtoIn.getPrezzo());
        entity.setDescrizione(productDtoIn.getDescrizione());
        entity.setPezziDisponibili(productDtoIn.getPezziDisponibili());
        entity.setCodeItem(productDtoIn.getCodeItem());
        if (productDtoIn.getCategory() != null) {
            entity.setCategory(MapperCategory.dtoInToEntity(productDtoIn.getCategory()));
        }
        return entity;
    }

    public static Product dtoOutToEntity(ProductDtoOut dtoOut) {
        Product entity = new Product();
        entity.setNome(dtoOut.getNome());
        entity.setPrezzo(dtoOut.getPrezzo());
        entity.setDescrizione(dtoOut.getDescrizione());
        entity.setPezziDisponibili(dtoOut.getPezziDisponibili());
        if (dtoOut.getCategory() != null) {
            entity.setCategory(MapperCategory.dtoOutToEntity(dtoOut.getCategory()));
        }

        if (dtoOut.getReview() != null) {
            entity.setReview(MapperReview.ListDtoOutToListEntity(dtoOut.getReview()));
        }
        return entity;
    }

    public static ProductDtoOut entityToDtoOut(Product newProduct) {
        ProductDtoOut dtoOut = new ProductDtoOut();
        dtoOut.setNome(newProduct.getNome());
        dtoOut.setDescrizione(newProduct.getDescrizione());
        dtoOut.setPrezzo(newProduct.getPrezzo());
        dtoOut.setPezziDisponibili(newProduct.getPezziDisponibili());
        if (newProduct.getCategory() != null) {
            dtoOut.setCategory(MapperCategory.entityToDtoOut(newProduct.getCategory()));
        }
        if (newProduct.getReview() != null) {
            dtoOut.setReview(MapperReview.listEntityToListDtoOut(newProduct.getReview()));
        }
        return dtoOut;
    }
}
