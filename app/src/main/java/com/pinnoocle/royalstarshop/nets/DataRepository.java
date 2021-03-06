package com.pinnoocle.royalstarshop.nets;

import android.content.Context;

import com.pinnoocle.royalstarshop.bean.ImageModel;
import com.pinnoocle.royalstarshop.bean.LoginBean;

import java.util.Map;

import okhttp3.MultipartBody;
import rx.Observable;

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

    @Override
    public void sureOrder(Map<String, String> queryMap, getCallback callback) {
        mRemoteDataSource.sureOrder(queryMap, callback);

    }

    @Override
    public void orderCart(Map<String, String> queryMap, getCallback callback) {
        mRemoteDataSource.orderCart(queryMap, callback);
    }

    @Override
    public void vipGoods(Map<String, String> queryMap, getCallback callback) {
        mRemoteDataSource.vipGoods(queryMap, callback);
    }

    @Override
    public void buyNow(LoginBean loginBean, getCallback callback) {
        mRemoteDataSource.buyNow(loginBean, callback);
    }

    @Override
    public void buyNowCart(LoginBean loginBean, getCallback callback) {
        mRemoteDataSource.buyNowCart(loginBean, callback);
    }

    @Override
    public void commentList(LoginBean loginBean, getCallback callback) {
        mRemoteDataSource.commentList(loginBean, callback);
    }

    @Override
    public void orderList(LoginBean loginBean, getCallback callback) {
        mRemoteDataSource.orderList(loginBean, callback);
    }

    @Override
    public void collectList(LoginBean loginBean, getCallback callback) {
        mRemoteDataSource.collectList(loginBean, callback);
    }

    @Override
    public void delCollect(LoginBean loginBean, getCallback callback) {
        mRemoteDataSource.delCollect(loginBean, callback);
    }

    @Override
    public void changePhone(LoginBean loginBean, getCallback callback) {
        mRemoteDataSource.changePhone(loginBean, callback);
    }

    @Override
    public void orderCancel(LoginBean loginBean, getCallback callback) {
        mRemoteDataSource.orderCancel(loginBean, callback);
    }

    @Override
    public void orderReceipt(LoginBean loginBean, getCallback callback) {
        mRemoteDataSource.orderReceipt(loginBean, callback);
    }

    @Override
    public void refundLists(LoginBean loginBean, getCallback callback) {
        mRemoteDataSource.refundLists(loginBean, callback);
    }

    @Override
    public void orderDetail(LoginBean loginBean, getCallback callback) {
        mRemoteDataSource.orderDetail(loginBean, callback);
    }

    @Override
    public void changeInfo(LoginBean loginBean, getCallback callback) {
        mRemoteDataSource.changeInfo(loginBean, callback);
    }

    @Override
    public void addGoodsLog(LoginBean loginBean, getCallback callback) {
        mRemoteDataSource.addGoodsLog(loginBean, callback);
    }

    @Override
    public void scanList(LoginBean loginBean, getCallback callback) {
        mRemoteDataSource.scanList(loginBean, callback);
    }

    @Override
    public void backType(LoginBean loginBean, getCallback callback) {
        mRemoteDataSource.backType(loginBean, callback);
    }

    @Override
    public void feedback(LoginBean loginBean, getCallback callback) {
        mRemoteDataSource.feedback(loginBean, callback);
    }

    @Override
    public void question(LoginBean loginBean, getCallback callback) {
        mRemoteDataSource.question(loginBean, callback);
    }

    @Override
    public void vipInfo(LoginBean loginBean, getCallback callback) {
        mRemoteDataSource.vipInfo(loginBean, callback);
    }

    @Override
    public void vipOpen(LoginBean loginBean, getCallback callback) {
        mRemoteDataSource.vipOpen(loginBean, callback);
    }

    @Override
    public void feedbackList(LoginBean loginBean, getCallback callback) {
        mRemoteDataSource.feedbackList(loginBean, callback);
    }

    @Override
    public void bindParent(LoginBean loginBean, getCallback callback) {
        mRemoteDataSource.bindParent(loginBean, callback);
    }

    @Override
    public void money(LoginBean loginBean, getCallback callback) {
        mRemoteDataSource.money(loginBean, callback);
    }

    @Override
    public void comment(LoginBean loginBean, getCallback callback) {
        mRemoteDataSource.comment(loginBean, callback);
    }

    @Override
    public void moneyList(LoginBean loginBean, getCallback callback) {
        mRemoteDataSource.moneyList(loginBean, callback);
    }

    @Override
    public void userPointsLog(LoginBean loginBean, getCallback callback) {
        mRemoteDataSource.userPointsLog(loginBean, callback);
    }

    @Override
    public void vipIndex(LoginBean loginBean, getCallback callback) {
        mRemoteDataSource.vipIndex(loginBean, callback);
    }

    @Override
    public void getVipGoods(LoginBean loginBean, getCallback callback) {
        mRemoteDataSource.getVipGoods(loginBean, callback);
    }

    @Override
    public void getAddressDefault(LoginBean loginBean, getCallback callback) {
        mRemoteDataSource.getAddressDefault(loginBean, callback);
    }

    @Override
    public void myComments(LoginBean loginBean, getCallback callback) {
        mRemoteDataSource.myComments(loginBean, callback);
    }

    @Override
    public void erCode(LoginBean loginBean, getCallback callback) {
        mRemoteDataSource.erCode(loginBean, callback);
    }

    @Override
    public void poster(LoginBean loginBean, getCallback callback) {
        mRemoteDataSource.poster(loginBean, callback);
    }

    @Override
    public void orderPay(LoginBean loginBean, getCallback callback) {
        mRemoteDataSource.orderPay(loginBean, callback);
    }

    @Override
    public void applyRefund(LoginBean loginBean, getCallback callback) {
        mRemoteDataSource.applyRefund(loginBean, callback);
    }

    @Override
    public void refundDetail(LoginBean loginBean, getCallback callback) {
        mRemoteDataSource.refundDetail(loginBean, callback);
    }

    @Override
    public void recommendSearch(LoginBean loginBean, getCallback callback) {
        mRemoteDataSource.recommendSearch(loginBean, callback);
    }

    @Override
    public void buyVipGoods(LoginBean loginBean, getCallback callback) {
        mRemoteDataSource.buyVipGoods(loginBean, callback);
    }

    @Override
    public void withdraw(LoginBean loginBean, getCallback callback) {
        mRemoteDataSource.withdraw(loginBean, callback);
    }

    @Override
    public void returnAddress(LoginBean loginBean, getCallback callback) {
        mRemoteDataSource.returnAddress(loginBean, callback);
    }

    @Override
    public void refundDelivery(LoginBean loginBean, getCallback callback) {
        mRemoteDataSource.refundDelivery(loginBean, callback);
    }

    @Override
    public void isBind(LoginBean loginBean, getCallback callback) {
        mRemoteDataSource.isBind(loginBean, callback);
    }

    @Override
    public void bindWx(LoginBean loginBean, getCallback callback) {
        mRemoteDataSource.bindWx(loginBean, callback);
    }

    @Override
    public void withdrawSetting(LoginBean loginBean, getCallback callback) {
        mRemoteDataSource.withdrawSetting(loginBean, callback);
    }

    @Override
    public void messageCount(LoginBean loginBean, getCallback callback) {
        mRemoteDataSource.messageCount(loginBean, callback);
    }

    @Override
    public void messageList(LoginBean loginBean, getCallback callback) {
        mRemoteDataSource.messageList(loginBean, callback);
    }

    @Override
    public void messageDetail(LoginBean loginBean, getCallback callback) {
        mRemoteDataSource.messageDetail(loginBean, callback);
    }

    @Override
    public void refundCancel(LoginBean loginBean, getCallback callback) {
        mRemoteDataSource.refundCancel(loginBean, callback);
    }

    @Override
    public void exchangeVip(LoginBean loginBean, getCallback callback) {
        mRemoteDataSource.exchangeVip(loginBean, callback);
    }

    @Override
    public void withdrawLists(LoginBean loginBean, getCallback callback) {
        mRemoteDataSource.withdrawLists(loginBean, callback);
    }

    @Override
    public void image(String wxappid, String token, MultipartBody.Part file, getCallback callback) {
        mRemoteDataSource.image(wxappid, token, file, callback);
    }

    @Override
    public Observable<ImageModel> imageObservable(String wxappid, String token, MultipartBody.Part file) {
        return mRemoteDataSource.imageObservable(wxappid, token, file);
    }

}
