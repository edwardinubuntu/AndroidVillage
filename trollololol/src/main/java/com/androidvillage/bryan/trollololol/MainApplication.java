package com.androidvillage.bryan.trollololol;

import android.app.Application;

import com.parse.Parse;

/**
 * Created by bryan on 2015/5/30.
 */
public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(this, "MtDKgcvM0QPWi9a5PxOpI7I3K2ZAbWdQfZzuo9sK", "rIcDSaJzjQfspENMZxL2cJ7IV8GBEJBUmFYfaG4l");

    }
}
