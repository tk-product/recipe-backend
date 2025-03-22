package com.example.recipe.domain.recipe.entity;

import lombok.Getter;
import lombok.Setter;
import org.seasar.doma.*;
import org.seasar.doma.jdbc.entity.NamingType;

@Getter
@Setter
@Entity(naming = NamingType.SNAKE_LOWER_CASE)
@Table(name = "recipe")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(sequence = "recipe_id")
    private Integer recipeId;

    private String recipeName;

    private String description;
}
