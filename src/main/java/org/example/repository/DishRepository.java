package org.example.repository;

import org.example.domain.Dish;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DishRepository extends JpaRepository<Dish, Integer> {
    @EntityGraph(attributePaths = {"ingredient", "image"})
    Page<Dish> findAllByCategoryId(int id, Pageable pageable);

    @EntityGraph(attributePaths = {"ingredient", "image"})
    Optional<Dish> findById(int id);

    @EntityGraph(attributePaths = {"image", "ingredient"})
    List<Dish> findByCategoryId(int id);

@Query("select d from Dish d left join d.category c left join d.ingredient i join d.image im where c.id " +
        "in :ids group by im.id, d.id, i.id having count(d.id) = :idCount")
@EntityGraph(attributePaths = {"image", "ingredient"})
    List<Dish> findDishesByCategoryIds(@Param("ids") Integer[] ids, @Param("idCount") long idCount);
}
