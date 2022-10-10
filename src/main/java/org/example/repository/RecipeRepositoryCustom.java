package org.example.repository;

public interface RecipeRepositoryCustom {
    void addRecipeToFavouritesByPersonIdAndRecipeId(int personId, int recipeId);
    void removeRecipeFromFavouritesByPersonIdAndRecipeId(int personId, int recipeId);
}
