package com.pinnoocle.royalstarshop.nets;

import com.pinnoocle.royalstarshop.bean.LoginBean;

import java.util.Map;

import okhttp3.MultipartBody;

/**
 * Created by whs on 2017/6/7
 */

public interface RemotDataSource {
    interface getCallback {

        void onFailure(String info);

        void onSuccess(Object data);
    }

    void reg(LoginBean loginBean, getCallback callback);

    void getCode(LoginBean loginBean, getCallback callback);

    void index(LoginBean loginBean, getCallback callback);

    void addressLists(LoginBean loginBean, getCallback callback);

    void setDefault(LoginBean loginBean, getCallback callback);

    void addressDelete(LoginBean loginBean, getCallback callback);

    void addressAdd(LoginBean loginBean, getCallback callback);

    void addressEdit(LoginBean loginBean, getCallback callback);

    void goodsLists(LoginBean loginBean, getCallback callback);

    void banner(LoginBean loginBean, getCallback callback);

    void home(LoginBean loginBean, getCallback callback);

    void categoryList(LoginBean loginBean, getCallback callback);

    void getSubCategory(LoginBean loginBean, getCallback callback);

    void cartAdd(LoginBean loginBean, getCallback callback);

    void cartLists(LoginBean loginBean, getCallback callback);

    void cartChangeNums(LoginBean loginBean, getCallback callback);

    void cartDelete(LoginBean loginBean, getCallback callback);

    void goodsDetail(LoginBean loginBean, getCallback callback);

    void goodsCollect(LoginBean loginBean, getCallback callback);

    void userDetail(LoginBean loginBean, getCallback callback);

    void sureOrder(Map<String, String> queryMap, getCallback callback);

    void orderCart(Map<String, String> queryMap, getCallback callback);

    void buyNow(LoginBean loginBean, getCallback callback);

    void buyNowCart(LoginBean loginBean, getCallback callback);

    void commentList(LoginBean loginBean, getCallback callback);

    void orderList(LoginBean loginBean, getCallback callback);

    void collectList(LoginBean loginBean, getCallback callback);

    void delCollect(LoginBean loginBean, getCallback callback);

    void orderDetail(LoginBean loginBean, getCallback callback);

    void changePhone(LoginBean loginBean, getCallback callback);

    void orderCancel(LoginBean loginBean, getCallback callback);

    void orderReceipt(LoginBean loginBean, getCallback callback);

    void refundLists(LoginBean loginBean, getCallback callback);

    void changeInfo(LoginBean loginBean, getCallback callback);

    void addGoodsLog(LoginBean loginBean, getCallback callback);

    void scanList(LoginBean loginBean, getCallback callback);

    void backType(LoginBean loginBean, getCallback callback);

    void feedback(LoginBean loginBean, getCallback callback);

    void question(LoginBean loginBean, getCallback callback);

    void feedbackList(LoginBean loginBean, getCallback callback);

    void vipInfo(LoginBean loginBean, getCallback callback);

    void vipOpen(LoginBean loginBean, getCallback callback);

    void bindParent(LoginBean loginBean, getCallback callback);

    void money(LoginBean loginBean, getCallback callback);

    void comment(LoginBean loginBean, getCallback callback);

    void moneyList(LoginBean loginBean, getCallback callback);

    void userPointsLog(LoginBean loginBean, getCallback callback);
    void myComments(LoginBean loginBean, getCallback callback);

    void image(String wxappid, String token, MultipartBody.Part file, getCallback callback);

}
