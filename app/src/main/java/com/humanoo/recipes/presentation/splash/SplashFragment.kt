package com.humanoo.recipes.presentation.splash

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.humanoo.recipes.R

/*
 * Project Name : Recipes
 * Created by : R Sathish Kumar - Android Application Developer
 * Created on :11-01-2020 
 * File Name : SplashFragment.kt
 * ClassName : SplashFragment
 * Module Name : app
 * Desc : A splash screen is a
 * consisting of a logo
 * A splash page is an introduction page on a App
 */

class SplashFragment : Fragment() {

    private val splashViewCount: Long = 1000

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_splash, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Handler().postDelayed({
            context?.let {
                findNavController().navigate(R.id.action_splashFragment_to_recipeList)
            }
        }, splashViewCount)
    }
}
