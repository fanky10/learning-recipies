package io.github.fanky10.recipies

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import io.github.fanky10.recipies.domain.Recipie

class MainActivity : AppCompatActivity() {

    private val recipie: Recipie = RecipiesRepository.get()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.txtTitle).text = recipie.name
        findViewById<TextView>(R.id.txtIngredientsList).text = getIngredientsContent()
        findViewById<TextView>(R.id.txtStepsList).text = getStepsContent()
    }

    private fun getIngredientsContent() = recipie.ingredients.map {
        "${it.quantity} ${it.name}\n"
    }.toString()

    private fun getStepsContent() = recipie.steps
        .sortedBy { it.order }
        .map {
            "(${it.order}) - ${it.description}\n"
        }.toString()
}