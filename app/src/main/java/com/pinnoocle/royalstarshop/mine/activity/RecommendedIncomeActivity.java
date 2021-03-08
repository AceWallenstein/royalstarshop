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

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RecommendedIncomeActivity extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.ll_comers)
    LinearLayout llComers;
    @BindView(R.id.tv_profit)
    TextView tvProfit;
    @BindView(R.id.rl_profit_today)
    RelativeLayout rlProfitToday;
    @BindView(R.id.iv_profit_detail)
    ImageView ivProfitDetail;
    @BindView(R.id.rl_profit_detail)
    RelativeLayout rlProfitDetail;
    @BindView(R.id.iv_weixin_pay)
    ImageView ivWeixinPay;
    @BindView(R.id.rl_withdrawal_detail)
    RelativeLayout rlWithdrawalDetail;
    @BindView(R.id.tv_withdrawal)
    TextView tvWithdrawal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initTransparent();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommended_income);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.iv_back, R.id.rl_profit_detail, R.id.rl_withdrawal_detail, R.id.tv_withdrawal})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.rl_profit_detail:
                Intent intent = new Intent(this, ProfitDetailActivity.class);
                startActivity(intent);
                break;
            case R.id.rl_withdrawal_detail:
                Intent intent1 = new Intent(this, WithdrawalDetailActivity.class);
                startActivity(intent1);
                break;
            case R.id.tv_withdrawal:
                Intent intent2 = new Intent(this, WithdrawalActivity.class);
                startActivity(intent2);
                break;
        }
    }
}