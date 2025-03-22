WITH split_terms AS (
  SELECT regexp_split_to_table(/* word */'', '\s+') AS term
)

SELECT
    recipe_id
    , recipe_name
    , description
FROM
    recipe
WHERE
    recipe_name ILIKE ANY (
        SELECT '%' || term || '%' FROM split_terms
    )
    OR
    description ILIKE ANY (
        SELECT '%' || term || '%' FROM split_terms
    )
;
