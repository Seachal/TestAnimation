package com.seachal.util;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;

public class UiUtil {
    private static final String TAG =  "YanZi_UiUtil";
    private static int screenWidth = 0;
    private static int screenHeight = 0;
    private static float screenDensity = 0;
    private static int densityDpi = 0;
    private static int statusBarHeight = 0;



    public static void initialize(Context context){
        if (context == null)
            return;
        DisplayMetrics metrics = new DisplayMetrics();
        WindowManager wm = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(metrics);
        screenWidth = metrics.widthPixels;     // 屏幕宽度
        screenHeight = metrics.heightPixels;   // 屏幕高度
        screenDensity = metrics.density;      // 0.75 / 1.0 / 1.5 / 2.0 / 3.0
        densityDpi = metrics.densityDpi;  //120 160 240 320 480
        Log.i(TAG, "screenDensity = " + screenDensity + " densityDpi = " + densityDpi);
    }

    public static int dip2px(float dipValue){
        return (int)(dipValue * screenDensity + 0.5f);
    }

    public static int px2dip(float pxValue){

        return (int)(pxValue / screenDensity + 0.5f);
    }

    public static int getScreenWidth() {
        return screenWidth;
    }

    public static int getScreenHeight() {
        return screenHeight;
    }

}
