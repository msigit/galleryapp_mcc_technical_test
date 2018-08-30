package com.mcc.galleryapp;

import android.app.Application;


/**
 * Created by MD Sahidul Islam on 12/2/2018.
 */
public class BaseApplication extends Application {

    private static BaseApplication baseApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        baseApplication = this;
    }

    public static synchronized BaseApplication getInstance() {
        return baseApplication;
    }
}
