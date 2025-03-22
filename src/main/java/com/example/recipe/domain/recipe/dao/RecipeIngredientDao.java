package com.example.recipe.domain.recipe.dao;

import com.example.recipe.domain.recipe.entity.RecipeIngredient;
import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import java.util.List;

@Dao
@ConfigAutowireable
public interface RecipeIngredientDao {

    @Select
    List<RecipeIngredient> findByRecipeId(Integer recipeId);

    @Insert(excludeNull = true)
    int insert(RecipeIngredient recipeIngredient);
}
