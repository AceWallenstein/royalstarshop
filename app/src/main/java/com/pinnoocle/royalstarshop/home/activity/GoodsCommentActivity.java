package com.pinnoocle.royalstarshop.home.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.common.BaseActivity;
import com.pinnoocle.royalstarshop.widget.NoScrollViewPager;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GoodsCommentActivity extends BaseActivity {
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.flowlayout)
    TagFlowLayout flowlayout;
    @BindView(R.id.viewPager)
    NoScrollViewPager viewPager;

    protected void onCreate(Bundle savedInstanceState) {
        initWhite();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_goods_comment);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    private void initView() {
        initTagFlowLayout();
    }


    private void initData() {
    }

    private void initTagFlowLayout() {
        List<String> titles = new ArrayList<>();
        titles.add("全部");
        titles.add("好评");
        titles.add("中评");
        titles.add("差评");
        flowlayout.setAdapter(new TagAdapter<String>(titles) {
            @Override
            public void onSelected(int position, View view) {
                super.onSelected(position, view);
                TextView textView = view.findViewById(R.id.text);
                textView.setTextColor(Color.WHITE);


            }

            @Override
            public void unSelected(int position, View view) {
                super.unSelected(position, view);
                TextView textView = view.findViewById(R.id.text);
                textView.setTextColor(Color.BLACK);

            }

            @Override
            public TextView getView(FlowLayout parent, int position, String s) {
                TextView view = (TextView) LayoutInflater.from(GoodsCommentActivity.this)
                        .inflate(R.layout.layout_titles, parent, false);
                view.setText(s);
                return view;
            }
        });
        flowlayout.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
            @Override
            public boolean onTagClick(View view, int position, FlowLayout parent) {
                return true;
            }
        });
        flowlayout.getAdapter().setSelectedList(0);
    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }
}
