package com.pinnoocle.royalstarshop.mine.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pedaily.yc.ycdialoglib.toast.ToastUtils;
import com.pinnoocle.royalstarshop.MyApp;
import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.adapter.OrderConfirmAdapter;
import com.pinnoocle.royalstarshop.bean.AddressDefaultModel;
import com.pinnoocle.royalstarshop.bean.AddressListModel;
import com.pinnoocle.royalstarshop.bean.LoginBean;
import com.pinnoocle.royalstarshop.bean.OrderCartModel;
import com.pinnoocle.royalstarshop.bean.SureOrderModel;
import com.pinnoocle.royalstarshop.bean.WxPayResultModel;
import com.pinnoocle.royalstarshop.common.BaseActivity;
import com.pinnoocle.royalstarshop.event.ShopCartRefreshEvent;
import com.pinnoocle.royalstarshop.nets.DataRepository;
import com.pinnoocle.royalstarshop.nets.Injection;
import com.pinnoocle.royalstarshop.nets.RemotDataSource;
import com.pinnoocle.royalstarshop.utils.FastData;
import com.tencent.mm.opensdk.modelpay.PayReq;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OrderConfirmActivity extends BaseActivity {
    @BindView(R.id.iv_bg)
    ImageView ivBg;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.tv_address)
    TextView tvAddress;
    @BindView(R.id.rl_address)
    RelativeLayout rlAddress;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.iv_weixin_pay)
    ImageView ivWeixinPay;
    @BindView(R.id.iv_alipay)
    ImageView ivAlipay;
    @BindView(R.id.tv_total)
    TextView tvTotal;
    @BindView(R.id.tv_total_price)
    TextView tvTotalPrice;
    @BindView(R.id.tv_discount)
    TextView tvDiscount;
    @BindView(R.id.tv_settlement)
    TextView tvSettlement;
    @BindView(R.id.rl_panel)
    RelativeLayout rlPanel;
    @BindView(R.id.iv_money)
    ImageView ivMoney;
    @BindView(R.id.tv_points_money)
    TextView tvPointsMoney;
    @BindView(R.id.rl_money)
    RelativeLayout rlMoney;
    @BindView(R.id.scrollView)
    NestedScrollView scrollView;
    @BindView(R.id.iv_use_points)
    ImageView ivUsePoints;
    private SureOrderModel.DataBean sureOrderData;
    private DataRepository dataRepository;

    private String address_id;
    private String pay_type = "20";
    private boolean flag = false;
    private String is_use_points = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initRed();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_confirm);
        ButterKnife.bind(this);
        initView();
        initData();
    }


    private void initView() {

    }

    private void initData() {
        dataRepository = Injection.dataRepository(this);
        if (getIntent().getSerializableExtra("sureOrderData") != null) {
            Serializable serializableExtra = getIntent().getSerializableExtra("sureOrderData");
            sureOrderData = (SureOrderModel.DataBean) serializableExtra;
            if (sureOrderData.getAddress() != null) {

                tvName.setText(sureOrderData.getAddress().getName());
                tvPhone.setText(sureOrderData.getAddress().getPhone());
                tvAddress.setText(sureOrderData.getAddress().getRegion().toString());
            } else {
                tvName.setText("暂无地址");
                tvAddress.setText("请选择配送地址");
            }
            tvDiscount.setText("抵扣平台货币"+sureOrderData.getPoints_money()+"元");
            tvTotalPrice.setText(sureOrderData.getOrder_pay_price());
            tvPointsMoney.setText("剩余可用平台货币" + sureOrderData.getUser_points() + "元");
            OrderConfirmAdapter adapter = new OrderConfirmAdapter(this);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            adapter.setData(sureOrderData.getGoods_list());
            recyclerView.setAdapter(adapter);

        }
        getAddressDefault();


    }

    private void getAddressDefault() {
        LoginBean loginBean = new LoginBean();
        loginBean.wxapp_id = "10001";
        loginBean.token = FastData.getToken();
        ViewLoading.show(this);
        dataRepository.getAddressDefault(loginBean, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(mContext);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(mContext);
                AddressDefaultModel addressDefaultModel = (AddressDefaultModel) data;
                if (addressDefaultModel.getCode() == 1) {
                    if (addressDefaultModel.getData() != null) {
                        tvName.setText(addressDefaultModel.getData().getName());
                        tvPhone.setText(addressDefaultModel.getData().getPhone());
                        tvAddress.setText(addressDefaultModel.getData().getRegion().toString());
                        address_id = addressDefaultModel.getData().getAddress_id() + "";
                    } else {
                        tvName.setText("暂无地址");
                        tvAddress.setText("请选择配送地址");
                        tvPhone.setText("");
                    }
                }
//                ToastUtils.showToast(wxPayResultModel.getMsg());
            }
        });
    }


    private void sureOrder() {
        Map<String, String> map = new HashMap<>();
        map.put("wxapp_id", "10001");
        map.put("token", FastData.getToken());
        map.put("goods_id", getIntent().getStringExtra("goods_id"));
        map.put("goods_sku_id", getIntent().getStringExtra("goods_sku_id"));
        map.put("goods_num", getIntent().getStringExtra("goods_num"));
        map.put("is_use_points", is_use_points);
        dataRepository.sureOrder(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {

            }

            @Override
            public void onSuccess(Object data) {
                SureOrderModel sureOrderModel = (SureOrderModel) data;
                sureOrderData = sureOrderModel.getData();
                if (sureOrderModel.getCode() == 1) {
                    tvDiscount.setText("抵扣平台货币"+sureOrderData.getPoints_money()+"元");
                    tvTotalPrice.setText(sureOrderData.getOrder_pay_price());
                    tvPointsMoney.setText("剩余可用平台货币" + sureOrderData.getPoints_money() + "元");
                    OrderConfirmAdapter adapter = new OrderConfirmAdapter(mContext);
                    recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
                    adapter.setData(sureOrderData.getGoods_list());
                    recyclerView.setAdapter(adapter);
                    EventBus.getDefault().post(new ShopCartRefreshEvent());
//                ToastUtils.showToast(sureOrderModel.getMsg());
                }
            }
        });
    }

    private void orderCart() {
        Map<String, String> map = new HashMap<>();
        map.put("wxapp_id", "10001");
        map.put("token", FastData.getToken());
        map.put("cart_ids", getIntent().getStringExtra("cart_ids"));
        map.put("is_use_points", is_use_points);
        ViewLoading.show(mContext);
        dataRepository.orderCart(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(mContext);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(mContext);
                OrderCartModel orderCartModel = (OrderCartModel) data;
                sureOrderData = orderCartModel.getData();
                if (orderCartModel.getCode() == 1) {
                    tvDiscount.setText("抵扣平台货币" + format(sureOrderData.getPoints_money() + "元"));
                    tvTotalPrice.setText(sureOrderData.getOrder_pay_price());
                    tvPointsMoney.setText("剩余可用平台货币" + format(sureOrderData.getUser_points() + "元"));
                    OrderConfirmAdapter adapter = new OrderConfirmAdapter(mContext);
                    recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
                    adapter.setData(sureOrderData.getGoods_list());
                    recyclerView.setAdapter(adapter);
                    EventBus.getDefault().post(new ShopCartRefreshEvent());
                }
//                ToastUtils.showToast(sureOrderModel.getMsg());
            }
        });
    }

    private String format(String result){
        DecimalFormat r=new DecimalFormat();
        r.applyPattern("#0.00");//保留小数位数，不足会补零
        return r.format(result);
    }


    /*
     map.put("wxapp_id", "10001");
        map.put("token", FastData.getToken());
        map.put("goods_id", dataBean.getDetail().getGoods_id() + "");
        map.put("goods_sku_id", goods_sku_id + "");
        map.put("goods_num", numberButton.getNumber() + "");
     */
    private void buyNow() {
        LoginBean loginBean = new LoginBean();
        loginBean.wxapp_id = "10001";
        loginBean.token = FastData.getToken();
        loginBean.goods_id = sureOrderData.getGoods_list().get(0).getGoods_id() + "";
        loginBean.goods_sku_id = sureOrderData.getGoods_list().get(0).getGoods_sku().getGoods_sku_id() + "";
        loginBean.goods_num = sureOrderData.getGoods_list().get(0).getTotal_num() + "";
        loginBean.pay_type = pay_type;              //微信支付 20 支付宝 10
        loginBean.address_id = address_id;
        loginBean.is_use_points = is_use_points;
        ViewLoading.show(this);
        dataRepository.buyNow(loginBean, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(mContext);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(mContext);
                WxPayResultModel wxPayResultModel = (WxPayResultModel) data;
                if (wxPayResultModel.getCode() == 1) {
                    if (Double.parseDouble(sureOrderData.getOrder_total_price()) <= 0) {
                        EventBus.getDefault().post("pay_success");
                    }
                    wxPay(wxPayResultModel.getData().getPayment());
                }
//                ToastUtils.showToast(wxPayResultModel.getMsg());
            }
        });
    }

    /**
     * prepay_id : wx11140431963012c5cb5a8cd613d3130000
     * nonceStr : ca39047264ad5a85a7f3c640289e48d4
     * timeStamp : 1615442671
     * paySign : 7DADAB91C216E61708420EF8F82ABEA8
     * mch_id : 1605495785
     * app_id : wx541630a0717a5007
     * package : Sign=WXPay
     *
     * @param payment
     */

    private void wxPay(WxPayResultModel.DataBean.PaymentBean payment) {
        PayReq req = new PayReq();
//        Gson gson = new Gson();
//        Map<String, String> map = new HashMap<>();
//        map = gson.fromJson(alipayRecord.getData(), map.getClass());
        req.appId = payment.getApp_id();
        req.nonceStr = payment.getNonceStr();
        req.packageValue = payment.getPackageX();
//        req.packageValue = "Sign=WXPay";
        req.partnerId = payment.getMch_id();
        req.prepayId = payment.getPrepay_id();
        req.sign = payment.getPaySign();
        req.timeStamp = payment.getTimeStamp();
        MyApp.mWxApi.sendReq(req);
    }

    private void buyNowCart(String cart_ids) {
        LoginBean loginBean = new LoginBean();
        loginBean.wxapp_id = "10001";
        loginBean.token = FastData.getToken();
        loginBean.cart_ids = cart_ids;
        loginBean.pay_type = pay_type;
        loginBean.address_id = address_id;
        loginBean.is_use_points = is_use_points;
        ViewLoading.show(this);
        dataRepository.buyNowCart(loginBean, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(mContext);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(mContext);
                OrderCartModel orderCartModel = (OrderCartModel) data;
                if (orderCartModel.getCode() == 1) {

                }
                ToastUtils.showToast(orderCartModel.getMsg());
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 9 && resultCode == RESULT_OK) {

            if (data.getSerializableExtra("result") != null) {
                Serializable result = data.getSerializableExtra("result");
                AddressListModel.DataBean.ListBean userShipBean = (AddressListModel.DataBean.ListBean) result;
                if (userShipBean == null) {
                    return;
                }
                address_id = userShipBean.getAddress_id() + "";
                tvName.setText(userShipBean.getName());
                String phone = userShipBean.getPhone().replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
                tvPhone.setText(phone);
                tvAddress.setText(userShipBean.getRegion().getProvince() + userShipBean.getRegion().getCity() + userShipBean.getRegion().getRegion());

            }
        }
        if (requestCode == 9 && resultCode == 1001) {
            getAddressDefault();
        }
    }

    @OnClick({R.id.iv_back, R.id.rl_address, R.id.tv_settlement, R.id.rl_money})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.rl_address:
                Intent intent = new Intent(this, AddressActivity.class);
                intent.putExtra("from", "from");
                startActivityForResult(intent, 9);

                break;
            case R.id.tv_settlement:
                if (TextUtils.isEmpty(address_id)) {
                    ToastUtils.showToast("请输入收货地址");
                }
                if (Double.parseDouble(sureOrderData.getOrder_total_price()) <= 0) {
                    pay_type = "10";                    //0元支付
                }
                if (getIntent().getStringExtra("cart_ids") != null) {
                    buyNowCart(getIntent().getStringExtra("cart_ids"));
                } else {
                    buyNow();
                }
                break;
            case R.id.rl_money:
                flag = !flag;
                if (flag) {
                    ivUsePoints.setImageResource(R.mipmap.juice_circle);
                    tvDiscount.setVisibility(View.VISIBLE);
                    is_use_points = "1";

                } else {
                    tvDiscount.setVisibility(View.GONE);
                    ivUsePoints.setImageResource(R.mipmap.grey_circle);
                    is_use_points = "0";

                }
                is_use_points();
                break;
        }
    }

    private void is_use_points() {
        if (!TextUtils.isEmpty(getIntent().getStringExtra("goods_id"))) {
            sureOrder();
        }else  if(!TextUtils.isEmpty(getIntent().getStringExtra("cart_ids")))
        {
            orderCart();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN, priority = 100, sticky = false) //在ui线程执行，优先级为100
    public void onEvent(String event) {
        if (event.equals("pay_success")) {
            Intent intent = new Intent(this, PaySuccessActivity.class);
            intent.putExtra("type", "1");
            startActivity(intent);
            finish();
        }
        if (event.equals("pay_cancel")) {
//            Intent intent = new Intent(mContext, OrderDetailActivity.class);
//            intent.putExtra("order_id",sureOrderData.get.getOrder_id());
//            startActivity(intent);
        }
    }
}
