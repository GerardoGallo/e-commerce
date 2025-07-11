package com.gerardo.ecommerce.service;

import com.gerardo.ecommerce.dto.in.ProductDtoIn;
import com.gerardo.ecommerce.dto.out.ProductDtoOut;
import com.gerardo.ecommerce.entity.Category;
import com.gerardo.ecommerce.entity.Product;
import com.gerardo.ecommerce.mapper.MapperProduct;
import com.gerardo.ecommerce.repository.CategoryRepository;
import com.gerardo.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public ProductDtoOut createProduct(ProductDtoIn productDtoIn) {
        productRepository.findByCodeItem(productDtoIn.getCodeItem())
                .ifPresent(product -> {throw new RuntimeException("prodotto gia esistente");
                });

        Category category = categoryRepository.findByNome(productDtoIn.getCategory().getNome())
                .orElseThrow(()-> new RuntimeException("Categoria non esistente"));

        Product newProduct = MapperProduct.dtoInToEntity(productDtoIn);
        newProduct.setCategory(category);
        Product save = productRepository.save(newProduct);
        return MapperProduct.entityToDtoOut(save);

    }

    public ProductDtoOut updateProduct(ProductDtoIn productDtoIn, int codeItem) {

        Product product = productRepository.findByCodeItem(codeItem)
                .orElseThrow(() -> new RuntimeException("Prodotto non trovato"));

        Category category = categoryRepository.findByNome(productDtoIn.getCategory().getNome())
                .orElseThrow(()-> new RuntimeException("Categoria non esistente"));

        product.setNome(productDtoIn.getNome());
        product.setCodeItem(productDtoIn.getCodeItem());
        product.setPrezzo(productDtoIn.getPrezzo());
        product.setCategory(category);
        product.setCodeItem(productDtoIn.getCodeItem());
        product.setPezziDisponibili(productDtoIn.getPezziDisponibili());

        Product save = productRepository.save(product);
        return MapperProduct.entityToDtoOut(save);

    }

    public ProductDtoOut deleteProduct(int codeItem) {
        Product product = productRepository.findByCodeItem(codeItem)
                .orElseThrow(() -> new RuntimeException("Prodotto non trovato"));

        productRepository.delete(product);
        return MapperProduct.entityToDtoOut(product);
    }
}
