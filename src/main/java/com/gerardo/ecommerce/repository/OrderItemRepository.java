package com.gerardo.ecommerce.repository;

import com.gerardo.ecommerce.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<Integer, OrderItem> {
}
