package com.example.recipe.app.aa02.dto.request;

import com.example.recipe.common.dto.request.BaseReqDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
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
public class RegisterInputDto extends BaseReqDto implements Serializable {

    @NotBlank
    private String recipeName;

    private String description;

    private List<IngredientDto> ingredients;

}
