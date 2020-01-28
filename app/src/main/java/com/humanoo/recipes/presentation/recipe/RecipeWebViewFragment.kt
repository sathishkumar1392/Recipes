package com.humanoo.recipes.presentation.recipe

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.humanoo.recipes.R
import com.humanoo.recipes.databinding.FragmentRecipeWebviewBinding
import kotlinx.android.synthetic.main.fragment_recipe_webview.*

/*
 * Project Name : Recipes
 * Created by : R Sathish Kumar - Android Application Developer
 * Created on :12-01-2020 
 * File Name : RecipeWebViewFragment.kt
 * ClassName : RecipeWebViewFragment
 * Module Name : app
 * Desc : RecipeWebViewFragment class load recipe web link
 * in the webView User selected
 */

class RecipeWebViewFragment : Fragment() {
    private lateinit var binding: FragmentRecipeWebviewBinding
    private lateinit var webUrl: String
    private val args by lazy {
        RecipeWebViewFragmentArgs.fromBundle(arguments!!)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        webUrl = args.webLink.toString()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRecipeWebviewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadWebView(webUrl)
    }

    /**
     * loadWebView method load the webView
     * from bundle and set the  WebSetting property.
     */
    @SuppressLint("SetJavaScriptEnabled")
    private fun loadWebView(link: String) {

        // Get the web view settings instance
        val webSetting: WebSettings = webView.settings

        // Enable and setup web view cache
        webSetting.setAppCacheEnabled(true)
        webSetting.cacheMode = WebSettings.LOAD_DEFAULT

        // Enable zooming in web view
        webSetting.setSupportZoom(true)
        webSetting.builtInZoomControls = true

        // Enable disable images in web view
        webSetting.blockNetworkImage = false
        // Whether the WebView should load image resources
        webSetting.loadsImagesAutomatically = true

        // Enable java script in web view
        webSetting.javaScriptEnabled = true

        webSetting.useWideViewPort = true
        webSetting.loadWithOverviewMode = true
        webSetting.javaScriptCanOpenWindowsAutomatically = true
        webSetting.domStorageEnabled = true
        webView.loadUrl(link)

        // Set web view client
        webView.webViewClient = object : WebViewClient() {
            override fun onPageStarted(view: WebView, url: String, favicon: Bitmap?) {
                // Page loading started
                progress?.let {
                    progress.visibility = View.VISIBLE
                }
            }

            override fun onPageFinished(view: WebView, url: String) {
                // Page loading finished
                progress?.let {
                    progress.visibility = View.GONE
                }
            }
        }
    }
}
