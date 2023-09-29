package com.donmykl.unisearch.views


import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.donmykl.unisearch.R

class WebViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.web_view_activity)

        val webView: WebView = findViewById(R.id.web_view)
        //to stop the app from opening the browser
        webView.webViewClient = WebViewClient()
        webView.settings.javaScriptEnabled = true
         val url = intent.getStringExtra("url")
        if (url != null) {
            webView.loadUrl(url)
        }

    }
}