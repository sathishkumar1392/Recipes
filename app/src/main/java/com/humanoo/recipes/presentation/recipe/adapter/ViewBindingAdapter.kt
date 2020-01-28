package com.humanoo.recipes.presentation.recipe.adapter

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestListener
import com.humanoo.recipes.R

/*
 * Project Name : Recipes
 * Created by : R Sathish Kumar - Android Application Developer
 * Created on :12-01-2020 
 * File Name : ViewBindingAdapter.kt
 * ClassName : ViewBindingAdapter
 * Module Name : app
 * Desc : ViewBindingAdapter You set the attribute in XML
 * and data binding library will look for the binding adapter to
 *  set that property to your view.
 * Since the data is an observable changes will be triggered to the view
 * whenever the data changes.
 *
 */

@BindingAdapter("image")
fun bindImageFromUrl(view: ImageView, imageUrl: String? = null) {
    imageUrl?.let {
        Glide.with(view.context).load(imageUrl).placeholder(R.drawable.ic_launcher_background).into(view)
    }
}

@BindingAdapter("imageFromUrl", "withCrossFade", "requestListener", requireAll = false)
fun bindImageFromUrl(
    view: ImageView,
    imageUrl: String?,
    withCrossFade: Boolean = true,
    requestListener: RequestListener<Drawable>?
) {
    if (!imageUrl.isNullOrEmpty()) {
        val transitionOptions = if (withCrossFade) {
            DrawableTransitionOptions().crossFade()
        } else {
            DrawableTransitionOptions()
        }
        val transition = Glide.with(view.context)
            .load(imageUrl)
            .transition(transitionOptions)

        requestListener?.let { transition.listener(it) }

        transition.into(view)
    }
}