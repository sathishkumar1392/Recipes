package com.humanoo.data.di

import com.humanoo.data.BuildConfig
import com.humanoo.data.common.Connectivity
import com.humanoo.data.common.ConnectivityImpl
import com.humanoo.data.repository.RecipeRepositoryImpl
import com.humanoo.data.repository.RecipeService
import com.humanoo.domain.repository.RecipeRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.bind
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/*
 * Project Name : Recipes
 * Created by : R Sathish Kumar - Android Application Developer
 * Created on :12-01-2020
 * File Name : RemoteModule.kt
 * ClassName : RemoteModule
 * Module Name : app
 * Desc : NetworkModel provides the di for
 * Retrofit, okHttpClient,RecipeService
 */

val NetworkModel = module {
    single { provideRetrofit(get()) }
    factory { okHttpClient() }
    factory { provideRecipeService(get()) }
    single { ConnectivityImpl(androidContext()) }.bind(Connectivity::class)
    single { RecipeRepositoryImpl(get(), get()) }.bind(RecipeRepository::class)

}


fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder().baseUrl(BuildConfig.BASE_URL).client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

fun okHttpClient(): OkHttpClient {
    return OkHttpClient().newBuilder().build()
}

fun provideRecipeService(retrofit: Retrofit): RecipeService =
    retrofit.create(RecipeService::class.java)