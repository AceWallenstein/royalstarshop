package com.pinnoocle.royalstarshop.mine.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.collection.ArraySet;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.androidkun.xtablayout.XTabLayout;
import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.adapter.FragmentAdapter;
import com.pinnoocle.royalstarshop.common.BaseActivity;
import com.pinnoocle.royalstarshop.common.Type;
import com.pinnoocle.royalstarshop.mine.fragment.OrderFragment;
import com.pinnoocle.royalstarshop.utils.StatusBarUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OrderActivity extends BaseActivity {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.xTablayout)
    XTabLayout xTablayout;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    private List<String> orderTypes = new ArrayList<>();
    private List<Fragment> fragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initWhite();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    private void initView() {
        initOrderTypes();
        initTabLayout();
    }

    private void initData() {

    }
    private void initOrderTypes() {
        orderTypes.add(Type.All);
        orderTypes.add(Type.Payment);
        orderTypes.add(Type.Delivery);
        orderTypes.add(Type.Received);
        orderTypes.add(Type.Comment);
    }

    private void initTabLayout() {
        List<String> titles = new ArrayList<>();
        titles.add("全部");
        titles.add("待付款");
        titles.add("待发货");
        titles.add("待收货");
        titles.add("待评价");
        for (int i = 0; i < titles.size(); i++) {
            fragments.add(new OrderFragment(orderTypes.get(i) + ""));
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
