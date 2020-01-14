package com.humanoo.recipes

import android.app.Application
import com.humanoo.data.di.NetworkModel
import com.humanoo.recipes.di.RecipeModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

/*
 * Project Name : Recipes
 * Created by : R Sathish Kumar - Android Application Developer
 * Created on :11-01-2020
 * File Name : RecipeApplication.kt
 * ClassName : RecipeApplication
 * Module Name : app
 * Desc : The Application class in Android is the base
 * class within an Android app that contains all
 * other components and provides Instance
 */

class RecipeApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        configureDi()
    }

    /**
     * Provides di Configure
     * using Koin of NetworkModel
     * RecipeModule
     */
    private fun configureDi() {
        startKoin {
            androidLogger()
            androidContext(this@RecipeApplication)
            modules(listOf(NetworkModel, RecipeModule))
        }
    }
}