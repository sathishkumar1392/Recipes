package com.humanoo.recipes.presentation.recipe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.humanoo.recipes.databinding.FragmentRecipeDetailsBinding

/*
 * Project Name : Recipes
 * Created by : R Sathish Kumar - Android Application Developer
 * Created on :12-01-2020 
 * File Name : RecipeDetailsFragment.kt
 * ClassName : RecipeDetailsFragment
 * Module Name : app
 * Desc : RecipeDetailsFragment class show the details of Selected recipe.
 */

class RecipeDetailsFragment : Fragment() {
    private lateinit var binding: FragmentRecipeDetailsBinding
    private val args: RecipeDetailsFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition = android.transition.TransitionInflater.from(context)
            .inflateTransition(android.R.transition.no_transition)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRecipeDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recipe = args.recipe
        binding.run { executePendingBindings() }
        onClick()
    }

    private fun onClick() {
        binding.clickListener = View.OnClickListener {
            val destination = RecipeDetailsFragmentDirections.actionRecipeDetails(args.recipe.href)
            it.findNavController().navigate(destination)

        }
    }
}
