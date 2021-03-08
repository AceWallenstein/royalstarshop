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

    @Override
    public void index(LoginBean loginBean, getCallback callback) {
        mRemoteDataSource.index(loginBean, callback);
    }

    @Override
    public void addressLists(LoginBean loginBean, getCallback callback) {
        mRemoteDataSource.addressLists(loginBean, callback);
    }

    @Override
    public void setDefault(LoginBean loginBean, getCallback callback) {
        mRemoteDataSource.setDefault(loginBean, callback);
    }

    @Override
    public void addressDelete(LoginBean loginBean, getCallback callback) {
        mRemoteDataSource.addressDelete(loginBean, callback);
    }

    @Override
    public void addressAdd(LoginBean loginBean, getCallback callback) {
        mRemoteDataSource.addressAdd(loginBean, callback);
    }

    @Override
    public void addressEdit(LoginBean loginBean, getCallback callback) {
        mRemoteDataSource.addressEdit(loginBean, callback);
    }

    @Override
    public void goodsLists(LoginBean loginBean, getCallback callback) {
        mRemoteDataSource.goodsLists(loginBean, callback);
    }

    @Override
    public void banner(LoginBean loginBean, getCallback callback) {
        mRemoteDataSource.banner(loginBean, callback);
    }

    @Override
    public void home(LoginBean loginBean, getCallback callback) {
        mRemoteDataSource.home(loginBean, callback);
    }

    @Override
    public void categoryList(LoginBean loginBean, getCallback callback) {
        mRemoteDataSource.categoryList(loginBean, callback);
    }

    @Override
    public void getSubCategory(LoginBean loginBean, getCallback callback) {
        mRemoteDataSource.getSubCategory(loginBean, callback);
    }

    @Override
    public void cartAdd(LoginBean loginBean, getCallback callback) {
        mRemoteDataSource.cartAdd(loginBean, callback);
    }

    @Override
    public void cartLists(LoginBean loginBean, getCallback callback) {
        mRemoteDataSource.cartLists(loginBean, callback);
    }

    @Override
    public void cartChangeNums(LoginBean loginBean, getCallback callback) {
        mRemoteDataSource.cartChangeNums(loginBean, callback);
    }

    @Override
    public void cartDelete(LoginBean loginBean, getCallback callback) {
        mRemoteDataSource.cartDelete(loginBean, callback);
    }

    @Override
    public void goodsDetail(LoginBean loginBean, getCallback callback) {
        mRemoteDataSource.goodsDetail(loginBean, callback);
    }

    @Override
    public void goodsCollect(LoginBean loginBean, getCallback callback) {
        mRemoteDataSource.goodsCollect(loginBean, callback);
    }

    @Override
    public void userDetail(LoginBean loginBean, getCallback callback) {
        mRemoteDataSource.userDetail(loginBean, callback);
    }
}
