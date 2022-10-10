package org.example.rest.dto;

import lombok.Builder;
import lombok.Data;
import org.example.domain.Category;
import org.example.domain.Dish;
import org.example.domain.Image;
import org.example.domain.Ingredient;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Data
@Builder
public class DishDto {

    private final int id;
    private final String name;
    private final List<IngredientDto> ingredients;
    private final ImageDto image;

    public static DishDto toDto(Dish dish){
        List<IngredientDto> ingredientDto = dish.getIngredient().stream().map(
                IngredientDto::toDto).toList();
        ImageDto imageDto = ImageDto.toDto(dish.getImage());
        return DishDto.builder().id(dish.getId()).name(dish.getName()).ingredients(ingredientDto)
                .image(imageDto).build();
    }

    public static Dish toDomainObject(DishDto dto, List<Ingredient> ingredients,
                                      List<Category> categories){
        Image image = ImageDto.toDomainObject(dto.getImage());
        return Dish.builder().id(dto.getId()).name(dto.getName()).ingredient(ingredients)
                .category(categories).image(image).build();
    }

}
