package com.adview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.adview.ads.BannerAd;
import com.adview.ads.FullscreenAd;

public class MainActivity extends AppCompatActivity {

    private Button btnShowFullId;
    private FullscreenAd adFullScreen;
    public String url="";
    private BannerAd bannerAd;

    String fullScreenAdUrl="http://192.168.88.251/banner/call_fbanner.php";
    String bannerAdUrl="http://192.168.88.251/banner/call_banner.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShowFullId=(Button)findViewById(R.id.btn_show_full_ad);
        adFullScreen=(FullscreenAd)findViewById(R.id.ads_full_screen);
        bannerAd=(BannerAd)findViewById(R.id.banner_ad);

        bannerAd.loadUrl(bannerAdUrl);
        adFullScreen.loadUrl(fullScreenAdUrl);

        btnShowFullId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adFullScreen.showAd();
                btnShowFullId.setVisibility(View.GONE);
            }
        });

        adFullScreen.btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adFullScreen.closeAd();
                btnShowFullId.setVisibility(View.VISIBLE);
            }
        });
    }
}
