package com.gerardo.ecommerce.repository;

import com.gerardo.ecommerce.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Integer, Cart> {
}
