package com.example.recipe.domain.recipe.entity;

import lombok.Getter;
import lombok.Setter;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;
import org.seasar.doma.jdbc.entity.NamingType;

@Getter
@Setter
@Entity(naming = NamingType.SNAKE_LOWER_CASE)
@Table(name = "recipe_ingredient")
public class RecipeIngredient {

    @Id
    private Integer recipeId;

    @Id
    private Integer ingredientId;

    private String ingredientName;

    private String quantity;
}
