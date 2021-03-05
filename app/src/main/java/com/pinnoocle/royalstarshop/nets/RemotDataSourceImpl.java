package com.pinnoocle.royalstarshop.nets;


import android.content.Context;

import com.pinnoocle.royalstarshop.bean.AddressListModel;
import com.pinnoocle.royalstarshop.bean.BannerModel;
import com.pinnoocle.royalstarshop.bean.CartAddModel;
import com.pinnoocle.royalstarshop.bean.CartListsModel;
import com.pinnoocle.royalstarshop.bean.CategoryListModel;
import com.pinnoocle.royalstarshop.bean.CodeModel;
import com.pinnoocle.royalstarshop.bean.GoodsDetailModel;
import com.pinnoocle.royalstarshop.bean.GoodsListsModel;
import com.pinnoocle.royalstarshop.bean.HomeModel;
import com.pinnoocle.royalstarshop.bean.IndexModel;
import com.pinnoocle.royalstarshop.bean.LoginBean;
import com.pinnoocle.royalstarshop.bean.LoginModel;
import com.pinnoocle.royalstarshop.bean.ResultModel;
import com.pinnoocle.royalstarshop.bean.SubCategoryModel;

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

    @Override
    public void goodsLists(LoginBean loginBean, getCallback callback) {
        Observable<GoodsListsModel> observable = RetrofitHelper.getInstance(mContext).getServer().goodsLists(loginBean);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GoodsListsModel>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(GoodsListsModel s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void banner(LoginBean loginBean, getCallback callback) {
        Observable<BannerModel> observable = RetrofitHelper.getInstance(mContext).getServer().banner(loginBean);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BannerModel>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(BannerModel s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void home(LoginBean loginBean, getCallback callback) {
        Observable<HomeModel> observable = RetrofitHelper.getInstance(mContext).getServer().home(loginBean);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HomeModel>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(HomeModel s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void categoryList(LoginBean loginBean, getCallback callback) {
        Observable<CategoryListModel> observable = RetrofitHelper.getInstance(mContext).getServer().categoryList(loginBean);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CategoryListModel>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(CategoryListModel s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void getSubCategory(LoginBean loginBean, getCallback callback) {
        Observable<SubCategoryModel> observable = RetrofitHelper.getInstance(mContext).getServer().getSubCategory(loginBean);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SubCategoryModel>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(SubCategoryModel s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void cartAdd(LoginBean loginBean, getCallback callback) {
        Observable<CartAddModel> observable = RetrofitHelper.getInstance(mContext).getServer().cartAdd(loginBean);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CartAddModel>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(CartAddModel s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void cartLists(LoginBean loginBean, getCallback callback) {
        Observable<CartListsModel> observable = RetrofitHelper.getInstance(mContext).getServer().cartLists(loginBean);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CartListsModel>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(CartListsModel s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void cartChangeNums(LoginBean loginBean, getCallback callback) {
        Observable<ResultModel> observable = RetrofitHelper.getInstance(mContext).getServer().cartChangeNums(loginBean);
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
    public void cartDelete(LoginBean loginBean, getCallback callback) {
        Observable<ResultModel> observable = RetrofitHelper.getInstance(mContext).getServer().cartDelete(loginBean);
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
    public void goodsDetail(LoginBean loginBean, getCallback callback) {
        Observable<GoodsDetailModel> observable = RetrofitHelper.getInstance(mContext).getServer().goodsDetail(loginBean);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GoodsDetailModel>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(GoodsDetailModel s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }
}
