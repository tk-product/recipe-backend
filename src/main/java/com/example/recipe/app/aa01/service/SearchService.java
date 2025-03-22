package com.example.recipe.app.aa01.service;


import com.example.recipe.app.aa01.dto.request.SearchInputDto;
import com.example.recipe.app.aa01.dto.response.IngredientDto;
import com.example.recipe.app.aa01.dto.response.RecipeInfoDto;
import com.example.recipe.app.aa01.dto.response.SearchListDto;
import com.example.recipe.common.service.BaseService;
import com.example.recipe.domain.recipe.dao.RecipeIngredientDao;
import com.example.recipe.domain.recipe.dao.RecipeSearchDao;
import com.example.recipe.domain.recipe.entity.RecipeIngredient;
import com.example.recipe.domain.recipe.entity.RecipeSearch;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SearchService extends BaseService {

    RecipeSearchDao recipeSearchDao;

    RecipeIngredientDao recipeIngredientDao;

    public SearchListDto getList(SearchInputDto searchInputDto) {

        SearchListDto searchListDto = new SearchListDto();

        List<RecipeSearch> recipeSearchList = recipeSearchDao.findByWord(searchInputDto.getWord());

        if (!CollectionUtils.isEmpty(recipeSearchList)) {
            List<RecipeInfoDto> recipeInfoDtoList = recipeSearchList.stream()
                    .map(recipeSearch -> new RecipeInfoDto(
                            recipeSearch.getRecipeId(),
                            recipeSearch.getRecipeName(),
                            recipeSearch.getDescription(),
                            getIngredientDtoList(recipeIngredientDao.findByRecipeId(recipeSearch.getRecipeId()))
                    ))
                    .collect(Collectors.toList());

            searchListDto.setRecipeInfoList(recipeInfoDtoList);
        }

        return searchListDto;
    }

    private List<IngredientDto> getIngredientDtoList(List<RecipeIngredient> recipeIngredientList) {
        return CollectionUtils.isEmpty(recipeIngredientList)
                ? Collections.emptyList()
                : recipeIngredientList.stream()
                .map(recipeIngredient -> new IngredientDto(
                        recipeIngredient.getIngredientName(),
                        recipeIngredient.getQuantity()
                ))
                .collect(Collectors.toList());
    }
}
