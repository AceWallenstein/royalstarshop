package com.pinnoocle.royalstarshop.mine.activity;

import android.os.Bundle;

import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.common.BaseActivity;

import org.angmarch.views.NiceSpinner;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import butterknife.ButterKnife;

public class OrderDetailActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initTransparent();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    private void initView() {
        NiceSpinner niceSpinner =  findViewById(R.id.nice_spinner);
        List<String> dataset = new LinkedList<>(Arrays.asList("One", "Two", "Three", "Four", "Five"));
        niceSpinner.attachDataSource(dataset);

    }

    private void initData() {

    }


}
