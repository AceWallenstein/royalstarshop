package com.pinnoocle.royalstarshop.mine.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.common.BaseActivity;

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

    }

    @OnClick({R.id.iv_back, R.id.tv_buy, R.id.rl_ali, R.id.rl_wechat})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_buy:
                break;
            case R.id.rl_ali:
                setPayMode(ivAliMark,"ali_pay");
                break;
            case R.id.rl_wechat:
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
        }
        if (event.equals("pay_cancel")) {
//            Intent intent = new Intent(mContext, OrderDetailActivity.class);
//            intent.putExtra("order_id",sureOrderData.get.getOrder_id());
//            startActivity(intent);
        }
    }

}
