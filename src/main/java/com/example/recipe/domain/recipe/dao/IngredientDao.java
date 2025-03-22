package com.example.recipe.domain.recipe.dao;

import com.example.recipe.domain.recipe.entity.Ingredient;
import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

@Dao
@ConfigAutowireable
public interface IngredientDao {

    @Select
    Ingredient findById(Integer ingredientId);

    @Select
    Ingredient findByName(String name);

    @Insert(excludeNull = true)
    int insert(Ingredient ingredient);
}
