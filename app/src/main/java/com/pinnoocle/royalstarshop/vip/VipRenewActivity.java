package com.pinnoocle.royalstarshop.vip;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pinnoocle.royalstarshop.MyApp;
import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.bean.LoginBean;
import com.pinnoocle.royalstarshop.bean.VipInfoModel;
import com.pinnoocle.royalstarshop.bean.VipOpenModel;
import com.pinnoocle.royalstarshop.common.BaseActivity;
import com.pinnoocle.royalstarshop.login.LoginActivity;
import com.pinnoocle.royalstarshop.nets.DataRepository;
import com.pinnoocle.royalstarshop.nets.Injection;
import com.pinnoocle.royalstarshop.nets.RemotDataSource;
import com.pinnoocle.royalstarshop.utils.FastData;
import com.pinnoocle.royalstarshop.widget.DrawLineTextView;
import com.pinnoocle.royalstarshop.widget.RoundImageView;
import com.tencent.mm.opensdk.modelpay.PayReq;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class VipRenewActivity extends BaseActivity {


    @BindView(R.id.iv_bg)
    ImageView ivBg;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.iv_crown)
    ImageView ivCrown;
    @BindView(R.id.iv_avater)
    RoundImageView ivAvater;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.iv_vip)
    ImageView ivVip;
    @BindView(R.id.iv_products)
    ImageView ivProducts;
    @BindView(R.id.tv_product)
    TextView tvProduct;
    @BindView(R.id.iv_renew)
    ImageView ivRenew;
    @BindView(R.id.tv_price)
    TextView tvPrice;
    @BindView(R.id.tv_price_drawLine)
    DrawLineTextView tvPriceDrawLine;
    @BindView(R.id.tv_right)
    TextView tvRight;
    @BindView(R.id.iv_date)
    ImageView ivDate;
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
    @BindView(R.id.open_vip)
    TextView openVip;
    @BindView(R.id.tv_renew_time)
    TextView tvRenewTime;
    private String payType = "20";
    private DataRepository dataRepository;
    private String pay_mode = "wx_pay";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initGrey();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vip_renew);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    private void initView() {

    }

    private void initData() {
        dataRepository = Injection.dataRepository(this);
        vip();
    }


    private void vip() {
        if (TextUtils.isEmpty(FastData.getToken())) {
            Intent intent = new Intent(mContext, LoginActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
            return;
        }
        ViewLoading.show(mContext);
        LoginBean loginBean = new LoginBean();
        loginBean.wxapp_id = "10001";
        loginBean.token = FastData.getToken();
        dataRepository.vipInfo(loginBean, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(mContext);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(mContext);
                VipInfoModel vipInfoModel = (VipInfoModel) data;
                if (vipInfoModel.getCode() == 1) {
                    tvName.setText(vipInfoModel.getData().getUserInfo().getNickName());
                    if (TextUtils.isEmpty(vipInfoModel.getData().getUserInfo().getAvatarUrl())) {
                        ivAvater.setImageResource(R.drawable.default_avatar);
                    } else {
                        Glide.with(mContext).load(vipInfoModel.getData().getUserInfo().getAvatarUrl()).into(ivAvater);
                    }
                    tvTime.setText("还有"+vipInfoModel.getData().getTime()+"天到期");
                    tvRenewTime.setText(vipInfoModel.getData().getNext_time());
                    tvProduct.setText(vipInfoModel.getData().getTitle());
                    tvPriceDrawLine.setText("原价" + vipInfoModel.getData().getMoney() + "元");
                    if (vipInfoModel.getData().getUserInfo().getIsVip() == 0) {
                        ivCrown.setVisibility(View.GONE);
                        ivVip.setVisibility(View.GONE);
                    } else {
                        ivCrown.setVisibility(View.VISIBLE);
                        ivVip.setVisibility(View.VISIBLE);


                    }
                }
            }
        });
    }

    private void vipOpen() {
        LoginBean loginBean = new LoginBean();
        loginBean.wxapp_id = "10001";
        loginBean.token = FastData.getToken();
        dataRepository.vipOpen(loginBean, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {

            }

            @Override
            public void onSuccess(Object data) {
                VipOpenModel vipOpenModel = (VipOpenModel) data;
                if (vipOpenModel.getCode() == 1) {
                    if (pay_mode.equals("wx_pay")) {
                        wxPay(vipOpenModel.getData().getPayment());
                    } else if (pay_mode.equals("ali_pay")) {

                    }
                }
            }
        });
    }

    private void wxPay(VipOpenModel.DataBean.PaymentBean payment) {
        PayReq req = new PayReq();
        Gson gson = new Gson();
        Map<String, String> map = new HashMap<>();
//        map = gson.fromJson(alipayRecord.getData(), map.getClass());
        req.appId = payment.getApp_id();
        req.nonceStr = payment.getNonceStr();
        req.packageValue = payment.getPackageX();
        req.partnerId = payment.getMch_id();
        req.prepayId = payment.getPrepay_id();
        req.sign = payment.getPaySign();
        req.timeStamp = payment.getTimeStamp();
        MyApp.mWxApi.sendReq(req);
    }


    @OnClick({R.id.iv_back, R.id.rl_wechat, R.id.rl_ali, R.id.open_vip})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.rl_ali:
                setPayMode(ivAliMark, "wx_pay");
//                payType = "10";
                break;
            case R.id.rl_wechat:
                payType = "20";
                setPayMode(ivWxMark, "ali_pay");
                break;
            case R.id.open_vip:
                vipOpen();
                break;
        }
    }

    private void setPayMode(ImageView imageView, String pay_mode) {
        ivAliMark.setImageResource(R.mipmap.grey_circle);
        ivWxMark.setImageResource(R.mipmap.grey_circle);
        this.pay_mode = pay_mode;
        imageView.setImageResource(R.mipmap.juice_circle);
    }

}