package io.github.fanky10.recipies.domain

data class Recipe (
    val name: String,
    val ingredients: MutableList<Ingredient>,
    val steps: MutableList<Step>
)