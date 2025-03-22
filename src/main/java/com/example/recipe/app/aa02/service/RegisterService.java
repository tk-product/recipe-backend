package com.example.recipe.app.aa02.service;

import com.example.recipe.app.aa02.dto.request.IngredientDto;
import com.example.recipe.app.aa02.dto.request.RegisterInputDto;
import com.example.recipe.app.aa02.dto.response.RegisterResultDto;
import com.example.recipe.common.consts.ErrorCodeEnum;
import com.example.recipe.common.exception.CustomApplicationException;
import com.example.recipe.common.service.BaseService;
import com.example.recipe.domain.recipe.dao.IngredientDao;
import com.example.recipe.domain.recipe.dao.RecipeDao;
import com.example.recipe.domain.recipe.dao.RecipeIngredientDao;
import com.example.recipe.domain.recipe.entity.Ingredient;
import com.example.recipe.domain.recipe.entity.Recipe;
import com.example.recipe.domain.recipe.entity.RecipeIngredient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class RegisterService extends BaseService {

    RecipeDao recipeDao;

    IngredientDao ingredientDao;

    RecipeIngredientDao recipeIngredientDao;

    public RegisterResultDto register(RegisterInputDto registerInputDto) {

        int result = 0;

        Recipe recipe = new Recipe();
        recipe.setRecipeName(registerInputDto.getRecipeName());
        recipe.setDescription(registerInputDto.getDescription());
        result = recipeDao.insert(recipe);
        if (result == 0) {
            throw new CustomApplicationException("AA02SE001", ErrorCodeEnum.A001E00001);
        }

        for (IngredientDto ingredientDto : registerInputDto.getIngredients()) {

            Ingredient ingredient = ingredientDao.findByName(ingredientDto.getIngredientName());

            // 登録されていない場合に登録する
            if (ingredient == null) {
                ingredient = new Ingredient();
                ingredient.setIngredientName(ingredientDto.getIngredientName());
                result = ingredientDao.insert(ingredient);
                if (result == 0) {
                    throw new CustomApplicationException("AA02SE002", ErrorCodeEnum.A001E00002);
                }
            }

            RecipeIngredient recipeIngredient = new RecipeIngredient();
            recipeIngredient.setRecipeId(recipe.getRecipeId());
            recipeIngredient.setIngredientId(ingredient.getIngredientId());
            recipeIngredient.setQuantity(ingredientDto.getQuantity());
            result = recipeIngredientDao.insert(recipeIngredient);
            if (result == 0) {
                throw new CustomApplicationException("AA02SE003", ErrorCodeEnum.A001E00003);
            }
        }

        return new RegisterResultDto();
    }
}
