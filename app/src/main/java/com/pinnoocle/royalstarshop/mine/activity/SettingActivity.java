package com.pinnoocle.royalstarshop.mine.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.pedaily.yc.ycdialoglib.toast.ToastUtils;
import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.common.AppManager;
import com.pinnoocle.royalstarshop.common.BaseActivity;
import com.pinnoocle.royalstarshop.login.LoginActivity;
import com.pinnoocle.royalstarshop.utils.FastData;
import com.pinnoocle.royalstarshop.widget.DataCleanManager;

import org.greenrobot.eventbus.EventBus;

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
    @BindView(R.id.rl_clean)
    RelativeLayout rlClean;
    @BindView(R.id.tv_cache)
    TextView tvCache;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initWhite();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ButterKnife.bind(this);
        tvModifyPhone.setText(getIntent().getStringExtra("phone"));
        try {
            tvCache.setText(DataCleanManager.getTotalCacheSize(this));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @OnClick({R.id.iv_back, R.id.rl_personal, R.id.tv_quit, R.id.rl_transaction_code, R.id.rl_modify_phone, R.id.rl_about_us, R.id.rl_clean,R.id.rl_question})
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
                FastData.clear();
                EventBus.getDefault().post("6");
                finish();
//                Intent intent4 = new Intent(SettingActivity.this, LoginActivity.class);
//                intent4.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
//                startActivity(intent4);
//                AppManager.getInstance().killAllActivity();
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
            case R.id.rl_clean:
                DataCleanManager.clearAllCache(this);
                try {
                    tvCache.setText(DataCleanManager.getTotalCacheSize(this));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                ToastUtils.showToast("清除缓存成功");
                break;
            case R.id.rl_question:
                startActivity(new Intent(this,QuestionFeedbackActivity.class));
                break;
        }
    }
}