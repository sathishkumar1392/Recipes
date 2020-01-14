package com.humanoo.recipes.presentation.recipe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.humanoo.recipes.R
import com.humanoo.recipes.databinding.FragmentRecipeDetailsBinding
import com.humanoo.recipes.presentation.recipe.adapter.bindImageFromUrl
import kotlinx.android.synthetic.main.fragment_recipe_details.*

/*
 * Project Name : Recipes
 * Created by : R Sathish Kumar - Android Application Developer
 * Created on :12-01-2020 
 * File Name : RecipeDetailsFragment.kt
 * ClassName : RecipeDetailsFragment
 * Module Name : app
 * Desc : RecipeDetailsFragment class show the details of Selected recipe.
 */

class RecipeDetailsFragment: Fragment()  {
    private lateinit var binding : FragmentRecipeDetailsBinding
    private val args by lazy {
       RecipeDetailsFragmentArgs.fromBundle(arguments!!)
    }

    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_recipe_details,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    /**
     * initView method set value
     * to the textView through Bundle.
     */
    private fun initView() {
        txtView_tittle.text = args.tittle
        txtView_ingredient.text = args.ingredient
        txtView_web_link.text = args.webLink
        bindImageFromUrl (view = binding.ImgViewPoster, imageUrl = args.image)
        binding.setClickListener {
            it.findNavController().navigate(R.id.action_recipe_details,sendLink(txtView_web_link.text.toString()).arguments)
        }
    }

    /**
     * sendData method send the recipe link to Webview
     * Fragment using NavDirections
     */
    private fun sendLink(webLink: String): NavDirections {
         return RecipeDetailsFragmentDirections.actionRecipeDetails(webLink)
    }
}