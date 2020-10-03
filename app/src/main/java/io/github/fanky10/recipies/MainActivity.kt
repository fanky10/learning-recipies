package io.github.fanky10.recipies

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import io.github.fanky10.recipies.domain.Recipe

class MainActivity : AppCompatActivity() {

    private var selectedRecipeIndex: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        selectedRecipeIndex = intent.extras?.getInt("SELECTED_RECIPE_IDX") ?: 0
        Log.d("fanky10", "selected index: $selectedRecipeIndex")
        // only UI binding on view information created
        findViewById<Button>(R.id.btnEdit).setOnClickListener {
            editRecipe()
        }

        RecipiesRepository.setRecipe(selectedRecipeIndex)
        val recipe = RecipiesRepository.get()
        findViewById<TextView>(R.id.txtTitle).text = recipe.name
        findViewById<TextView>(R.id.txtIngredientsList).text = getIngredientsContent(
            recipe
        )
        findViewById<TextView>(R.id.txtStepsList).text = getStepsContent(
            recipe
        )

//        findViewById<Button>(R.id.btnChop).setOnClickListener {
//
//
//        }
//
//        findViewById<Button>(R.id.btnChoco).setOnClickListener {
//            RecipiesRepository.setRecipe(1)
//
//            val recipe = RecipiesRepository.get()
//            findViewById<TextView>(R.id.txtTitle).text = recipe.name
//            findViewById<TextView>(R.id.txtIngredientsList).text = getIngredientsContent(
//                    recipe
//            )
//            findViewById<TextView>(R.id.txtStepsList).text = getStepsContent(
//                    recipe
//            )
//
//        }
//
//        findViewById<Button>(R.id.btnTBD).setOnClickListener {
//            RecipiesRepository.setRecipe(2)
//
//            val recipe = RecipiesRepository.get()
//            findViewById<TextView>(R.id.txtTitle).text = recipe.name
//            findViewById<TextView>(R.id.txtIngredientsList).text = getIngredientsContent(
//                    recipe
//            )
//            findViewById<TextView>(R.id.txtStepsList).text = getStepsContent(
//                    recipe
//            )
//
//        }

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