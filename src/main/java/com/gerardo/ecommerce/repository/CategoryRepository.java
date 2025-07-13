package com.gerardo.ecommerce.repository;

import com.gerardo.ecommerce.entity.Category;
import com.gerardo.ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    Optional<Category> findByNome(String nome);

    /*Il seguente metodo verifica quanti profotti sono associati ad una categoria e mi serve
    * perche solo nel caso una categoria non sia associata a nessun prodotto allora puo essere eliminata*/
    @Query(value = "select count(*) from product inner join category on product.category_id = category.id",nativeQuery = true)
    int countCategoryAssociate();

    @Query(value = "select product.* from product inner join category on product.category_id = category.id where category.nome =?1",nativeQuery = true)
    List<Product> findProductByCateogry(String categoryName);
}
