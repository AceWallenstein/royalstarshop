package com.pinnoocle.royalstarshop.nets;

import android.content.Context;

import com.pinnoocle.royalstarshop.bean.LoginBean;

/**
 * Created by whs on 2017/5/18
 */

public class DataRepository implements RemotDataSource {
    private Context mContext;

    private static DataRepository INSTANCE = null;


    private final RemotDataSourceImpl mRemoteDataSource;

    public static DataRepository getInstance(RemotDataSourceImpl remoteDataSource) {
        if (INSTANCE == null) {
            INSTANCE = new DataRepository(remoteDataSource);
        }
        return INSTANCE;
    }

    private DataRepository(RemotDataSourceImpl remoteDataSource) {
        //this.mContext=context;
        this.mRemoteDataSource = remoteDataSource;
    }

    @Override
    public void reg(LoginBean loginBean, getCallback callback) {
        mRemoteDataSource.reg(loginBean, callback);
    }

    @Override
    public void getCode(LoginBean loginBean, getCallback callback) {
        mRemoteDataSource.getCode(loginBean, callback);
    }
}
