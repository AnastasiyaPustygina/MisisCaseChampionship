package org.example.service;

import org.example.domain.Recipe;

import java.util.List;

public interface RecipeService {
    Recipe findByDishId(int id);

    List<Recipe> findByPersonId(int id);
    void deleteRecipeFromFavouritesByPersonIdAndRecipeId(int personId, int recipeId);
    void addRecipeToFavouritesByPersonIdAndRecipeId(int personId, int recipeId);
}
