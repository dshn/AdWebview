package com.adview.ads;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;

import android.view.ViewGroup;
import android.view.WindowManager;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;


/**
 * Created by Darshan on 2/10/2017.
 */

public class BannerAd extends FrameLayout {
    private int height;
    private int width;
    private WebView webview;

    public BannerAd(Context context) {
        super(context);
        if(!isInEditMode()){
            deviceHeightWidth(context);
            init(context);
        }
    }

    public BannerAd(Context context, AttributeSet attrs) {
        super(context, attrs);
        if(!isInEditMode()){
            deviceHeightWidth(context);
            init(context);
        }
    }

    public BannerAd(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if(!isInEditMode()){
            deviceHeightWidth(context);
            init(context);
        }
    }

    public BannerAd(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        if(!isInEditMode()){
            deviceHeightWidth(context);
            init(context);
        }
    }

    public void init(Context context){
        // Create imageView params
        RelativeLayout.LayoutParams imageParams = null;

        //https://firebase.google.com/docs/admob/android/banner

        imageParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        /*if(height<=400){
            imageParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, dpToPx(32));
        }else if(height> 400 && height <= 720){
            imageParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, dpToPx(50));
        }else if(height>720){
            imageParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, dpToPx(90));
        }*/
      //  imageParams = new RelativeLayout.LayoutParams(width, height/8);
        imageParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        imageParams.addRule(RelativeLayout.CENTER_HORIZONTAL);

        webview=new WebView(context);

        webview.setLayoutParams(imageParams);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.setWebViewClient(new MyBrowser());

        addView(webview);

    }

    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

    public void loadUrl(String url){
        webview.loadUrl(url);
    }

    public void deviceHeightWidth(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics displaymetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(displaymetrics);

        height =Math.round(displaymetrics.heightPixels / (displaymetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
        width = Math.round(displaymetrics.widthPixels / (displaymetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
    }

    public int dpToPx(int dp) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        return Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
    }
    public int pxToDp(int px) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        return Math.round(px / (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
    }


}
