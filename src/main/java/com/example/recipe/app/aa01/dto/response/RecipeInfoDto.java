package com.example.recipe.app.aa01.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RecipeInfoDto implements Serializable {

    private Integer recipeId;
    private String recipeName;
    private String description;
    private List<IngredientDto> ingredientList;

}
