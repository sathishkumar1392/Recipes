package com.humanoo.recipes.presentation.recipe.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.recyclerview.widget.RecyclerView
import com.humanoo.recipes.databinding.RecipeItemsBinding
import com.humanoo.recipes.extension.toTransitionGroup
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

class RecipeItemRecyclerViewAdapter :
    RecyclerView.Adapter<RecipeItemRecyclerViewAdapter.ViewHolder>() {
    private var items: MutableList<RecipeData> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: RecipeItemsBinding = RecipeItemsBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount() = items.size

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
            if (size > 0) {
                clear()
                notifyDataSetChanged()
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    class ViewHolder(private val binding: RecipeItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: RecipeData) {
            binding.clickListener = View.OnClickListener {
                val destination = RecipesListFragmentDirections.actionRecipeList(item)
                val extras = FragmentNavigatorExtras(
                    binding.recipeName.toTransitionGroup(),
                    binding.recipeThumbnail.toTransitionGroup()
                )
                it?.findNavController()?.navigate(destination, extras)
            }
            binding.itemDetails = item
            binding.executePendingBindings()
        }
    }
}
