package com.sergio994350.webviewapp

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.OVER_SCROLL_ALWAYS
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi
import com.sergio994350.webviewapp.Constants.URL_TO_LOAD
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            webViewSetup()
        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    @RequiresApi(Build.VERSION_CODES.O)
    private fun webViewSetup() {
        web_view.webViewClient = WebViewClient()
        web_view.apply {
            loadUrl(URL_TO_LOAD)
            settings.javaScriptEnabled = true
            settings.safeBrowsingEnabled = true
            settings.setSupportZoom(true)
            web_view.setOverScrollMode(OVER_SCROLL_ALWAYS)
        }
    }

    override fun onBackPressed() {
        if (web_view.canGoBack()) {
            web_view.goBack()
        } else {
            super.onBackPressed()
        }
    }
}

object Constants {
    const val URL_TO_LOAD = "https://yandex.ru/"
}
