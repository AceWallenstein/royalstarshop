package com.pinnoocle.royalstarshop.mine.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.common.BaseActivity;
import com.pinnoocle.royalstarshop.utils.StatusBarUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AboutUsActivity extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        StatusBarUtils.setColor(this.getWindow(), 0xffFF2329);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }
}