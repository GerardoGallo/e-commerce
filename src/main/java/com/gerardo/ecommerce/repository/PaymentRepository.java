package com.gerardo.ecommerce.repository;

import com.gerardo.ecommerce.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Integer, Payment> {
}
