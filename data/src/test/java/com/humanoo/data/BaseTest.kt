package com.humanoo.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Rule

/*
 * Project Name : Recipes
 * Created by : R Sathish Kumar - Android Application Developer
 * Created on :14-01-2020 
 * File Name : BaseTest.kt
 * ClassName : BaseTest
 * Module Name : app
 * Desc : 
 */
open class BaseTest {

    @get:Rule
    var rule = InstantTaskExecutorRule()

    @ExperimentalCoroutinesApi
    @get:Rule
    val coroutinesTestRule = CoroutineTestRule()
}