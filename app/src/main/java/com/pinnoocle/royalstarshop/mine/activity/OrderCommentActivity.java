package com.pinnoocle.royalstarshop.mine.activity;

import android.os.Bundle;

import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.common.BaseActivity;

import butterknife.ButterKnife;

public class OrderCommentActivity extends BaseActivity {
    protected void onCreate(Bundle savedInstanceState) {
        initWhite();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_comment);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    private void initView() {

    }

    private void initData() {

    }
}
