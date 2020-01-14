package com.humanoo.recipes.presentation.recipe.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.humanoo.recipes.R
import com.humanoo.recipes.databinding.RecipeItemsBinding
import com.humanoo.recipes.model.RecipeData
import com.humanoo.recipes.presentation.recipe.RecipesListFragmentDirections


/*
 * Project Name : Recipes
 * Created by : R Sathish Kumar - Android Application Developer
 * Created on :12-01-2020 
 * File Name : RecipeItemRecyclerViewAdapter.kt
 * ClassName : RecipeItemRecyclerViewAdapter
 * Module Name : app
 * Desc :  RecipeItemRecyclerViewAdapter class for the bind the value into
 * recyclerView show the value in list
 */

class RecipeItemRecyclerViewAdapter:RecyclerView.Adapter<RecipeItemRecyclerViewAdapter.ViewHolder>() {
    private var items: MutableList<RecipeData> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding:RecipeItemsBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), R.layout.recipe_items,parent,false)
        return  ViewHolder(binding)

    }

    override fun getItemCount(): Int {
        return items.size
    }

    /**
     * updating data to adapter
     */
    fun update(data: List<RecipeData>) {
        this.items.apply {
            val size = size
            addAll(size, data)
            notifyItemChanged(size)
        }
    }

    /**
     * clear data to adapter
     */
    fun clear() {
       this.items.apply {
           val size = size
           if (size>0){
               clear()
               notifyDataSetChanged()
           }
       }
    }

    override fun onBindViewHolder(holder: RecipeItemRecyclerViewAdapter.ViewHolder, position: Int) {
        holder.bind(items[position])
    }


    class ViewHolder(private val  binding: RecipeItemsBinding):
        RecyclerView.ViewHolder(binding.root){
        private lateinit var item: RecipeData
        fun bind(item: RecipeData) {
            this.item = item
            binding.itemDetails = item
            binding.setClickListener {
                val tittle = item.title
                val ingredients: String = item.ingredients
                val photoUrl = item.thumbnail
                val webLink = item.href
                it?.findNavController()?.navigate(R.id.action_recipe_list,sendData(tittle,ingredients,photoUrl,webLink).arguments)}
        }

        private fun sendData(tittle: String, desc: String, imageUrl: String,webLink:String): NavDirections {
            return RecipesListFragmentDirections.actionRecipeList(tittle, desc, imageUrl,webLink)
        }
    }
}