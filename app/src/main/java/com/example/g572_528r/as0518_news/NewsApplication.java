package com.example.g572_528r.as0518_news;

import android.app.Application;

import cn.bmob.v3.Bmob;

/**
 * Created by g572-528r on 2017/5/23.
 */

public class NewsApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Bmob.initialize(this, "f0ba8d761f9cbe72ca39483338774a6c");
    }
}
