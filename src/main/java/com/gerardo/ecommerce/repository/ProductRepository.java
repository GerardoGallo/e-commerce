package com.gerardo.ecommerce.repository;

import com.gerardo.ecommerce.entity.Product;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.time.LocalDateTime;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer>, JpaSpecificationExecutor<Product> {

    Optional<Product> findByCodeItem(int codeItem);

    static Specification<Product> nameEqualTo(String name) {
        return (root, query, cb) -> cb.like(cb.lower(root.get("nome")), "%" + name.toLowerCase() + "%");
    }

    static Specification<Product> pezziDisponibiliGraterThenOne() {
        return (root, query, cb) -> cb.greaterThan(root.get("pezziDisponibili"), 1);
    }

    static Specification<Product> hasMinPrice(double minPrice) {
        return (root, query, cb) -> cb.greaterThan(root.get("prezzo"), minPrice);
    }

    static Specification<Product> hasMaxPrice(double maxPrice) {
        return (root, query, cb) -> cb.lessThan(root.get("prezzo"), maxPrice);
    }

    static Specification<Product> categoryName(String categoryName) {
        return (root, query, cb) -> cb.equal(root.get("category").get("nome"), categoryName);
    }

    static Specification<Product> votoReviewBetween(int minVote, int maxVote) {
        return (root, query, cb) -> cb.between(root.get("review").get("voto"), minVote, maxVote);
    }

    static Specification<Product> dateReviewBetween(LocalDateTime minDate, LocalDateTime maxDate) {
        return (root, query, cb) -> cb.between(root.get("review").get("data"), minDate , maxDate);
    }
}
