package com.example.recipe.app.aa01.dto.response;

import com.example.recipe.common.dto.response.BaseResDto;
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
public class SearchListDto extends BaseResDto implements Serializable {
    //IngredientDao
    private List<RecipeInfoDto> recipeInfoList;

}
