package com.pinnoocle.royalstarshop.nets;

import com.pinnoocle.royalstarshop.bean.LoginBean;

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
}
