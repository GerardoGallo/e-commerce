package com.gerardo.ecommerce.mapper;

import com.gerardo.ecommerce.dto.in.CategoryDtoIn;
import com.gerardo.ecommerce.dto.out.CartDtoOut;
import com.gerardo.ecommerce.dto.out.CategoryDtoOut;
import com.gerardo.ecommerce.entity.Category;

import java.util.List;
import java.util.stream.Collectors;

public class MapperCategory {

    public static Category dtoInToEntity(CategoryDtoIn category) {
        Category entity = new Category();
        entity.setNome(category.getNome());
        return entity;
    }

    public static Category dtoOutToEntity(CategoryDtoOut dtoOut) {
        Category entity = new Category();
        entity.setNome(dtoOut.getNome());
        return entity;
    }

    public static CategoryDtoOut entityToDtoOut(Category category) {
        CategoryDtoOut dtoOut = new CategoryDtoOut();
        dtoOut.setNome(category.getNome());
        return dtoOut;
    }

    public static List<CategoryDtoOut> listEntityToListDtoOut(List<Category> listCategory){
        return listCategory.stream().map(MapperCategory::entityToDtoOut).collect(Collectors.toList());
    }
}
