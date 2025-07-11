package com.gerardo.ecommerce.mapper;

import com.gerardo.ecommerce.dto.in.ProductDtoIn;
import com.gerardo.ecommerce.dto.out.ProductDtoOut;
import com.gerardo.ecommerce.entity.Product;

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
            dtoOut.setReview(MapperReview.entityToDtoOut(newProduct.getReview()));
        }
        return dtoOut;
    }
}
