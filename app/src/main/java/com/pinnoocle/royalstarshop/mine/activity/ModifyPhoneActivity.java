package com.pinnoocle.royalstarshop.mine.activity;

import android.os.Bundle;

import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.common.BaseActivity;

public class ModifyPhoneActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initWhite();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_phone);
    }
}