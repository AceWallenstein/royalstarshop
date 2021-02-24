package com.pinnoocle.royalstarshop.utils;

import com.pinnoocle.royalstarshop.MyApp;

/**
 * Created by WS on 2019/1/4.
 */

public class FastData extends Remember {

    protected static Remember remember = null;

    private static final String SHARED_PREFS_NAME = "wineShop";

    public static synchronized Remember getInstance() {
        if (remember == null) {
            remember = init(MyApp.getInstance(), SHARED_PREFS_NAME);
        }
        return remember;
    }

    //设备id
    public static void setVolume(int volume) {
        putInt("volume", volume);
    }

    public static int getVolume() {
        return getInt("volume", -1);
    }

}