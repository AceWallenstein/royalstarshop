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
}
