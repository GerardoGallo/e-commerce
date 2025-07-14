package com.gerardo.ecommerce.service;

import com.gerardo.ecommerce.dto.in.ProductDtoIn;
import com.gerardo.ecommerce.dto.in.ProductDtoInSpecification;
import com.gerardo.ecommerce.dto.out.ProductDtoOut;
import com.gerardo.ecommerce.entity.Category;
import com.gerardo.ecommerce.entity.Product;
import com.gerardo.ecommerce.mapper.MapperProduct;
import com.gerardo.ecommerce.repository.CategoryRepository;
import com.gerardo.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public ProductDtoOut getProductById(int id) {
        Product productById = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Prodotto con id %s non trovato", id)));

        return MapperProduct.entityToDtoOut(productById);
    }

    public ProductDtoOut createProduct(ProductDtoIn productDtoIn) {
        productRepository.findByCodeItem(productDtoIn.getCodeItem())
                .ifPresent(product -> {
                    throw new RuntimeException("prodotto gia esistente");
                });

        Category category = categoryRepository.findByNome(productDtoIn.getCategory().getNome())
                .orElseThrow(() -> new RuntimeException("Categoria non esistente"));

        Product newProduct = MapperProduct.dtoInToEntity(productDtoIn);
        newProduct.setCategory(category);
        Product save = productRepository.save(newProduct);
        return MapperProduct.entityToDtoOut(save);

    }

    public ProductDtoOut updateProduct(ProductDtoIn productDtoIn, int codeItem) {

        Product product = productRepository.findByCodeItem(codeItem)
                .orElseThrow(() -> new RuntimeException("Prodotto non trovato"));

        Category category = categoryRepository.findByNome(productDtoIn.getCategory().getNome())
                .orElseThrow(() -> new RuntimeException("Categoria non esistente"));

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


    public List<ProductDtoOut> findAll(ProductDtoInSpecification specificationDtoIn) {
        Specification<Product> specification = ProductRepository.nameEqualTo(specificationDtoIn.getNome())
                .and(ProductRepository.pezziDisponibiliGraterThenOne())
                .and(ProductRepository.hasMinPrice(specificationDtoIn.getMinPrice()))
                .and(ProductRepository.hasMaxPrice(specificationDtoIn.getMaxPrice()))
                .and(ProductRepository.categoryName(specificationDtoIn.getCategoryName()))
                .and(ProductRepository.votoReviewBetween(specificationDtoIn.getRewiewMinVote(), specificationDtoIn.getRewiewMaxVote()))
                .and(ProductRepository.dateReviewBetween(specificationDtoIn.getMinDate(), specificationDtoIn.getMaxDate()));

        List<Product> findAll = productRepository.findAll(specification);
        return MapperProduct.listEntityToListDtoOut(findAll);
    }
}
