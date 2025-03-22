SELECT
    re_ing.ingredient_id
    , ing.ingredient_name
    , re_ing.quantity
FROM
    recipe_ingredient AS re_ing
INNER JOIN ingredient AS ing
    ON re_ing.ingredient_id = ing.ingredient_id
WHERE
    re_ing.recipe_id = /* recipeId */1
