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

import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pinnoocle.royalstarshop.MyApp;
import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.adapter.HotGoodsAdapter;
import com.pinnoocle.royalstarshop.adapter.VipGoodsListAdapter;
import com.pinnoocle.royalstarshop.bean.LoginBean;
import com.pinnoocle.royalstarshop.bean.VipIndexModel;
import com.pinnoocle.royalstarshop.bean.VipInfoModel;
import com.pinnoocle.royalstarshop.bean.VipOpenModel;
import com.pinnoocle.royalstarshop.common.BaseAdapter;
import com.pinnoocle.royalstarshop.common.BaseFragment;
import com.pinnoocle.royalstarshop.home.activity.GoodsDetailActivity;
import com.pinnoocle.royalstarshop.login.LoginActivity;
import com.pinnoocle.royalstarshop.mine.activity.GoldenBeanDetailActivity;
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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

public class VipFragment extends BaseFragment {
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
    @BindView(R.id.nestedScrollView1)
    NestedScrollView nestedScrollView1;
    @BindView(R.id.nestedScrollView2)
    NestedScrollView nestedScrollView2;
    @BindView(R.id.tv_nickname_1)
    TextView tvNickname1;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.tv_money_one)
    TextView tvMoneyOne;
    @BindView(R.id.rv_1)
    RecyclerView rv1;
    @BindView(R.id.recycleView)
    RecyclerView recycleView;
    @BindView(R.id.tv_gold_detail)
    TextView tvGoldDetail;
    private DataRepository dataRepository;
    private boolean isSelect = true;
    private ImageView iv_ali_mark;
    private ImageView iv_wx_mark;
    private String pay_mode = "wx_pay";
    private HotGoodsAdapter hotGoodsAdapter;
    private VipGoodsListAdapter vipGoodsListAdapter;

    @Override
    protected int LayoutId() {
        return R.layout.fragment_vip;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    protected void initView() {
        dataRepository = Injection.dataRepository(getContext());

        hotGoodsAdapter = new HotGoodsAdapter(getContext());
        hotGoodsAdapter.setOnItemDataClickListener(new BaseAdapter.OnItemDataClickListener<VipIndexModel.DataBean.HotBean>() {
            @Override
            public void onItemViewClick(View view, int position, VipIndexModel.DataBean.HotBean o) {
                Intent intent = new Intent(getContext(), GoodsDetailActivity.class);
                intent.putExtra("goods_id", o.getGoods_id() + "");
                startActivity(intent);
            }
        });
        rv1.setLayoutManager(new GridLayoutManager(getContext(), 3));
        rv1.setAdapter(hotGoodsAdapter);

        recycleView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        vipGoodsListAdapter = new VipGoodsListAdapter(getContext());
        recycleView.setAdapter(vipGoodsListAdapter);
        vipGoodsListAdapter.setOnItemDataClickListener(new BaseAdapter.OnItemDataClickListener<VipIndexModel.DataBean.GoodBean>() {
            @Override
            public void onItemViewClick(View view, int position, VipIndexModel.DataBean.GoodBean o) {
                Intent intent = new Intent(getContext(), GoodsDetailActivity.class);
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
            Intent intent = new Intent(getContext(), LoginActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
            return;
        }
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
                    if (vipInfoModel.getData().getUserInfo().getIsVip() == 0) {
                        nestedScrollView2.setVisibility(View.VISIBLE);
                        nestedScrollView1.setVisibility(View.GONE);
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
                    } else {
                        nestedScrollView1.setVisibility(View.VISIBLE);
                        nestedScrollView2.setVisibility(View.GONE);
                        if (TextUtils.isEmpty(vipInfoModel.getData().getUserInfo().getAvatarUrl())) {
                            ivAvater.setImageResource(R.drawable.default_avatar);
                        } else {
                            Glide.with(getActivity()).load(vipInfoModel.getData().getUserInfo().getAvatarUrl()).into(ivAvater);
                        }
                        tvNickname1.setText(vipInfoModel.getData().getUserInfo().getNickName());
                        tvGoldenBean.setText(vipInfoModel.getData().getUserInfo().getPoints() + "");
                        tvMoneyOne.setText(vipInfoModel.getData().getUserInfo().getPoints() + "元");
                        if (vipInfoModel.getData().getUserInfo().getIs_exprire() == 0) {
                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
                            Date date = new Date(vipInfoModel.getData().getUserInfo().getVip_expire() * 1000L);
                            tvTime.setText(simpleDateFormat.format(date) + "金豆到期");
                            ivRight.setVisibility(View.GONE);
                        } else {
                            tvTime.setText("金豆已到期  ");
                            tvRenew.setVisibility(View.VISIBLE);
                            ivRight.setVisibility(View.VISIBLE);
                        }
                        Glide.with(getActivity()).load(vipInfoModel.getData().getVip_goods().getGoods_image()).into(ivGoodsPic);
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


    @OnClick({R.id.iv_grey_circle, R.id.open_vip,R.id.tv_gold_detail})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_gold_detail:
                startActivity(new Intent(getContext(), GoldenBeanDetailActivity.class));
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


    @Subscribe(threadMode = ThreadMode.MAIN, priority = 100, sticky = false) //在ui线程执行，优先级为100
    public void onEvent(String event) {
        if (event.equals("4")) {
            vip();
            vipIndex();
        }
    }
}
