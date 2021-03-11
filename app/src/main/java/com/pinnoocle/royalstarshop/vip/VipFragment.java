package com.pinnoocle.royalstarshop.vip;

import android.content.Intent;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import com.pinnoocle.royalstarshop.bean.WxPayResultModel;
import com.pinnoocle.royalstarshop.common.BaseFragment;
import com.pinnoocle.royalstarshop.nets.DataRepository;
import com.pinnoocle.royalstarshop.nets.Injection;
import com.pinnoocle.royalstarshop.nets.RemotDataSource;
import com.pinnoocle.royalstarshop.utils.FastData;
import com.pinnoocle.royalstarshop.widget.RoundImageView;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.timmy.tdialog.TDialog;
import com.timmy.tdialog.base.BindViewHolder;
import com.timmy.tdialog.listener.OnBindViewListener;
import com.timmy.tdialog.listener.OnViewClickListener;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

public class VipFragment extends BaseFragment {
    @BindView(R.id.iv_bg)
    ImageView ivBg;
    @BindView(R.id.iv_avater)
    RoundImageView ivAvater;
    @BindView(R.id.tv_golden_bean)
    TextView tvGoldenBean;
    @BindView(R.id.tv_renew)
    TextView tvRenew;
    @BindView(R.id.iv_right)
    ImageView ivRight;
    @BindView(R.id.iv_goods_pic)
    ImageView ivGoodsPic;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.iv_avatar_one)
    RoundImageView ivAvatarOne;
    @BindView(R.id.rl_recommendation)
    RelativeLayout rlRecommendation;
    @BindView(R.id.ll_comers)
    LinearLayout llComers;
    @BindView(R.id.ll_select)
    LinearLayout llSelect;
    @BindView(R.id.open_vip)
    TextView openVip;
    @BindView(R.id.tv_money)
    TextView tvMoney;
    @BindView(R.id.ll_hint)
    LinearLayout llHint;
    @BindView(R.id.iv_photo)
    ImageView ivPhoto;
    @BindView(R.id.tv_nickname)
    TextView tvNickname;
    @BindView(R.id.iv_goods_photo)
    ImageView ivGoodsPhoto;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_gold)
    TextView tvGold;
    @BindView(R.id.tv_drawLine)
    TextView tvDrawLine;
    @BindView(R.id.iv_grey_circle)
    ImageView ivGreyCircle;
    private DataRepository dataRepository;
    private boolean isSelect = true;
    private ImageView iv_ali_mark;
    private ImageView iv_wx_mark;
    private String pay_mode = "wx_pay";

    @Override
    protected int LayoutId() {
        return R.layout.fragment_vip;
    }

    @Override
    protected void initView() {
        dataRepository = Injection.dataRepository(getContext());
        vip();
    }

    private void vip() {
        ViewLoading.show(getContext());
        LoginBean loginBean = new LoginBean();
        loginBean.wxapp_id = "10001";
        loginBean.token = FastData.getToken();
        dataRepository.vipInfo(loginBean, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(getContext());
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(getContext());
                VipInfoModel vipInfoModel = (VipInfoModel) data;
                if (vipInfoModel.getCode() == 1) {
                    if (TextUtils.isEmpty(vipInfoModel.getData().getUserInfo().getAvatarUrl())) {
                        ivAvatarOne.setImageResource(R.drawable.default_avatar);
                    } else {
                        Glide.with(getActivity()).load(vipInfoModel.getData().getUserInfo().getAvatarUrl()).into(ivAvatarOne);
                    }
                    tvMoney.setText(vipInfoModel.getData().getMoney() + "");
                    tvNickname.setText(vipInfoModel.getData().getUserInfo().getNickName());
                    Glide.with(getActivity()).load(vipInfoModel.getData().getVip_goods().getGoods_image()).into(ivPhoto);
                    Glide.with(getActivity()).load(vipInfoModel.getData().getVip_goods().getGoods_image()).into(ivGoodsPhoto);
                    tvTitle.setText(vipInfoModel.getData().getVip_goods().getGoods_name());
                    tvGold.setText(vipInfoModel.getData().getVip_goods_point() + " 金豆");
                    tvDrawLine.setText("¥" + vipInfoModel.getData().getVip_goods_money());
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
                    if(pay_mode.equals("wx_pay")) {
                        wxPay(vipOpenModel.getData().getPayment());
                    }else  if(pay_mode.equals("ali_pay")){

                    }
                }
            }
        });
    }

    private void wxPay(VipOpenModel.DataBean.PaymentBean payment){
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



    @OnClick({R.id.iv_grey_circle, R.id.open_vip})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_grey_circle:
                if(isSelect){
                    ivGreyCircle.setImageResource(R.mipmap.select);
                    isSelect = false;
                }else {
                    ivGreyCircle.setImageResource(R.mipmap.grey_circle);
                    isSelect = true;
                }
                break;
            case R.id.open_vip:
                showVipOpenDialog();
//                Intent intent = new Intent(getContext(), VipRenewActivity.class);
//                startActivity(intent);
                break;
        }
    }

    private void showVipOpenDialog() {
        new TDialog.Builder(getActivity().getSupportFragmentManager())
                .setLayoutRes(R.layout.order_vip_open_dialog)
                .setScreenWidthAspect(getContext(), 1f)
                .setGravity(Gravity.BOTTOM)
                .setCancelableOutside(true)
                .addOnClickListener(R.id.open_vip,R.id.rl_ali,R.id.rl_wechat)
                .setOnBindViewListener(new OnBindViewListener() {
                    @Override
                    public void bindView(BindViewHolder viewHolder) {
                        iv_ali_mark = viewHolder.itemView.findViewById(R.id.iv_ali_mark);
                        iv_wx_mark = viewHolder.itemView.findViewById(R.id.iv_wx_mark);
                    }
                })
                .setOnViewClickListener(new OnViewClickListener() {
                    @Override
                    public void onViewClick(BindViewHolder viewHolder, View view, TDialog tDialog) {
                        switch (view.getId()) {
                            case R.id.open_vip:
                                vipOpen();
                                tDialog.dismiss();

                                break;
                            case R.id.rl_ali:
                                setPayMode(iv_ali_mark,"ali_pay");
                                break;
                            case R.id.rl_wechat:
                                setPayMode(iv_wx_mark,"wx_pay");
                                break;
                        }
                    }
                })
                .create()
                .show();
    }

    private void setPayMode(ImageView imageView,String pay_mode){
        iv_ali_mark.setImageResource(R.mipmap.grey_circle);
        iv_wx_mark.setImageResource(R.mipmap.grey_circle);
        this.pay_mode = pay_mode;
        imageView.setImageResource(R.mipmap.juice_circle);
    }



}
