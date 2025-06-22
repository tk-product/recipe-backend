package com.example.recipe.app.aa02.controller;

import com.example.recipe.app.aa02.dto.request.RegisterInputDto;
import com.example.recipe.app.aa02.service.RegisterService;
import com.example.recipe.app.aa02.validate.RegisterValidator;
import com.example.recipe.common.controller.BaseController;
import com.example.recipe.common.dto.response.BaseResDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class RegisterController extends BaseController {

    RegisterService registerService;

    RegisterValidator registerValidator;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(registerValidator);
    }

    @PostMapping("/register")
    public BaseResDto confirm(@Validated RegisterInputDto registerInputDto, BindingResult bindingResult) {
        return registerService.register(registerInputDto);
    }
}
