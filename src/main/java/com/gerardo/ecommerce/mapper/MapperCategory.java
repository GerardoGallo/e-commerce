package com.gerardo.ecommerce.mapper;

import com.gerardo.ecommerce.dto.in.CategoryDtoIn;
import com.gerardo.ecommerce.dto.out.CategoryDtoOut;
import com.gerardo.ecommerce.entity.Category;

public class MapperCategory {

    public static Category dtoInToEntity(CategoryDtoIn category) {
        Category entity = new Category();
        entity.setNome(category.getNome());
        return entity;
    }

    public static CategoryDtoOut entityToDtoOut(Category category) {
        CategoryDtoOut dtoOut = new CategoryDtoOut();
        dtoOut.setNome(category.getNome());
        return dtoOut;
    }
}
