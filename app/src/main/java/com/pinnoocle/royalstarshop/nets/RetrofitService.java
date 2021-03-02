package com.pinnoocle.royalstarshop.nets;

import com.pinnoocle.royalstarshop.bean.AddressListModel;
import com.pinnoocle.royalstarshop.bean.CodeModel;
import com.pinnoocle.royalstarshop.bean.IndexModel;
import com.pinnoocle.royalstarshop.bean.LoginBean;
import com.pinnoocle.royalstarshop.bean.LoginModel;
import com.pinnoocle.royalstarshop.bean.ResultModel;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by whs on 2017/2/17
 * Retrofit 接口
 */

public interface RetrofitService {
    // 登录注册
    @POST("api/user/reg")
    Observable<LoginModel> reg(@Body LoginBean loginBean);

    // 发送验证码
    @POST("api/user/getCode")
    Observable<CodeModel> getCode(@Body LoginBean loginBean);

    // 分类列表
    @POST("api/category/index")
    Observable<IndexModel> index(@Body LoginBean loginBean);

    // 收货地址列表
    @POST("api/category/index")
    Observable<AddressListModel> addressLists(@Body LoginBean loginBean);

    // 设为默认地址
    @POST("api/address/setDefault")
    Observable<ResultModel> setDefault(@Body LoginBean loginBean);

    // 删除收货地址
    @POST("api/address/setDefault")
    Observable<ResultModel> addressDelete(@Body LoginBean loginBean);

    // 添加收货地址
    @POST("api/address/add")
    Observable<ResultModel> addressAdd(@Body LoginBean loginBean);
}
