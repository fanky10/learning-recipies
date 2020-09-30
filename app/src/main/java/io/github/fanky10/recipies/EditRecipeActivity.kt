package io.github.fanky10.recipies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import io.github.fanky10.recipies.domain.Recipe

class EditRecipeActivity : AppCompatActivity() {

    private val recipe: Recipe = RecipiesRepository.get()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_recipe)
        findViewById<EditText>(R.id.etName).setText(recipe.name)
        findViewById< Button>(R.id.btnSave).setOnClickListener {
            save()
        }
    }

    private fun save() {
        RecipiesRepository.saveName(findViewById<EditText>(R.id.etName).text.toString())
        finish()
    }
}