package com.humanoo.recipes.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.humanoo.recipes.R

/*
 * Project Name : Recipes
 * Created by : R Sathish Kumar - Android Application Developer
 * Created on :11-01-2020
 * File Name : MainActivity.kt
 * ClassName : MainActivity
 * Module Name : app
 * Desc : Main Activity launch first
 * contain NavController and takes to next screen.
 */

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
