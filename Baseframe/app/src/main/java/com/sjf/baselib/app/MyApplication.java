package com.sjf.baselib.app;

import android.app.Application;
/**
 * Desc:
 * Created by sunjinfang on 2016/6/1 13:15.
 */
public class MyApplication extends Application{
    CrashHandler crashHandler ;
    @Override
    public void onCreate() {
        super.onCreate();
        crashHandler = new CrashHandler(this) ;
    }
}
