package com.theappexperts.aee2;

import android.app.Application;
import android.content.Context;

/**
 * Created by TheAppExperts on 26/11/2017.
 */

public class MyApp extends Application {
    public static Application sApplication;

    public static Application getApplication() {
        return sApplication;
    }

    public static Context getContext() {
        return getApplication().getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sApplication = this;
    }
}
