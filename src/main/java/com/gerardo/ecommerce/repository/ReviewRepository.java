package com.gerardo.ecommerce.repository;

import com.gerardo.ecommerce.entity.Review;
import org.apache.catalina.valves.rewrite.RewriteCond;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

    @Query(value = "select review.* from review inner join product on review.product_id = product.id where product.code_item = ?1",nativeQuery = true)
    List<Review> findByIdProduct(int codeItem);
}
