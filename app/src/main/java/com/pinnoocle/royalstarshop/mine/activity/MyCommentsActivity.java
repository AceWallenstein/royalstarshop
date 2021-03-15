package com.pinnoocle.royalstarshop.mine.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.androidkun.xtablayout.XTabLayout;
import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.adapter.FragmentAdapter;
import com.pinnoocle.royalstarshop.common.BaseActivity;
import com.pinnoocle.royalstarshop.mine.fragment.MyCommentsFragment;
import com.pinnoocle.royalstarshop.mine.fragment.OrderFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyCommentsActivity extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.xTablayout)
    XTabLayout xTablayout;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    private List<Fragment> fragments = new ArrayList<>();
    String[] types = new String[]{"", "10", "20", "30"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initTransparent();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_comments);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    private void initView() {
        initTabLayout();
    }

    private void initData() {

    }

    private void initTabLayout() {
        List<String> titles = new ArrayList<>();
        titles.add("全部");
        titles.add("好评");
        titles.add("中评");
        titles.add("差评");
        for (int i = 0; i < titles.size(); i++) {
            fragments.add(new MyCommentsFragment(types[i]));
        }
        FragmentAdapter adatper = new FragmentAdapter(getSupportFragmentManager(), fragments, titles);
        viewPager.setAdapter(adatper);
        viewPager.setOffscreenPageLimit(titles.size());
        xTablayout.setupWithViewPager(viewPager);
        int type = getIntent().getIntExtra("type", 0);
        viewPager.setCurrentItem(type);
    }


    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }
}
