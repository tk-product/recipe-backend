package com.example.recipe.common.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorInfoDto implements Serializable {
    String debugCode;
    String errorItem;
    String errorCode;
    String errorMessage;
}
