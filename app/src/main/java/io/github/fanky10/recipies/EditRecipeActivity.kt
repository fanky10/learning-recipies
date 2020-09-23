package io.github.fanky10.recipies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class EditRecipeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_recipe)

        findViewById< Button>(R.id.btnSave).setOnClickListener {
            save()
        }
    }

    private fun save() {
        val name = findViewById<EditText>(R.id.etName).text.toString()
        Toast.makeText(this, "hola mundo: $name", Toast.LENGTH_SHORT).show()
    }
}