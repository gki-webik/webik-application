package ru.gkiwebik.www;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WebView wv = findViewById(R.id.mainWebView);
        wv.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                Log.i("WEBKITDEBUG", request.getUrl().getHost());
                Log.i("WEBKITDEBUG", getString(R.string.some_domain));
                Log.i("WEBKITDEBUG", request.getUrl().getHost().matches(getString(R.string.some_domain)) ? "YES" : "NO");
                // Если тот же домен
                if (request.getUrl().getHost().matches(getString(R.string.some_domain)) || request.getUrl().getHost().matches(getString(R.string.some_domain_2)) || request.getUrl().getHost().matches(getString(R.string.some_domain_3)) || request.getUrl().getHost().matches(getString(R.string.some_domain_4)) || request.getUrl().getHost().matches(getString(R.string.some_domain_5)) || request.getUrl().getHost().matches(getString(R.string.some_domain_6)) || request.getUrl().getHost().matches(getString(R.string.some_domain_7)) || request.getUrl().getHost().matches(getString(R.string.some_domain_8)) || request.getUrl().getHost().matches(getString(R.string.some_domain_9)) || request.getUrl().getHost().matches(getString(R.string.some_domain_10)) || request.getUrl().getHost().matches(getString(R.string.some_domain_11)) || request.getUrl().getHost().matches(getString(R.string.some_domain_12))) {
                    view.loadUrl(request.getUrl().toString());
                    return false;
                }
                // В противном случае открываем снаружи
                Intent intent = new Intent(Intent.ACTION_VIEW, request.getUrl());
                view.getContext().startActivity(intent);
                return true;
            }
        });

        WebSettings ws = wv.getSettings();
        ws.setJavaScriptEnabled(true);
        ws.setDomStorageEnabled(true);
        ws.setLoadWithOverviewMode(true);
        ws.setUseWideViewPort(true);
        ws.setBuiltInZoomControls(true);
        ws.setDisplayZoomControls(false);
        ws.setSupportZoom(true);
        ws.setDefaultTextEncodingName("utf-8");

        wv.loadUrl(getString(R.string.main_url));

    }
}
