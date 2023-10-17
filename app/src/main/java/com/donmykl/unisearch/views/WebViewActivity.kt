package com.donmykl.unisearch.views


import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.donmykl.unisearch.R
import com.donmykl.unisearch.databinding.WebViewActivityBinding


class WebViewActivity : AppCompatActivity() {
    lateinit var binding: WebViewActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = WebViewActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val webView: WebView = binding.webView
        //to stop the app from opening the browser
        webView.webViewClient = WebViewClient()
        webView.settings.javaScriptEnabled = true
        val url = intent.getStringExtra("url")
        if (url != null) {
            webView.loadUrl(url)
        }

    }
}