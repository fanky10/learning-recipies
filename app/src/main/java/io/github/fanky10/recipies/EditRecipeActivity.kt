package io.github.fanky10.recipies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import io.github.fanky10.recipies.domain.Ingredient
import io.github.fanky10.recipies.domain.Recipe
import io.github.fanky10.recipies.domain.Step

class EditRecipeActivity : AppCompatActivity() {

    private val recipe: Recipe = RecipiesRepository.get()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_recipe)

        findViewById<EditText>(R.id.etName).setText(recipe.name)
        findViewById<EditText>(R.id.etIng1).setText(recipe.ingredients[0].name)
        findViewById<EditText>(R.id.etIng1Quantity).setText(recipe.ingredients[0].quantity)
        findViewById<EditText>(R.id.etStep1).setText(recipe.steps[0].description)

        findViewById< Button>(R.id.btnSave).setOnClickListener {
            save()
        }
    }

    private fun save() {
        val ing1: String = findViewById<EditText>(R.id.etIng1).text.toString()
        val ingQuantity: String = findViewById<EditText>(R.id.etIng1Quantity).text.toString()
        val step1: String = findViewById<EditText>(R.id.etStep1).text.toString()

        val ingredient1 = Ingredient(ing1, ingQuantity)
        val stepNumber1 = Step(1, step1)

        RecipiesRepository.saveAll(findViewById<EditText>(R.id.etName).text.toString(), ingredient1, stepNumber1)
        finish()
    }
}