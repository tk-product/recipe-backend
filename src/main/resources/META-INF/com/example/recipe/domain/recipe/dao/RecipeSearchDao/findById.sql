WITH re_ing AS (
    SELECT
        recipe_id
        , ingredient_id
        , quantity
    FROM
        recipe_ingredient
    WHERE
        recipe_id= /* recipeId */0
)
SELECT
    re_ing.recipe_id
    , re.recipe_name
    , re.description
    , ing.ingredient_name
    , re_ing.quantity
FROM
    re_ing
    INNER JOIN ingredient AS ing
        ON re_ing.ingredient_id = ing.ingredient_id
    INNER JOIN recipe AS re
        ON re_ing.recipe_id = re.recipe_id
;
