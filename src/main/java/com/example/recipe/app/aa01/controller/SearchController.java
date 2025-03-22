package com.example.recipe.app.aa01.controller;

import com.example.recipe.app.aa01.dto.request.SearchInputDto;
import com.example.recipe.app.aa01.service.SearchService;
import com.example.recipe.app.aa01.validate.SearchValidator;
import com.example.recipe.common.controller.BaseController;
import com.example.recipe.common.dto.response.BaseResDto;
import lombok.AllArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class SearchController extends BaseController {

    SearchService recipeSearchService;

    SearchValidator searchValidator;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(searchValidator);
    }


    @GetMapping("/search")
    public BaseResDto search(@Validated SearchInputDto searchInputDto, BindingResult bindingResult) {

        return recipeSearchService.getList(searchInputDto);
    }
}
