package com.pinnoocle.royalstarshop.nets;

import com.pinnoocle.royalstarshop.bean.AddressDefaultModel;
import com.pinnoocle.royalstarshop.bean.AddressListModel;
import com.pinnoocle.royalstarshop.bean.BackTypeModel;
import com.pinnoocle.royalstarshop.bean.BannerModel;
import com.pinnoocle.royalstarshop.bean.CartAddModel;
import com.pinnoocle.royalstarshop.bean.CartListsModel;
import com.pinnoocle.royalstarshop.bean.CategoryListModel;
import com.pinnoocle.royalstarshop.bean.CodeModel;
import com.pinnoocle.royalstarshop.bean.CollectListModel;
import com.pinnoocle.royalstarshop.bean.CommentListModel;
import com.pinnoocle.royalstarshop.bean.CommentModel;
import com.pinnoocle.royalstarshop.bean.ErCodeModel;
import com.pinnoocle.royalstarshop.bean.FeedbackListModel;
import com.pinnoocle.royalstarshop.bean.GoodsDetailModel;
import com.pinnoocle.royalstarshop.bean.GoodsListsModel;
import com.pinnoocle.royalstarshop.bean.HomeModel;
import com.pinnoocle.royalstarshop.bean.ImageModel;
import com.pinnoocle.royalstarshop.bean.IndexModel;
import com.pinnoocle.royalstarshop.bean.LoginBean;
import com.pinnoocle.royalstarshop.bean.MessageCountModel;
import com.pinnoocle.royalstarshop.bean.MessageDetailModel;
import com.pinnoocle.royalstarshop.bean.MessageListModel;
import com.pinnoocle.royalstarshop.bean.MoneyListModel;
import com.pinnoocle.royalstarshop.bean.MoneyModel;
import com.pinnoocle.royalstarshop.bean.OrderDetailModel;
import com.pinnoocle.royalstarshop.bean.OrderCartModel;
import com.pinnoocle.royalstarshop.bean.OrderListModel;
import com.pinnoocle.royalstarshop.bean.OrderPayModel;
import com.pinnoocle.royalstarshop.bean.PayStatusModel;
import com.pinnoocle.royalstarshop.bean.PointsModel;
import com.pinnoocle.royalstarshop.bean.PosterModel;
import com.pinnoocle.royalstarshop.bean.QuestionModel;
import com.pinnoocle.royalstarshop.bean.RecommendSearchModel;
import com.pinnoocle.royalstarshop.bean.RefundCancelModel;
import com.pinnoocle.royalstarshop.bean.RefundDetailModel;
import com.pinnoocle.royalstarshop.bean.RefundListsModel;
import com.pinnoocle.royalstarshop.bean.ResultModel;
import com.pinnoocle.royalstarshop.bean.ReturnAddressModel;
import com.pinnoocle.royalstarshop.bean.ScanListModel;
import com.pinnoocle.royalstarshop.bean.StatusModel;
import com.pinnoocle.royalstarshop.bean.SubCategoryModel;
import com.pinnoocle.royalstarshop.bean.SureOrderModel;
import com.pinnoocle.royalstarshop.bean.UserDetailModel;
import com.pinnoocle.royalstarshop.bean.VipGoodsModel;
import com.pinnoocle.royalstarshop.bean.VipIndexModel;
import com.pinnoocle.royalstarshop.bean.VipInfoModel;
import com.pinnoocle.royalstarshop.bean.VipOpenModel;
import com.pinnoocle.royalstarshop.bean.WithdrawListsModel;
import com.pinnoocle.royalstarshop.bean.WithdrawSettingModel;
import com.pinnoocle.royalstarshop.bean.WxPayResultModel;

import java.util.Map;

import okhttp3.MultipartBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by whs on 2017/2/17
 * Retrofit 接口
 */

public interface RetrofitService {
    // 登录注册
    @POST("api/user/reg")
    Observable<StatusModel> reg(@Body LoginBean loginBean);

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
    @POST("api/user.index/detail")
    Observable<UserDetailModel> userDetail(@Body LoginBean loginBean);

    //立即购买确认订单/提交订单
    @GET("api/order/buyNow")
    Observable<SureOrderModel> sureOrder(@QueryMap Map<String, String> queryMap);

    //购物车购买
    @GET("api/order/cart")
    Observable<OrderCartModel> orderCart(@QueryMap Map<String, String> queryMap);

    //立即购买确认订单/提交订单
    @POST("api/order/buyNow")
    Observable<WxPayResultModel> buyNow(@Body LoginBean loginBean);

    //购物车购买
    @POST("api/order/cart")
    Observable<WxPayResultModel> buyNowCart(@Body LoginBean loginBean);

    //商品评价列表
    @POST("api/comment/lists")
    Observable<CommentListModel> commentList(@Body LoginBean loginBean);

    //订单列表
    @POST("api/user.order/lists")
    Observable<OrderListModel> orderList(@Body LoginBean loginBean);

    //收藏列表
    @POST("api/user.collect/lists")
    Observable<CollectListModel> collectList(@Body LoginBean loginBean);

    //取消收藏商品
    @POST("api/user.collect/del")
    Observable<ResultModel> delCollect(@Body LoginBean loginBean);

    //修改手机号
    @POST("api/user/changePhone")
    Observable<StatusModel> changePhone(@Body LoginBean loginBean);

    //修改用户信息
    @POST("api/user.index/changeInfo")
    Observable<ResultModel> changeInfo(@Body LoginBean loginBean);

    //上传图片
    @Multipart
    @POST("api/upload/image")
    Observable<ImageModel> image(@Query("wxapp_id") String wxappid, @Query("token") String token, @Part MultipartBody.Part file);

