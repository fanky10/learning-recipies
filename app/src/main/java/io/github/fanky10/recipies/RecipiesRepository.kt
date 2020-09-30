package io.github.fanky10.recipies

import io.github.fanky10.recipies.domain.Ingredient
import io.github.fanky10.recipies.domain.Recipe
import io.github.fanky10.recipies.domain.Step

object RecipiesRepository {
    // from: https://cookpad.com/eeuu/recetas/5999222-chuletas-de-cerdo-con-papas-y-romero-al-horno
    private var recipeChops: Recipe = Recipe(
            "Chuletas de cerdo con papas y romero al horno",
            listOf(
                    Ingredient("chuletas de cerdo", "4"),
                    Ingredient("papas", "2"),
                    Ingredient("cebolla", "1"),
                    Ingredient("sal y pimienta", "a gusto"),
                    Ingredient("romero", "a gusto"),
                    Ingredient("salsa de soja", "1 chorrito"),
                    Ingredient("aceite de oliva", "1 chorrito")
            ),
            listOf(
                    Step(
                            1, "Precalentar el horno. En un bol marinar las chuletas con la sal, pimienta, ajo en polvo, la mitad del romero, aceite de oliva y la salsa de soja"
                    ),
                    Step(
                            2, "En una fuente colocamos la papa cortada en rodajas y la cebolla cortada en julianas. Todo condimentado con sal, pimienta, la mitad del romero y aceite de oliva. Mezclar bien"
                    ),
                    Step(
                            3, "Añadir las chuletas encima de las papas y llevar al horno a fuego medio. A media cocción (aprox unos 15 min) sacar y dar vuelta a las chuletas y dejar 15 min más"
                    )
            )
    )

    private var recipeChoco: Recipe = Recipe(
            "Choco caliente",
            listOf(
                    Ingredient("Chocolate Nesquick™", "2 cucharadas"),
                    Ingredient("Leche", "200ml"),
                    Ingredient("Azúcar", "A gusto")
            ),
            listOf(
                    Step(
                            1, "Colocar la leche en un recipiente y calentar a gusto."
                    ),
                    Step(
                            2, "En una taza, agregar 2 cucharadas de chocolate Nesquick™."
                    ),
                    Step(
                            3, "Cuando la leche esté caliente, ir vertiendo con cuidado mientras se mezcla evitando grumos."
                    ),
                    Step(
                            4, "Colocar azúcar si se desea."
                            )
            )
    )

    fun get() = recipeChops

    fun saveAll(name: String, ing: Ingredient, step: Step) {
        recipeChops = Recipe(name,
                recipeChops.ingredients,
                recipeChops.steps
        )
        recipeChops.ingredients.toMutableList()[0] = ing
        recipeChops.steps.toMutableList()[0] = step
    }
}