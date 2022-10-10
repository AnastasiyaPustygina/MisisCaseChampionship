package org.example.rest.controller;

import lombok.RequiredArgsConstructor;
import org.example.rest.dto.RecipeDto;
import org.example.service.RecipeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RecipeController {

    private final RecipeService recipeService;

    @GetMapping("/recipe/dish/{dishId}")
    public RecipeDto findRecipesByDishId(@PathVariable("dishId") int dishId){
        return RecipeDto.toDto(recipeService.findByDishId(dishId));
    }

    @GetMapping("/recipe/person/{personId}")
    public List<RecipeDto> findRecipesByPersonId(@PathVariable("personId") int personId){
        return recipeService.findByPersonId(personId).stream().map(RecipeDto::toDto).toList();
    }

    @DeleteMapping("/recipe/{recipeId}/person/{personId}")
    public void deleteRecipeFromFavouritesByPersonIdAndRecipeId(
            @PathVariable("recipeId") int recipeId, @PathVariable("personId") int personId){
        recipeService.deleteRecipeFromFavouritesByPersonIdAndRecipeId(personId, recipeId);
    }

    @PostMapping("/recipe/{recipeId}/person/{personId}")
    public void addRecipeToFavouritesByPersonIdAndRecipeId(
            @PathVariable("recipeId") int recipeId, @PathVariable("personId") int personId){
        recipeService.addRecipeToFavouritesByPersonIdAndRecipeId(personId, recipeId);
    }

}
