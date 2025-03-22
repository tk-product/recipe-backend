package com.example.recipe.domain.recipe.entity;

import lombok.Getter;
import lombok.Setter;
import org.seasar.doma.*;
import org.seasar.doma.jdbc.entity.NamingType;

@Getter
@Setter
@Entity(naming = NamingType.SNAKE_LOWER_CASE)
@Table(name = "ingredient")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(sequence = "ingredient_id")
    private Integer ingredientId;

    private String ingredientName;
}
