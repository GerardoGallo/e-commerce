package com.gerardo.ecommerce.repository;

import com.gerardo.ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    Optional<Product> findByCodeItem(int codeItem);
}
