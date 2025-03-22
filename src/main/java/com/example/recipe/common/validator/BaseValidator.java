package com.example.recipe.common.validator;

import com.example.recipe.common.consts.ErrorCodeEnum;
import com.example.recipe.common.exception.CustomApplicationException;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import java.util.Objects;

public class BaseValidator {

    protected void commonValidate(Errors errors) {

        for (FieldError error : errors.getFieldErrors()) {
            String[] errorCodes = error.getCodes();
            String annotationValue = Objects.requireNonNull(errorCodes)[errorCodes.length - 1];

            switch (annotationValue) {
                case "NotNull" ->
                        throw new CustomApplicationException("VC001", error.getField(), ErrorCodeEnum.C001E00001);
                case "Pattern" ->
                        throw new CustomApplicationException("VC002", error.getField(), ErrorCodeEnum.C001E00002);
                default -> throw new CustomApplicationException("VC003", error.getField(), ErrorCodeEnum.C001E00003);
            }
        }
    }
}
