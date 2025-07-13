package com.gerardo.ecommerce.repository;

import com.gerardo.ecommerce.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CartRepository extends JpaRepository<Cart, Integer> {

    @Query(value = "select cart.* from cart inner join users on cart.user_id = users.id where users.email =?1",nativeQuery = true)
    Cart findCartForUser(String email);
}
