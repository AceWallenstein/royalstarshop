package com.pinnoocle.royalstarshop.nets;


import android.content.Context;

import com.pinnoocle.royalstarshop.bean.AddressListModel;
import com.pinnoocle.royalstarshop.bean.CodeModel;
import com.pinnoocle.royalstarshop.bean.IndexModel;
import com.pinnoocle.royalstarshop.bean.LoginBean;
import com.pinnoocle.royalstarshop.bean.LoginModel;
import com.pinnoocle.royalstarshop.bean.ResultModel;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by whs on 2017/5/18
 */

public class RemotDataSourceImpl implements RemotDataSource {

    private static Context mContext;

    private static class Laydz {
        private static RemotDataSourceImpl instance = new RemotDataSourceImpl();
    }


    public static RemotDataSourceImpl getInstance(Context context) {
        mContext = context;
        return Laydz.instance;
    }

    @Override
    public void reg(LoginBean loginBean, final getCallback callback) {
        Observable<LoginModel> observable = RetrofitHelper.getInstance(mContext).getServer().reg(loginBean);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginModel>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(LoginModel s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void getCode(LoginBean loginBean, final getCallback callback) {
        Observable<CodeModel> observable = RetrofitHelper.getInstance(mContext).getServer().getCode(loginBean);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CodeModel>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(CodeModel s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void index(LoginBean loginBean, final getCallback callback) {
        Observable<IndexModel> observable = RetrofitHelper.getInstance(mContext).getServer().index(loginBean);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<IndexModel>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(IndexModel s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void addressLists(LoginBean loginBean, getCallback callback) {
        Observable<AddressListModel> observable = RetrofitHelper.getInstance(mContext).getServer().addressLists(loginBean);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<AddressListModel>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(AddressListModel s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void setDefault(LoginBean loginBean, getCallback callback) {
        Observable<ResultModel> observable = RetrofitHelper.getInstance(mContext).getServer().setDefault(loginBean);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResultModel>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(ResultModel s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void addressDelete(LoginBean loginBean, getCallback callback) {
        Observable<ResultModel> observable = RetrofitHelper.getInstance(mContext).getServer().addressDelete(loginBean);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResultModel>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(ResultModel s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void addressAdd(LoginBean loginBean, getCallback callback) {
        Observable<ResultModel> observable = RetrofitHelper.getInstance(mContext).getServer().addressAdd(loginBean);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResultModel>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(ResultModel s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void addressEdit(LoginBean loginBean, getCallback callback) {
        Observable<ResultModel> observable = RetrofitHelper.getInstance(mContext).getServer().addressEdit(loginBean);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResultModel>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(ResultModel s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }
}
