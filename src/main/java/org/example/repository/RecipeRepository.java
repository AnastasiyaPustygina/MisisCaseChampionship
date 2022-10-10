package org.example.repository;

import org.example.domain.Recipe;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface RecipeRepository extends JpaRepository<Recipe, Integer>, RecipeRepositoryCustom {
    @EntityGraph(attributePaths = {"dish", "dish.ingredient", "dish.image",
            "dish.ingredient.product", "dish.ingredient.product.image"})
    Optional<Recipe> findByDishId(int id);

    @Query("select r from Recipe r join r.person p where p.id = :id")
    @EntityGraph(attributePaths = {"dish", "dish.ingredient", "dish.image",
            "dish.ingredient.product", "dish.ingredient.product.image"})
    List<Recipe> findByPersonId(@Param("id") int id);

}
