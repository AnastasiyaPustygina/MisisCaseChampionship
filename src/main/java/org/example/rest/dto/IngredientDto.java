package org.example.rest.dto;

import lombok.Builder;
import lombok.Data;
import org.example.domain.Dish;
import org.example.domain.Ingredient;
import org.example.domain.Product;

@Data
@Builder
public class IngredientDto {

    private final int id;
    private final int weight;

    public static IngredientDto toDto(Ingredient ingredient){
        return IngredientDto.builder().id(ingredient.getId()).weight(ingredient.getWeight()).build();
    }
    public static Ingredient toDomainObject(IngredientDto dto, Dish dish, Product product){
        return Ingredient.builder().id(dto.getId()).weight(dto.getWeight())
                .product(product).dish(dish).build();
    }
}
