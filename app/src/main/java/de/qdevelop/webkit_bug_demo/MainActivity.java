package de.qdevelop.webkit_bug_demo;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.*;
import android.widget.Toast;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void onResume() {
        super.onResume();

        WebView wv = (WebView) this.findViewById(R.id.webView);
        /*wv.getSettings().setJavaScriptEnabled(true);*/
        wv.setWebViewClient(new WebViewClient() {
            @TargetApi(11)
            public WebResourceResponse shouldInterceptRequest(WebView view, String url) {
                InputStream html = new ByteArrayInputStream("<!doctype html><h1>Foo</h1>".getBytes());

                return new WebResourceResponse("text/html", "UTF-8", html);
            }
        });

        wv.loadUrl("http://127.0.0.1:0/foobar");
    }
}
