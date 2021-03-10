package com.pinnoocle.royalstarshop.mine.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

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
    @BindView(R.id.rl_transaction_code)
    RelativeLayout rlTransactionCode;
    @BindView(R.id.rl_modify_phone)
    RelativeLayout rlModifyPhone;
    @BindView(R.id.rl_about_us)
    RelativeLayout rlAboutUs;
    @BindView(R.id.tv_modify_phone)
    TextView tvModifyPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initWhite();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ButterKnife.bind(this);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < getIntent().getStringExtra("phone").length(); i++) {
            char c = getIntent().getStringExtra("phone").charAt(i);
            if (i >= 3 && i <= 6) {
                sb.append('*');
            } else {
                sb.append(c);
            }
        }
        tvModifyPhone.setText(sb.toString());
    }

    @OnClick({R.id.iv_back, R.id.rl_personal, R.id.tv_quit, R.id.rl_transaction_code, R.id.rl_modify_phone, R.id.rl_about_us})
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
            case R.id.rl_transaction_code:
                Intent intent1 = new Intent(this, TransactionCodeActivity.class);
                startActivity(intent1);
                break;
            case R.id.rl_modify_phone:
                Intent intent2 = new Intent(this, ModifyNumberActivity.class);
                startActivityForResult(intent2, 1000);
                break;
            case R.id.rl_about_us:
                Intent intent3 = new Intent(this, AboutUsActivity.class);
                startActivity(intent3);
                break;
        }
    }
}