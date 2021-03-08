package com.pinnoocle.royalstarshop.nets;

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
import com.pinnoocle.royalstarshop.bean.UserDetailModel;

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
    @POST("api/address/lists")
    Observable<AddressListModel> addressLists(@Body LoginBean loginBean);

    // 设为默认地址
    @POST("api/address/setDefault")
    Observable<ResultModel> setDefault(@Body LoginBean loginBean);

    // 删除收货地址
    @POST("api/address/delete")
    Observable<ResultModel> addressDelete(@Body LoginBean loginBean);

    // 添加收货地址
    @POST("api/address/add")
    Observable<ResultModel> addressAdd(@Body LoginBean loginBean);

    //修改收货地址
    @POST("api/address/edit")
    Observable<ResultModel> addressEdit(@Body LoginBean loginBean);

    //商品列表
    @POST("api/goods/lists")
    Observable<GoodsListsModel> goodsLists(@Body LoginBean loginBean);

    //banner列表
    @POST("api/index/banner")
    Observable<BannerModel> banner(@Body LoginBean loginBean);

    //首页商品
    @POST("api/index/index")
    Observable<HomeModel> home(@Body LoginBean loginBean);
    //二级分类列表
    @POST("api/category/index")
    Observable<CategoryListModel> categoryList(@Body LoginBean loginBean);
    //子分类
    @POST("api/category/getSubCategory")
    Observable<SubCategoryModel> getSubCategory(@Body LoginBean loginBean);
    //加入购物车
    @POST("api/cart/add")
    Observable<CartAddModel> cartAdd(@Body LoginBean loginBean);
    //购物车列表
    @POST("api/cart/lists")
    Observable<CartListsModel> cartLists(@Body LoginBean loginBean);
    //修改购物车商品数量
    @POST("api/cart/sub")
    Observable<ResultModel> cartChangeNums(@Body LoginBean loginBean);
    //删除购物车商品
    @POST("api/cart/delete")
    Observable<ResultModel> cartDelete(@Body LoginBean loginBean);
    //商品详情
    @POST("api/goods/detail")
    Observable<GoodsDetailModel> goodsDetail(@Body LoginBean loginBean);
    //收藏商品
    @POST("api/user.collect/add")
    Observable<ResultModel> goodsCollect(@Body LoginBean loginBean);

    //用户信息
    @POST("/api/user.index/detail")
    Observable<UserDetailModel> userDetail(@Body LoginBean loginBean);


}
