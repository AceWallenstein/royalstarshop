package com.pinnoocle.royalstarshop.mine.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pinnoocle.royalstarshop.MyApp;
import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.bean.LoginBean;
import com.pinnoocle.royalstarshop.bean.OrderPayModel;
import com.pinnoocle.royalstarshop.bean.StatusModel;
import com.pinnoocle.royalstarshop.bean.WxPayResultModel;
import com.pinnoocle.royalstarshop.common.BaseActivity;
import com.pinnoocle.royalstarshop.nets.DataRepository;
import com.pinnoocle.royalstarshop.nets.Injection;
import com.pinnoocle.royalstarshop.nets.RemotDataSource;
import com.pinnoocle.royalstarshop.utils.FastData;
import com.tencent.mm.opensdk.modelpay.PayReq;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OrderPayActivity extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.tv_order_code)
    TextView tvOrderCode;
    @BindView(R.id.rl_order_code)
    RelativeLayout rlOrderCode;
    @BindView(R.id.tv_order_money)
    TextView tvOrderMoney;
    @BindView(R.id.rl_order_money)
    RelativeLayout rlOrderMoney;
    @BindView(R.id.iv_weixin_pay)
    ImageView ivWeixinPay;
    @BindView(R.id.iv_wx_mark)
    ImageView ivWxMark;
    @BindView(R.id.rl_wechat)
    RelativeLayout rlWechat;
    @BindView(R.id.iv_alipay)
    ImageView ivAlipay;
    @BindView(R.id.iv_ali_mark)
    ImageView ivAliMark;
    @BindView(R.id.rl_ali)
    RelativeLayout rlAli;
    @BindView(R.id.tv_buy)
    TextView tvBuy;
    @BindView(R.id.rl_pay_mode)
    LinearLayout rlPayMode;

    private String pay_mode = "wx_pay";
    private DataRepository dataRepository;
    private String payType = "20";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initTransparent();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_pay);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    private void initView() {
        String order_no = getIntent().getStringExtra("order_no");
        String order_money = getIntent().getStringExtra("order_money");
        tvOrderCode.setText(order_no);
        tvOrderMoney.setText(order_money);

    }

    private void initData() {
        dataRepository = Injection.dataRepository(this);
    }

    private void orderPay(String order_id) {
        ViewLoading.show(OrderPayActivity.this);
        LoginBean loginBean = new LoginBean();
        loginBean.wxapp_id = "10001";
        loginBean.token = FastData.getToken();
        loginBean.order_id = order_id;
        loginBean.payType = payType;          // 微信支付 20 支付宝 10
        dataRepository.orderPay(loginBean, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(OrderPayActivity.this);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(OrderPayActivity.this);
                OrderPayModel orderPayModel = (OrderPayModel) data;
                if (orderPayModel.getCode() == 1) {
                    wxPay(orderPayModel.getData().getPayment());
                }
            }

        });
    }

    private void wxPay(OrderPayModel.DataBean.PaymentBean payment) {
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



    @OnClick({R.id.iv_back, R.id.tv_buy, R.id.rl_ali, R.id.rl_wechat})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_buy:
                orderPay(getIntent().getStringExtra("order_id"));
                break;
            case R.id.rl_ali:
                setPayMode(ivAliMark,"ali_pay");
//                payType = "10";
                break;
            case R.id.rl_wechat:
                payType = "20";
                setPayMode(ivWxMark,"wx_pay");
                break;
        }
    }

    private void setPayMode(ImageView imageView, String pay_mode) {
        ivAliMark.setImageResource(R.mipmap.grey_circle);
        ivWxMark.setImageResource(R.mipmap.grey_circle);
        this.pay_mode = pay_mode;
        imageView.setImageResource(R.mipmap.juice_circle);
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
