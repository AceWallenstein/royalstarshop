package com.pinnoocle.royalstarshop.home.activity;

import android.os.Bundle;

import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.common.BaseActivity;

import butterknife.ButterKnife;

public class GoodsDetailActivity extends BaseActivity {

    protected void onCreate(Bundle savedInstanceState) {
        initWhite();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_goods_detail);
        ButterKnife.bind(this);
//        RichText.initCacheDir(this);
        initView();
        initData();
    }

    private void initView() {

    }

    private void initData() {

    }


}
