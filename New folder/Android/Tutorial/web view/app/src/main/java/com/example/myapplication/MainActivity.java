package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class MainActivity extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.webView);
        //to allow javascript
        webView.getSettings().setJavaScriptEnabled(true);
        //to open web pages in the app
        webView.setWebViewClient(new Browser());

        /*
        net::ERR_CACHE_MISS message
        add this code to AndroidManifest.xml
        <uses-permission android:name="android.permission.INTERNET"/>
         */

    }

    public class Browser extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

    public void clickButton1(View view){
        webView.loadUrl("https://www.google.com/");
    }

    public void clickButton2(View view){
        webView.loadUrl("https://www.facebook.com/");
    }

    public void clickButton3(View view){
        webView.loadUrl("https://www.youtube.com/");
    }



}
