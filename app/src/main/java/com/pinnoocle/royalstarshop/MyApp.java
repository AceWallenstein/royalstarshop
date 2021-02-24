package com.pinnoocle.royalstarshop;

import android.app.Application;

import com.pedaily.yc.ycdialoglib.toast.ToastUtils;
import com.pinnoocle.royalstarshop.utils.FastData;

public class MyApp extends Application {
    public static MyApp sInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        ToastUtils.init(this);
        sInstance = this;
        FastData.getInstance();
    }

    public static MyApp getInstance() {
        return sInstance;
    }
}
