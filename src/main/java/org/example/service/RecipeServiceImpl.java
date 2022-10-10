package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.domain.Recipe;
import org.example.repository.RecipeRepository;
import org.example.service.exception.RecipeNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RecipeServiceImpl implements RecipeService{

    private final RecipeRepository recipeRepository;

    @Override
    public Recipe findByDishId(int id) {
        return recipeRepository.findByDishId(id).orElseThrow(() -> new RecipeNotFoundException(
                "Recipe was not found by dish id " + id));
    }

    @Override
    public List<Recipe> findByPersonId(int id) {
        return recipeRepository.findByPersonId(id);
    }

    @Override
    @Transactional
    public void deleteRecipeFromFavouritesByPersonIdAndRecipeId(int personId, int recipeId) {
        recipeRepository.removeRecipeFromFavouritesByPersonIdAndRecipeId(personId, recipeId);
    }

    @Override
    @Transactional
    public void addRecipeToFavouritesByPersonIdAndRecipeId(int personId, int recipeId) {
        recipeRepository.addRecipeToFavouritesByPersonIdAndRecipeId(personId, recipeId);
    }
}
