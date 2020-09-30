package io.github.fanky10.recipies

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import io.github.fanky10.recipies.domain.Recipe

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // only UI binding on view information created
        findViewById<Button>(R.id.btnEdit).setOnClickListener {
            editRecipe()
        }

        findViewById<Button>(R.id.btnChop).setOnClickListener {

        }

        findViewById<Button>(R.id.btnChoco).setOnClickListener {

        }

        findViewById<Button>(R.id.btnTBD).setOnClickListener {

        }

    }

    override fun onResume() {
        super.onResume()
        // update repository reference
        val recipe = RecipiesRepository.get()
        findViewById<TextView>(R.id.txtTitle).text = recipe.name
        findViewById<TextView>(R.id.txtIngredientsList).text = getIngredientsContent(
            recipe
        )
        findViewById<TextView>(R.id.txtStepsList).text = getStepsContent(
            recipe
        )
    }

    private fun editRecipe() {
        startActivity(Intent(this, EditRecipeActivity::class.java))
    }

    // this could be an extension function
    // docs: https://kotlinlang.org/docs/reference/extensions.html
    private fun getIngredientsContent(recipe: Recipe) = recipe.ingredients.map {
        "${it.quantity} ${it.name}\n"
    }.toString()

    private fun getStepsContent(recipe: Recipe) = recipe.steps
        .sortedBy { it.order }
        .map {
            "(${it.order}) - ${it.description}\n"
        }.toString()
}