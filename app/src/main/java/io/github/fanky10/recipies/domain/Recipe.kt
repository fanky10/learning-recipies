package io.github.fanky10.recipies.domain

data class Recipe (
    val name: String,
    val ingredients: List<Ingredient>,
    val steps: List<Step>
)