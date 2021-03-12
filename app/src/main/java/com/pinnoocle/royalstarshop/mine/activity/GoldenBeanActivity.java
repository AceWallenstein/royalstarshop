package com.pinnoocle.royalstarshop.mine.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.common.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GoldenBeanActivity extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.tv_gold)
    TextView tvGold;
    @BindView(R.id.tv_money)
    TextView tvMoney;
    @BindView(R.id.tv_more)
    TextView tvMore;
    @BindView(R.id.view)
    View view;
    @BindView(R.id.recycleView)
    RecyclerView recycleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initTransparent();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_golden_bean);
        ButterKnife.bind(this);
        tvMoney.setText(getIntent().getStringExtra("golden"));
    }

    @OnClick({R.id.iv_back, R.id.tv_more})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_more:
                startActivity(new Intent(this, GoldenBeanDetailActivity.class));
                break;
        }
    }
}