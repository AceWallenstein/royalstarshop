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

    //token
    public static void setToken(String token) {
        putString("token", token);
    }

    public static String getToken() {
        return getString("token", "");
    }

    //user_id
    public static void setUserId(int userId) {
        putInt("userId", userId);
    }

    public static int getUserId() {
        return getInt("userId", -1);
    }
}