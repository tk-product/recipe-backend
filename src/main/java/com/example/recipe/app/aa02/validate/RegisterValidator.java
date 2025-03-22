package com.example.recipe.app.aa02.validate;

import com.example.recipe.common.validator.BaseValidator;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class RegisterValidator extends BaseValidator implements Validator {

    @Override
    public boolean supports(@NonNull Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(@NonNull Object target, @NonNull Errors errors) {

        super.commonValidate(errors);
    }
}
