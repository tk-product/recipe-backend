package com.example.recipe.common.exception;

import com.example.recipe.common.consts.ErrorCodeEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CustomApplicationException extends RuntimeException {

    private String debugCode;
    private String errorItem;
    private ErrorCodeEnum errorCode;
    private Object placeholder;

    public CustomApplicationException(String debugCode, String errorItem, ErrorCodeEnum errorCode, Object... placeholder) {
        this.debugCode = debugCode;
        this.errorItem = errorItem;
        this.errorCode = errorCode;
        this.placeholder = placeholder;
    }

    public CustomApplicationException(String debugCode, ErrorCodeEnum errorCode, Object... placeholder) {
        this.debugCode = debugCode;
        this.errorCode = errorCode;
        this.placeholder = placeholder;
    }

    public CustomApplicationException(String debugCode, String errorItem, ErrorCodeEnum errorCode) {
        this.debugCode = debugCode;
        this.errorItem = errorItem;
        this.errorCode = errorCode;
    }

    public CustomApplicationException(String debugCode, ErrorCodeEnum errorCode) {
        this.debugCode = debugCode;
        this.errorCode = errorCode;
    }
}
