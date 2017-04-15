package com.mirhoseini.framerrunnerapp;

import android.app.Activity;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.Toast;

/**
 * JavaScript Handler which allow you to communicate with Framer project.
 */
public class JavascriptHandler {

    private Activity activity;
    private WebView webView;

    public JavascriptHandler(Activity activity, WebView webView) {
        this.activity = activity;
        this.webView = webView;
    }

    /**
     * This method handles call from Framer
     */
    @JavascriptInterface
    public void javascriptCall(String jsString) {
        Toast.makeText(activity, jsString, Toast.LENGTH_LONG).show();
    }

    /**
     * This method handles call from Android
     */
    public void javaCall(String message) {

        final String webUrl = "javascript:DeviceComponent.displayJavaMessage('" + message + "')";
        // Add this to avoid android.view.windowmanager$badtokenexception unable to add window
        if (!activity.isFinishing())
            // loadurl on UI main thread
            activity.runOnUiThread(new Runnable() {

                @Override
                public void run() {
                    webView.loadUrl(webUrl);
                }
            });
    }
}
