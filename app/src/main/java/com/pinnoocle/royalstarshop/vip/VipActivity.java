package com.pinnoocle.royalstarshop.vip;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pedaily.yc.ycdialoglib.toast.ToastUtils;
import com.pinnoocle.royalstarshop.MyApp;
import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.adapter.HotGoodsAdapter;
import com.pinnoocle.royalstarshop.adapter.VipGoodsListAdapter;
import com.pinnoocle.royalstarshop.bean.LoginBean;
import com.pinnoocle.royalstarshop.bean.VipGoodsModel;
import com.pinnoocle.royalstarshop.bean.VipIndexModel;
import com.pinnoocle.royalstarshop.bean.VipInfoModel;
import com.pinnoocle.royalstarshop.bean.VipOpenModel;
import com.pinnoocle.royalstarshop.common.BaseActivity;
import com.pinnoocle.royalstarshop.common.BaseAdapter;
import com.pinnoocle.royalstarshop.home.activity.GoodsDetailActivity;
import com.pinnoocle.royalstarshop.home.activity.VipGoodsDetailActivity;
import com.pinnoocle.royalstarshop.login.LoginActivity;
import com.pinnoocle.royalstarshop.mine.activity.GoldenBeanDetailActivity;
import com.pinnoocle.royalstarshop.mine.activity.VipOrderConfirmActivity;
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

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class VipActivity extends BaseActivity {
    @BindView(R.id.tv_vip_title)
    TextView tvVipTitle;
    @BindView(R.id.iv_avater)
    RoundImageView ivAvater;
    @BindView(R.id.tv_nickname_1)
    TextView tvNickname1;
    @BindView(R.id.tv_golden_bean)
    TextView tvGoldenBean;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.tv_renew)
    TextView tvRenew;
    @BindView(R.id.iv_right)
    ImageView ivRight;
    @BindView(R.id.tv_money_one)
    TextView tvMoneyOne;
    @BindView(R.id.tv_gold_detail)
    TextView tvGoldDetail;
    @BindView(R.id.iv_goods_pic)
    ImageView ivGoodsPic;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_vip_text)
    TextView tvVipText;
    @BindView(R.id.tv_vip_get_goods)
    TextView tvVipGetGoods;
    @BindView(R.id.rv_1)
    RecyclerView rv1;
    @BindView(R.id.recycleView)
    RecyclerView recycleView;
    @BindView(R.id.nestedScrollView1)
    NestedScrollView nestedScrollView1;
    @BindView(R.id.iv_avatar_one)
    RoundImageView ivAvatarOne;
    @BindView(R.id.tv_nickname)
    TextView tvNickname;
    @BindView(R.id.rl_recommendation)
    RelativeLayout rlRecommendation;
    @BindView(R.id.tv_money)
    TextView tvMoney;
    @BindView(R.id.ll_comers)
    LinearLayout llComers;
    @BindView(R.id.iv_grey_circle)
    ImageView ivGreyCircle;
    @BindView(R.id.ll_select)
    LinearLayout llSelect;
    @BindView(R.id.open_vip)
    TextView openVip;
    @BindView(R.id.ll_hint)
    LinearLayout llHint;
    @BindView(R.id.iv_photo)
    ImageView ivPhoto;
    @BindView(R.id.iv_goods_photo)
    ImageView ivGoodsPhoto;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_gold)
    TextView tvGold;
    @BindView(R.id.tv_drawLine)
    TextView tvDrawLine;
    @BindView(R.id.nestedScrollView2)
    NestedScrollView nestedScrollView2;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    private DataRepository dataRepository;
    private boolean isSelect = true;
    private ImageView iv_ali_mark;
    private ImageView iv_wx_mark;
    private String pay_mode = "wx_pay";
    private HotGoodsAdapter hotGoodsAdapter;
    private VipGoodsListAdapter vipGoodsListAdapter;
    private int vip_order;

    protected void onCreate(Bundle savedInstanceState) {
        initTransparent();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vip);
        ButterKnife.bind(this);
        initView();

    }


    protected void initView() {
        dataRepository = Injection.dataRepository(mContext);

        hotGoodsAdapter = new HotGoodsAdapter(mContext);
        hotGoodsAdapter.setOnItemDataClickListener(new BaseAdapter.OnItemDataClickListener<VipIndexModel.DataBean.HotBean>() {
            @Override
            public void onItemViewClick(View view, int position, VipIndexModel.DataBean.HotBean o) {
                Intent intent = new Intent(mContext, GoodsDetailActivity.class);
                intent.putExtra("goods_id", o.getGoods_id() + "");
                startActivity(intent);
            }
        });
        rv1.setLayoutManager(new GridLayoutManager(mContext, 3));
        rv1.setAdapter(hotGoodsAdapter);

        recycleView.setLayoutManager(new GridLayoutManager(mContext, 2));
        vipGoodsListAdapter = new VipGoodsListAdapter(mContext);
        recycleView.setAdapter(vipGoodsListAdapter);
        vipGoodsListAdapter.setOnItemDataClickListener(new BaseAdapter.OnItemDataClickListener<VipIndexModel.DataBean.GoodBean>() {
            @Override
            public void onItemViewClick(View view, int position, VipIndexModel.DataBean.GoodBean o) {
                Intent intent = new Intent(mContext, GoodsDetailActivity.class);
                intent.putExtra("goods_id", o.getGoods_id() + "");
                startActivity(intent);
            }
        });

        vip();
        vipIndex();
    }

    private void vipIndex() {
        LoginBean loginBean = new LoginBean();
        loginBean.wxapp_id = "10001";
        loginBean.token = FastData.getToken();
        dataRepository.vipIndex(loginBean, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {

            }

            @Override
            public void onSuccess(Object data) {
                VipIndexModel vipIndexModel = (VipIndexModel) data;
                if (vipIndexModel.getCode() == 1) {
                    List<VipIndexModel.DataBean.HotBean> hotGoods = vipIndexModel.getData().getHot();
                    if (hotGoods.size() <= 6) {
                        hotGoodsAdapter.setData(hotGoods);
                    }
                    List<VipIndexModel.DataBean.GoodBean> vipGoods = vipIndexModel.getData().getGood();
                    vipGoodsListAdapter.setData(vipGoods);
                }
            }
        });
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
                    if (vipInfoModel.getData().getUserInfo().getIsVip() == 0) {
                        nestedScrollView2.setVisibility(View.VISIBLE);
                        nestedScrollView1.setVisibility(View.GONE);
                        if (TextUtils.isEmpty(vipInfoModel.getData().getUserInfo().getAvatarUrl())) {
                            ivAvatarOne.setImageResource(R.drawable.default_avatar);
                        } else {
                            Glide.with(mContext).load(vipInfoModel.getData().getUserInfo().getAvatarUrl()).into(ivAvatarOne);
                        }
                        tvMoney.setText(vipInfoModel.getData().getMoney() + "");
                        if (!TextUtils.isEmpty(vipInfoModel.getData().getUserInfo().getNickName())) {
                            tvNickname.setText(vipInfoModel.getData().getUserInfo().getNickName());
                        } else {
                            tvNickname.setText("用户" + vipInfoModel.getData().getUserInfo().getUser_id());
                        }
                        Glide.with(mContext).load(vipInfoModel.getData().getVip_goods().getGoods_image()).into(ivPhoto);
                        Glide.with(mContext).load(vipInfoModel.getData().getVip_goods().getGoods_image()).into(ivGoodsPhoto);
                        tvTitle.setText(vipInfoModel.getData().getVip_goods().getGoods_name());
                        tvGold.setText(vipInfoModel.getData().getVip_goods_point() + " 金豆");
                        tvDrawLine.setText("¥" + vipInfoModel.getData().getVip_goods_money());
                        tvVipText.setText(vipInfoModel.getData().getVip_goods_text());


                        tvVipTitle.setText("开通会员");
                    } else {
                        tvVipTitle.setText("会员中心");
                        nestedScrollView1.setVisibility(View.VISIBLE);
                        nestedScrollView2.setVisibility(View.GONE);
                        if (TextUtils.isEmpty(vipInfoModel.getData().getUserInfo().getAvatarUrl())) {
                            ivAvater.setImageResource(R.drawable.default_avatar);
                        } else {
                            Glide.with(mContext).load(vipInfoModel.getData().getUserInfo().getAvatarUrl()).into(ivAvater);
                        }
                        vip_order = vipInfoModel.getData().getUserInfo().getVip_order();
                        if (vipInfoModel.getData().getUserInfo().getVip_order() == 1) {
                            tvVipGetGoods.setText("已领取");
                        } else {
                            tvVipGetGoods.setText("立即领取");
                        }
                        tvNickname1.setText(vipInfoModel.getData().getUserInfo().getNickName());
                        tvGoldenBean.setText(vipInfoModel.getData().getUserInfo().getPoints() + "");
                        tvMoneyOne.setText(vipInfoModel.getData().getUserInfo().getPoints() + "元");
                        if (vipInfoModel.getData().getUserInfo().getIs_expire() == 0) {
                            tvTime.setText(vipInfoModel.getData().getUserInfo().getVip_expire() + "金豆到期");
                            ivRight.setVisibility(View.GONE);
                        } else {
                            tvTime.setText("金豆已到期  ");
                            tvRenew.setVisibility(View.VISIBLE);
                            ivRight.setVisibility(View.VISIBLE);
                        }
                        Glide.with(mContext).load(vipInfoModel.getData().getVip_goods().getGoods_image()).into(ivGoodsPic);
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


    @OnClick({R.id.iv_grey_circle, R.id.open_vip, R.id.tv_gold_detail, R.id.tv_vip_get_goods, R.id.iv_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_gold_detail:
                startActivity(new Intent(mContext, GoldenBeanDetailActivity.class));
                break;
            case R.id.iv_grey_circle:
                if (isSelect) {
                    ivGreyCircle.setImageResource(R.mipmap.select);
                    isSelect = false;
                } else {
                    ivGreyCircle.setImageResource(R.mipmap.grey_circle);
                    isSelect = true;
                }
                break;
            case R.id.open_vip:
                showVipOpenDialog();
//                Intent intent = new Intent(mContext, VipRenewActivity.class);
//                startActivity(intent);
                break;
            case R.id.tv_vip_get_goods:
//                if (vip_order == 1) {
//                    ToastUtils.showToast("您已领取过权益商品");
//                } else {
//                    Intent intent = new Intent(getContext(), VipOrderConfirmActivity.class);
//                    startActivity(intent);
//                }
                    getVipGoods();
                break;
            case R.id.iv_back:
                finish();
                break;
        }
    }
    private void getVipGoods() {
        LoginBean loginBean = new LoginBean();
        loginBean.wxapp_id = "10001";
        dataRepository.getVipGoods(loginBean, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {

            }

            @Override
            public void onSuccess(Object data) {
                VipGoodsModel vipGoodsModel = (VipGoodsModel) data;
                if (vipGoodsModel.getCode() == 1) {

                    Intent intent = new Intent(mContext, VipGoodsDetailActivity.class);
                    intent.putExtra("goods_id",vipGoodsModel.getData().getVip_goods().getGoods_id()+"");
                    startActivity(intent);

                }
            }
        });
    }


    private void showVipOpenDialog() {
        new TDialog.Builder(getSupportFragmentManager())
                .setLayoutRes(R.layout.order_vip_open_dialog)
                .setScreenWidthAspect(mContext, 1f)
                .setGravity(Gravity.BOTTOM)
                .setCancelableOutside(true)
                .addOnClickListener(R.id.open_vip, R.id.rl_ali, R.id.rl_wechat)
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
                                setPayMode(iv_ali_mark, "ali_pay");
                                break;
                            case R.id.rl_wechat:
                                setPayMode(iv_wx_mark, "wx_pay");
                                break;
                        }
                    }
                })
                .create()
                .show();
    }

    private void setPayMode(ImageView imageView, String pay_mode) {
        iv_ali_mark.setImageResource(R.mipmap.grey_circle);
        iv_wx_mark.setImageResource(R.mipmap.grey_circle);
        this.pay_mode = pay_mode;
        imageView.setImageResource(R.mipmap.juice_circle);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (getIntent().getStringExtra("pos") != null && getIntent().getStringExtra("pos").equals("4")) {
            EventBus.getDefault().post("8");
        } else {
            EventBus.getDefault().post("6");
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN, priority = 100, sticky = false) //在ui线程执行，优先级为100
    public void onEvent(String event) {
        if (event.equals("4")) {
            vip();
            vipIndex();
        }
    }


}
