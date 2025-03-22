package com.example.recipe.common.consts;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCodeEnum {
    A001I00001("A001I00001"),
    A001I00002("A001I00002"),
    A001E00001("A001E00001"),
    A001E00002("A001E00002"),
    A001E00003("A001E00003"),
    C001E00001("C001E00001"),
    C001E00002("C001E00002"),
    C001E00003("C001E00003"),
    Z001E00001("Z001E00001");

    private final String code;
}
