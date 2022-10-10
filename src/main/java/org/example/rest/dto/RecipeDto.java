package org.example.rest.dto;

import lombok.Builder;
import lombok.Data;
import org.example.domain.Dish;
import org.example.domain.Ingredient;
import org.example.domain.Person;
import org.example.domain.Recipe;

import java.util.List;

@Data
@Builder
public class RecipeDto {

    private final int id;
    private final String text;
    private final DishDto dish;

    public static RecipeDto toDto(Recipe recipe){
        DishDto dishDto = DishDto.toDto(recipe.getDish());
        return RecipeDto.builder().id(recipe.getId()).text(recipe.getText()).dish(dishDto).build();
    }
    public static Recipe toDomainObject(RecipeDto dto, List<Person> persons, Dish dish){
        return Recipe.builder().id(dto.getId()).text(dto.getText()).dish(dish).person(persons).build();
    }
}
