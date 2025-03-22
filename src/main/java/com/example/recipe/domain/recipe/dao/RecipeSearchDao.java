package com.example.recipe.domain.recipe.dao;

import com.example.recipe.domain.recipe.entity.RecipeSearch;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import java.util.List;

@Dao
@ConfigAutowireable
public interface RecipeSearchDao {

    @Select
    List<RecipeSearch> findByWord(String word);

    @Select
    RecipeSearch findById(Integer recipeId);
}
