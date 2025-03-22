package com.example.recipe.domain.recipe.dao;

import com.example.recipe.domain.recipe.entity.Recipe;
import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

@Dao
@ConfigAutowireable
public interface RecipeDao {

    @Select
    Recipe findById(Integer recipeId);

    @Insert(excludeNull = true)
    int insert(Recipe recipe);
}