    //订单详情
    @POST("api/user.order/detail")
    Observable<OrderDetailModel> orderDetail(@Body LoginBean loginBean);

    //取消订单
    @POST("api/user.order/cancel")
    Observable<StatusModel> orderCancel(@Body LoginBean loginBean);

    //取消订单
    @POST("api/user.order/receipt")
    Observable<StatusModel> orderReceipt(@Body LoginBean loginBean);

    //售后单列表
    @POST("api/user.refund/lists")
    Observable<RefundListsModel> refundLists(@Body LoginBean loginBean);

    //商品浏览记录
    @POST("api/user.index/addGoodsLog")
    Observable<ResultModel> addGoodsLog(@Body LoginBean loginBean);

    //商品浏览记录列表
    @POST("api/user.index/scanList")
    Observable<ScanListModel> scanList(@Body LoginBean loginBean);

    //常见问题
    @POST("api/index/question")
    Observable<QuestionModel> question(@Body LoginBean loginBean);

    //反馈类型
    @POST("api/index/backType")
    Observable<BackTypeModel> backType(@Body LoginBean loginBean);

    //添加反馈
    @POST("api/user.feedback/feedback")
    Observable<StatusModel> feedback(@Body LoginBean loginBean);

    //反馈列表
    @POST("api/user.feedback/lists")
    Observable<FeedbackListModel> feedbackList(@Body LoginBean loginBean);

    //会员套餐
    @POST("api/vip/info")
    Observable<VipInfoModel> vipInfo(@Body LoginBean loginBean);

    //开通会员
    @POST("api/vip/vip")
    Observable<VipOpenModel> vipOpen(@Body LoginBean loginBean);

    //用户注册接口
    @POST("api/user/bindParent")
    Observable<ResultModel> bindParent(@Body LoginBean loginBean);

    //推荐收益
    @POST("api/user.index/money")
    Observable<MoneyModel> money(@Body LoginBean loginBean);

    //收益明细
    @POST("api/user.dealer.order/lists")
    Observable<MoneyListModel> moneyList(@Body LoginBean loginBean);

    //添加商品评价
    @POST("api/user.comment/order")
    Observable<StatusModel> comment(@Body LoginBean loginBean);

    //用户金豆明细
    @POST("api/user.index/userPointsLog")
    Observable<PointsModel> userPointsLog(@Body LoginBean loginBean);

    //我的评价记录
    @POST("api/user.index/comment")
    Observable<CommentModel> myComments(@Body LoginBean loginBean);


    //会员中心商品
    @POST("api/vip/index")
    Observable<VipIndexModel> vipIndex(@Body LoginBean loginBean);

    //会员权益商品
    @POST("api/index/getVipGoods")
    Observable<VipGoodsModel> getVipGoods(@Body LoginBean loginBean);

    //获取默认地址
    @POST("api/address/getDefault")
    Observable<AddressDefaultModel> getAddressDefault(@Body LoginBean loginBean);

    //我的邀请
    @POST("api/vip/ercode")
    Observable<ErCodeModel> erCode(@Body LoginBean loginBean);

    //海报
    @POST("api/vip/poster")
    Observable<PosterModel> poster(@Body LoginBean loginBean);

    //订单支付
    @POST("api/user.order/pay")
    Observable<OrderPayModel> orderPay(@Body LoginBean loginBean);

    //申请售后
    @POST("api/user.refund/apply")
    Observable<ResultModel> applyRefund(@Body LoginBean loginBean);

    //售后详情
    @POST("api/user.refund/detail")
    Observable<RefundDetailModel> refundDetail(@Body LoginBean loginBean);

    //推荐搜索
    @POST("api/index/recommendSearch")
    Observable<RecommendSearchModel> recommendSearch(@Body LoginBean loginBean);

    //获取会员权益商品
    @GET("api/order/vipGoods")
    Observable<SureOrderModel> vipGoods(@QueryMap Map<String, String> queryMap);

    //购买会员权益商品
    @POST("api/order/vipGoods")
    Observable<PayStatusModel> buyVipGoods(@Body LoginBean loginBean);

    //提现申请
    @POST("api/user.dealer.withdraw/submit")
    Observable<StatusModel> withdraw(@Body LoginBean loginBean);

    //退货收货地址
    @POST("api/return_address/lists")
    Observable<ReturnAddressModel> returnAddress(@Body LoginBean loginBean);

    //用户发货
    @POST("api/user.refund/delivery")
    Observable<StatusModel> refundDelivery(@Body LoginBean loginBean);

    //是否绑定
    @POST("api/user/isBind")
    Observable<StatusModel> isBind(@Body LoginBean loginBean);

    //绑定微信
    @POST("api/user/bindWx")
    Observable<StatusModel> bindWx(@Body LoginBean loginBean);

    //提现规则
    @POST("api/withdraw/setting")
    Observable<WithdrawSettingModel> withdrawSetting(@Body LoginBean loginBean);

    //消息统计
    @POST("api/message/count")
    Observable<MessageCountModel> messageCount(@Body LoginBean loginBean);

    //消息列表
    @POST("api/message/lists")
    Observable<MessageListModel> messageList(@Body LoginBean loginBean);

    //消息详情
    @POST("api/message/detail")
    Observable<MessageDetailModel> messageDetail(@Body LoginBean loginBean);

    //取消申请售后
    @POST("api/user.refund/cancel")
    Observable<StatusModel> refundCancel(@Body LoginBean loginBean);

    //会员兑换
    @POST("api/user/exchangeVip")
    Observable<StatusModel> exchangeVip(@Body LoginBean loginBean);

    //提现明细
    @POST("api/user.dealer.withdraw/lists")
    Observable<WithdrawListsModel> withdrawLists(@Body LoginBean loginBean);




}
