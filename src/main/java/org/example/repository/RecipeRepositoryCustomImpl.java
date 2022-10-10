package org.example.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class RecipeRepositoryCustomImpl implements RecipeRepositoryCustom {

    private final NamedParameterJdbcOperations jdbc;
    @Override
    public void addRecipeToFavouritesByPersonIdAndRecipeId( int personId, int recipeId) {
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("personId", personId);
        param.addValue("recipeId", recipeId);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbc.update("insert into person_recipe (person_id, recipe_id) values " +
                "(:personId, :recipeId)", param, keyHolder);
    }

    @Override
    public void removeRecipeFromFavouritesByPersonIdAndRecipeId(int personId, int recipeId) {
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("personId", personId);
        param.addValue("recipeId", recipeId);
        jdbc.update("delete from person_recipe where person_id = :personId" +
                " and recipe_id = :recipeId", param);
    }
}
