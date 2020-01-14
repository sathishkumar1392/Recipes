package com.humanoo.mvvm

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/*
 * Project Name : Recipes
 * Created by : R Sathish Kumar - Android Application Developer
 * Created on :12-01-2020 
 * File Name : BaseViewModel.kt
 * ClassName : BaseViewModel
 * Module Name : app
 */

abstract class BaseViewModel : ViewModel() {

    //ERROR message
    val errorMessage: MutableLiveData<String> = MutableLiveData()
    // Loading indicator
    val isLoading = ObservableField(true)
}