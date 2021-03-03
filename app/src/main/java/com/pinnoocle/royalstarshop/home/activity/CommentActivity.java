package com.pinnoocle.royalstarshop.home.activity;

import android.os.Bundle;

import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.common.BaseActivity;

public class CommentActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initTransparent();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
    }
}