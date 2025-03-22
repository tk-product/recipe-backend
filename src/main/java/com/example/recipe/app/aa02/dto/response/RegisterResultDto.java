package com.example.recipe.app.aa02.dto.response;

import com.example.recipe.common.dto.response.BaseResDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RegisterResultDto extends BaseResDto implements Serializable {

}
