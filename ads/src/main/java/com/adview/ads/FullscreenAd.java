package com.adview.ads;

import android.content.Context;
import android.util.AttributeSet;

import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;

import android.widget.TextView;

/**
 * Created by Darshan on 2/10/2017.
 */

public class FullscreenAd extends FrameLayout {
    public TextView btnClose;
    private WebView webview;

    public FullscreenAd(Context context) {
        super(context);
        if (!isInEditMode()) {
            init(context);
        }
    }

    public FullscreenAd(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (!isInEditMode()) {
            init(context);
        }
    }

    public FullscreenAd(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if (!isInEditMode()) {
            init(context);
        }
    }


    public void init(Context context) {
        webview = new WebView(context);

       /* // Create imageView params
        RelativeLayout.LayoutParams imageParams;
        imageParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT);

        imageParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);*/

        LayoutParams params = new LayoutParams(
                LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT
        );

        //setting magin of close btn
        params.setMargins(10, 10, 10, 10);

        // Create imageView
        btnClose = new TextView(context);
        btnClose.setText("X");
        btnClose.setPadding(10, 10, 10, 10);
        btnClose.setTextSize(20);
        btnClose.setTextColor(getResources().getColor(android.R.color.white));
        btnClose.setBackgroundColor(getResources().getColor(android.R.color.black));
        btnClose.setLayoutParams(params);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.setWebViewClient(new MyBrowser());

        //disable only scrollbars and not scrolling
        webview.setVerticalScrollBarEnabled(false);
        webview.setHorizontalScrollBarEnabled(false);

        // disable scroll on touch
        webview.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return (event.getAction() == MotionEvent.ACTION_MOVE);
            }
        });
        addView(webview);
        addView(btnClose);
        closeAd();
    }

    /*
        load url to webview
     */
    public void loadUrl(String url) {
        webview.loadUrl(url);
    }

    /*
    makes the ad visible
     */
    public void showAd() {
        setVisibility(VISIBLE);
    }

    /*
    close the ad
     */
    public void closeAd() {
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
