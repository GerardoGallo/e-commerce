package com.gerardo.ecommerce.service;

import com.gerardo.ecommerce.dto.in.ProductDtoIn;
import com.gerardo.ecommerce.dto.out.ProductDtoOut;
import com.gerardo.ecommerce.entity.Product;
import com.gerardo.ecommerce.mapper.MapperProduct;
import com.gerardo.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductDtoOut createProduct(ProductDtoIn productDtoIn) {
        Product product = productRepository.findByCodeItem(productDtoIn.getCodeItem())
                .orElseThrow(RuntimeException::new);

        Product newProduct = MapperProduct.dtoInToEntity(productDtoIn);
        productRepository.save(newProduct);
        return MapperProduct.entityToDtoOut(newProduct);

    }
}
