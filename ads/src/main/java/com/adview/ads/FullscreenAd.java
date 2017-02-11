package com.adview.ads;

import android.content.Context;
import android.util.AttributeSet;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;

import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Darshan on 2/10/2017.
 */

public class FullscreenAd extends FrameLayout {
    public TextView textView;
    private WebView webview;

    public FullscreenAd(Context context) {
        super(context);
        if(!isInEditMode()){
            init(context);
        }
    }

    public FullscreenAd(Context context, AttributeSet attrs) {
        super(context, attrs);
        if(!isInEditMode()){

            init(context);
        }
    }

    public FullscreenAd(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if(!isInEditMode()){

            init(context);
        }
    }

    public FullscreenAd(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        if(!isInEditMode()){

            init(context);
        }
    }

    public void init(Context context){
        webview=new WebView(context);

        // Create imageView params
        RelativeLayout.LayoutParams imageParams;
        imageParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT);

        imageParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);

        // Create imageView
        textView = new TextView(context);
        textView.setText("X");
        textView.setPadding(20,20,20,20);
        textView.setTextSize(20);
        textView.setTextColor(getResources().getColor(android.R.color.white));
        textView.setLayoutParams(imageParams);

        webview.getSettings().setJavaScriptEnabled(true);
        webview.setWebViewClient(new MyBrowser());
        addView(webview);
        addView(textView);
        closeAd();
    }

    public void loadUrl(String url){
        webview.loadUrl(url);
    }

    public void showAd(){
        setVisibility(VISIBLE);
    }

    public void closeAd(){
        setVisibility(GONE);
    }

    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

}
