package io.github.fanky10.recipies

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class RecipesListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipes_list)

        findViewById<Button>(R.id.btnChop).setOnClickListener {
            openRecipeDetail(0)
        }

        findViewById<Button>(R.id.btnChoco).setOnClickListener {
            openRecipeDetail(1)
        }

        findViewById<Button>(R.id.btnTBD).setOnClickListener {
            openRecipeDetail(2)
        }
    }

    private fun openRecipeDetail(idx: Int = 0) {
        val bundle = Bundle()
        bundle.putInt("SELECTED_RECIPE_IDX", idx)
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtras(bundle)
        startActivity(intent)
    }
}