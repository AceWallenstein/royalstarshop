package com.pinnoocle.royalstarshop;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.pedaily.yc.ycdialoglib.toast.ToastUtils;
import com.pinnoocle.royalstarshop.greendao.DaoMaster;
import com.pinnoocle.royalstarshop.greendao.DaoSession;
import com.pinnoocle.royalstarshop.utils.FastData;

public class MyApp extends Application {
    public static MyApp sInstance;
    public static final String DB_NAME = "rd.db";
    private DaoSession mDaoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        ToastUtils.init(this);
        sInstance = this;
        FastData.getInstance();
        setDatabase();
    }

    private void setDatabase() {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, DB_NAME, null);
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        mDaoSession = daoMaster.newSession();
    }

    public DaoSession getDaoSession() {
        return mDaoSession;
    }

    public static MyApp getInstance() {
        return sInstance;
    }
}
