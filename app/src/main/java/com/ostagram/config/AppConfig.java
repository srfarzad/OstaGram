package com.ostagram.config;

import android.app.Application;

import com.google.android.gms.ads.MobileAds;

public class AppConfig extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

       // MobileAds.initialize(this, "ca-app-pub-2705364357603073~2902176928");
        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");

    }
}
