package com.zero1c03.mobile.requestmanager;

import android.support.multidex.MultiDexApplication;

/**
 * Created by zero1 on 2018/1/7.
 */

public class ApplicationController extends MultiDexApplication {

    private static ApplicationController instance;

    public static ApplicationController getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
}
