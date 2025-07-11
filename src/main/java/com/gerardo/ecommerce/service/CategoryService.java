package com.gerardo.ecommerce.service;

import com.gerardo.ecommerce.dto.in.CategoryDtoIn;
import com.gerardo.ecommerce.dto.out.CategoryDtoOut;
import com.gerardo.ecommerce.entity.Category;
import com.gerardo.ecommerce.mapper.MapperCategory;
import com.gerardo.ecommerce.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryDtoOut addCategory(CategoryDtoIn dtoIn) {
        categoryRepository.findByNome(dtoIn.getNome())
                .ifPresent(a -> {
                    throw new RuntimeException("Categoria gia esistente");
                });

        Category newCategory = MapperCategory.dtoInToEntity(dtoIn);
        Category save = categoryRepository.save(newCategory);
        return MapperCategory.entityToDtoOut(save);

    }

    public CategoryDtoOut updateCategory(CategoryDtoIn categoryDtoIn, String name) {
        Category category = categoryRepository.findByNome(name)
                .orElseThrow(() -> new RuntimeException("Category non trovata"));

        category.setNome(categoryDtoIn.getNome());
        Category save = categoryRepository.save(category);
        return MapperCategory.entityToDtoOut(save);
    }

    public CategoryDtoOut deleteCategory(String name) {
        Category category = categoryRepository.findByNome(name)
                .orElseThrow(() -> new RuntimeException("Category non trovata"));

        if (categoryRepository.countCategoryAssociate() > 0) {
            throw new RuntimeException("Non puoi cancellare questa categoria dato che ci sono dei prodotti associati ad essa");
        }
        categoryRepository.delete(category);
        return MapperCategory.entityToDtoOut(category);
    }
}
