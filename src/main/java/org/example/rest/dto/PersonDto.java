package org.example.rest.dto;

import lombok.Builder;
import lombok.Data;
import org.example.domain.Person;
import org.example.domain.Recipe;

import java.util.List;

@Data
@Builder
public class PersonDto {
    private final int id;
    private final List<RecipeDto> recipes;

    public static PersonDto toDto(Person person){
        List<RecipeDto> recipes = person.getRecipe().stream().map(RecipeDto::toDto).toList();
        return PersonDto.builder().id(person.getId()).recipes(recipes).build();
    }
    public static Person toDomainObject(PersonDto personDto, List<Recipe> recipes){
        return Person.builder().id(personDto.getId()).recipe(recipes).build();
    }
}
