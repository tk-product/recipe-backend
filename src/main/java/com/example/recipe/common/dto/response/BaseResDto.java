package com.example.recipe.common.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResDto implements Serializable {
    Integer resultCode = 0;
    String requestId;
    ErrorInfoDto errorInfo;
}
