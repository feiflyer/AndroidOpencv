package com.fast.flyer.opencv;

import android.app.Application;

import org.opencv.android.OpenCVLoader;

public class OpencvApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        OpenCVLoader.initDebug();
        System.loadLibrary("native-lib");
    }
}
