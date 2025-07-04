package com.gerardo.ecommerce.repository;

import com.gerardo.ecommerce.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Integer, Review> {
}
