package com.pinnoocle.royalstarshop.mine.activity;

import android.os.Bundle;

import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.common.BaseActivity;
import com.pinnoocle.royalstarshop.utils.StatusBarUtils;

public class AboutUsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        StatusBarUtils.setColor(this.getWindow(), 0xffFF2329);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
    }
}