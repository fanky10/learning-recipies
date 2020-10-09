package io.github.fanky10.recipies

import android.app.ListActivity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.TextView


class RecipesListActivity : ListActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        listAdapter = RecipesAdapter(this)
    }

    private fun openRecipeDetail(idx: Int = 0) {
        val bundle = Bundle()
        bundle.putInt("SELECTED_RECIPE_IDX", idx)
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtras(bundle)
        startActivity(intent)
    }

    inner class RecipesAdapter : ArrayAdapter<String> {

        constructor(ctx: Context) : super(ctx, 0, RecipiesRepository.getRecipesNames())

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val textString = getItem(position)
            val newView: View = convertView ?: LayoutInflater.from(context).inflate(R.layout.recipe_item_list, parent, false)
            newView.findViewById<TextView>(R.id.listTittle).text = textString
            val button = newView.findViewById<Button>(R.id.btn_recipe)
            button.setOnClickListener {
                openRecipeDetail(position)
            }
            return newView
        }

    }
}
