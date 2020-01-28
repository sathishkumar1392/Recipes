package com.humanoo.recipes.presentation.recipe

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.humanoo.recipes.R
import com.humanoo.recipes.databinding.FragmentRecipeListBinding
import com.humanoo.recipes.extension.waitForTransition
import com.humanoo.recipes.presentation.recipe.adapter.RecipeItemRecyclerViewAdapter
import com.humanoo.recipes.presentation.recipe.viewmodel.RecipeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

/*
 * Project Name : Recipes
 * Created by : R Sathish Kumar - Android Application Developer
 * Created on :11-01-2020 
 * File Name : RecipesFragment.kt
 * ClassName : RecipesFragment
 * Module Name : app
 * Desc : RecipesListFragment  class communicate
 * with RecipeViewModel and
 * display the Data in list
 * RecipesListFragment is handling UI part.
 */

class RecipesListFragment : Fragment() {

    lateinit var binding: FragmentRecipeListBinding
    private lateinit var getFragmentContext: Activity
    private val recipeViewModel: RecipeViewModel by viewModel()
    private val recipeAdapter: RecipeItemRecyclerViewAdapter = RecipeItemRecyclerViewAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getFragmentContext = this.requireActivity()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (!::binding.isInitialized) {
            binding = FragmentRecipeListBinding.inflate(inflater, container, false)
            binding.viewModel = recipeViewModel
            binding.let {
                it.adapter = recipeAdapter
            }
            setUpViewModelObserver()
            initSearchView()
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        waitForTransition(binding.rcyVwRecipeList)
    }

    /**
     * initSearchView method call the search the recipe by
     *  Ingredients method
     * in the presenter
     *
     * @param query the search keyword string
     * communicate with ViewModel
     */
    private fun initSearchView() {
        binding.searchViewIngredient.isActivated = true
        binding.searchViewIngredient.queryHint = getString(R.string.str_search_recipe)
        binding.searchViewIngredient.onActionViewExpanded()
        binding.searchViewIngredient.isIconified = false
        binding.searchViewIngredient.clearFocus()

        val closeBtnId: Int = binding.searchViewIngredient.context.resources
            .getIdentifier("android:id/search_close_btn", null, null)

        val closeButton: ImageView =
            binding.searchViewIngredient.findViewById(closeBtnId) as ImageView

        binding.searchViewIngredient.setOnClickListener {
            binding.searchViewIngredient.isIconified = false
        }

        binding.searchViewIngredient.setOnQueryTextListener(object :
            SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(newText: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                val search = newText ?: ""
                if (search.length >= 3) {
                    recipeAdapter.clear()
                    recipeViewModel.loadRecipeSearchList(search)
                }
                return true
            }
        })

        closeButton.setOnClickListener {
            binding.searchViewIngredient.setQuery("", false)
            binding.searchViewIngredient.clearFocus()
        }
    }

    private fun setUpViewModelObserver() {

        // adds the new set of results to the adapter list
        recipeViewModel.recipeData().run {
            observe(this@RecipesListFragment, Observer(recipeAdapter::update))
        }

        /**
         * displaying error status from viewModel communicate via Observer
         * display the error message
         */
        recipeViewModel.errorMessage.observe(
            this,
            Observer {
                Toast.makeText(getFragmentContext, it, Toast.LENGTH_SHORT).show()
            }
        )
    }
}
