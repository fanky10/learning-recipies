package io.github.fanky10.recipies

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import io.github.fanky10.recipies.domain.Recipe

class MainActivity : AppCompatActivity() {

    private val recipe: Recipe = RecipiesRepository.get()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.txtTitle).text = recipe.name
        findViewById<TextView>(R.id.txtIngredientsList).text = getIngredientsContent()
        findViewById<TextView>(R.id.txtStepsList).text = getStepsContent()
    }

    private fun getIngredientsContent() = recipe.ingredients.map {
        "${it.quantity} ${it.name}\n"
    }.toString()

    private fun getStepsContent() = recipe.steps
        .sortedBy { it.order }
        .map {
            "(${it.order}) - ${it.description}\n"
        }.toString()
}