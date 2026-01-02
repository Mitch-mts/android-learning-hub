package com.example.mylearningapp

import android.os.Bundle
import android.util.Log
import android.webkit.WebView
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class WebViewActivity : AppCompatActivity() {
    lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_web_view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        webView = findViewById(R.id.webView)
        webView.loadUrl("https://www.google.com")

        onBackPressedDispatcher.addCallback(this, callback)

        Log.d("WebViewActivity", "onCreate() called")


    }

    val callback = object : OnBackPressedCallback(true) {

        override fun handleOnBackPressed() {
            if (webView.canGoBack()) {
                webView.goBack()
            } else {
                finish()
            }
        }

    }

    override fun onStart() {
        super.onStart()
        Log.d("WebViewActivity", "onStart() called")
    }

    override fun onStop() {
        super.onStop()
        Log.d("WebViewActivity", "onStop() called")
    }

    override fun onResume() {
        super.onResume()
        Log.d("WebViewActivity", "onResume() called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("WebViewActivity", "onDestroy() called")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("WebViewActivity", "onRestart() called")
    }


}