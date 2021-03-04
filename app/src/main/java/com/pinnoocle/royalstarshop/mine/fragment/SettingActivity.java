package com.pinnoocle.royalstarshop.mine.fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.common.BaseActivity;

public class SettingActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initWhite();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
    }
}