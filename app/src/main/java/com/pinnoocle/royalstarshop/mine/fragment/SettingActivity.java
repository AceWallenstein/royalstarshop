package com.pinnoocle.royalstarshop.mine.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.common.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ch.ielse.view.SwitchView;

public class SettingActivity extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.rl_personal)
    RelativeLayout rlPersonal;
    @BindView(R.id.iv_right)
    ImageView ivRight;
    @BindView(R.id.iv_right1)
    ImageView ivRight1;
    @BindView(R.id.iv_right2)
    ImageView ivRight2;
    @BindView(R.id.iv_right3)
    ImageView ivRight3;
    @BindView(R.id.switch_disturb)
    SwitchView switchDisturb;
    @BindView(R.id.tv_quit)
    TextView tvQuit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initWhite();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.iv_back, R.id.rl_personal, R.id.tv_quit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.rl_personal:
                Intent intent = new Intent(this, PersonalActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_quit:
                break;
        }
    }
}