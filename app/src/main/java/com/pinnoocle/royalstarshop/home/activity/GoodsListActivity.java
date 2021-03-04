package com.pinnoocle.royalstarshop.home.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.androidkun.xtablayout.XTabLayout;
import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.adapter.FragmentAdapter;
import com.pinnoocle.royalstarshop.bean.LoginBean;
import com.pinnoocle.royalstarshop.bean.SubCategoryModel;
import com.pinnoocle.royalstarshop.common.BaseActivity;
import com.pinnoocle.royalstarshop.home.fragment.GoodListFragment;
import com.pinnoocle.royalstarshop.nets.DataRepository;
import com.pinnoocle.royalstarshop.nets.Injection;
import com.pinnoocle.royalstarshop.nets.RemotDataSource;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GoodsListActivity extends BaseActivity {


    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.xTablayout)
    XTabLayout xTablayout;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    private DataRepository dataRepository;
    private List<Fragment> fragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initWhite();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_list);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    private void initView() {
        tvTitle.setText(getIntent().getStringExtra("title"));
    }

    private void initData() {
        dataRepository = Injection.dataRepository(this);
        getSubCategory(getIntent().getStringExtra("category_id"));
    }

    private void getSubCategory(String category_id) {
        LoginBean loginBean = new LoginBean();
        loginBean.category_id = category_id;
        loginBean.wxapp_id = "10001";
        dataRepository.getSubCategory(loginBean, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {

            }

            @Override
            public void onSuccess(Object data) {
                SubCategoryModel subCategoryModel = (SubCategoryModel) data;
                if (subCategoryModel.getCode() == 1) {
                    List<SubCategoryModel.DataBean> dataBeans = subCategoryModel.getData();
                    if (dataBeans.size() > 1){
                        xTablayout.setVisibility(View.VISIBLE);
                        initTab(dataBeans);
                    }else {
                        xTablayout.setVisibility(View.GONE);
                    }
                }
            }
        });
    }

    private void initTab(List<SubCategoryModel.DataBean> dataBeans) {
        List<String> titles = new ArrayList<>();
        for (int i = 0; i < dataBeans.size(); i++) {
            if (i == 0) {
                titles.add("全部分类");
            } else {
                titles.add(dataBeans.get(i).getName());
            }
        }
        for (int i = 0; i < titles.size(); i++) {
            fragments.add(new GoodListFragment(dataBeans.get(i).getCategory_id()));
        }
        FragmentAdapter adatper = new FragmentAdapter(getSupportFragmentManager(), fragments, titles);
        viewPager.setAdapter(adatper);
//        viewPager.setOffscreenPageLimit(titles.size());
        //将TabLayout和ViewPager关联起来。
        xTablayout.setupWithViewPager(viewPager);
    }


    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }
}
