package com.ostaframework.utils;

import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.Display;

/**
 * Created by farzad.sarseify on 07/02/2017.
 */

public class DisplayUtils {


    /**
     * Used to give us height of screen
     *
     * @param activity activity context
     */
    public static int getHeight(Activity activity) {

        Display display = activity.getWindowManager().getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics ();
        display.getMetrics(outMetrics);

        float density  = activity.getResources().getDisplayMetrics().density;
        float dpHeight = outMetrics.heightPixels / density;
        float dpWidth  = outMetrics.widthPixels / density;

        return (int)dpHeight;
    }

    /**
     * Used to give us width of screen
     *
     * @param activity activity context
     */
    public static int getWidth(Activity activity) {


        Display display = activity.getWindowManager().getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics ();
        display.getMetrics(outMetrics);

        float density  = activity.getResources().getDisplayMetrics().density;
        float dpHeight = outMetrics.heightPixels / density;
        float dpWidth  = outMetrics.widthPixels / density;

        return (int)dpWidth;
    }
    /**
     * Used to give us height PX of screen
     *
     * @param activity activity context
     */
    public static int getHeightPixels(Activity activity){

        DisplayMetrics displaymetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        return displaymetrics.heightPixels;
    }

    /**
     * Used to give us width PX of screen
     *
     * @param activity activity context
     */
    public static int getWidthPixels(Activity activity){

        DisplayMetrics displaymetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        return displaymetrics.widthPixels;
    }

}
