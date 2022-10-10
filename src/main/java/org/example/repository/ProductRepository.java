package org.example.repository;

import org.example.domain.Product;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("select p from Product p join Ingredient i on i.product.id = p.id where i.id = :id")
    @EntityGraph(attributePaths = "image")
    Optional<Product> findByIngredientId(@Param("id") int id);
}
