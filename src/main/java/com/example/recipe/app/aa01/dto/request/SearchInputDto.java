package com.example.recipe.app.aa01.dto.request;

import com.example.recipe.common.dto.request.BaseReqDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SearchInputDto extends BaseReqDto implements Serializable {

    @NotBlank
    private String word;
}
