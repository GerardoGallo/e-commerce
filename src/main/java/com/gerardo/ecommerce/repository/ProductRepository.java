package com.gerardo.ecommerce.repository;

import com.gerardo.ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Integer, Product> {
}
