package com.pinnoocle.royalstarshop.vip;

import android.content.Intent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.common.BaseFragment;
import com.pinnoocle.royalstarshop.widget.RoundImageView;

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

    @Override
    protected int LayoutId() {
        return R.layout.fragment_vip;
    }

    @Override
    protected void initView() {

    }

    @OnClick(R.id.open_vip)
    public void onViewClicked() {
        Intent intent = new Intent(getContext(),VipRenewActivity.class);
        startActivity(intent);
    }
}
