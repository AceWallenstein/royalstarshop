package com.pinnoocle.royalstarshop;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.pinnoocle.royalstarshop.adapter.FragmentTabAdapter;
import com.pinnoocle.royalstarshop.common.BaseActivity;
import com.pinnoocle.royalstarshop.home.fragment.HomeFragment;
import com.pinnoocle.royalstarshop.mine.MineFragment;
import com.pinnoocle.royalstarshop.shoppingcart.ShoppingCartFragment;
import com.pinnoocle.royalstarshop.video.VideoFragment;
import com.pinnoocle.royalstarshop.vip.VipFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.fl_layout)
    FrameLayout flLayout;
    @BindView(R.id.iv_tab_home)
    ImageView ivTabHome;
    @BindView(R.id.tv_tab_home)
    TextView tvTabHome;
    @BindView(R.id.ll_tab_home)
    LinearLayout llTabHome;
    @BindView(R.id.iv_tab_video)
    ImageView ivTabVideo;
    @BindView(R.id.tv_tab_video)
    TextView tvTabVideo;
    @BindView(R.id.ll_tab_video)
    LinearLayout llTabVideo;
    @BindView(R.id.iv_tab_vip)
    ImageView ivTabVip;
    @BindView(R.id.tv_tab_vip)
    TextView tvTabVip;
    @BindView(R.id.ll_tab_vip)
    LinearLayout llTabVip;
    @BindView(R.id.iv_tab_shop_car)
    ImageView ivTabShopCar;
    @BindView(R.id.tv_tab_shop_car)
    TextView tvTabShopCar;
    @BindView(R.id.ll_tab_shop_car)
    LinearLayout llTabShopCar;
    @BindView(R.id.iv_tab_mine)
    ImageView ivTabMine;
    @BindView(R.id.tv_tab_mine)
    TextView tvTabMine;
    @BindView(R.id.ll_tab_mine)
    LinearLayout llTabMine;
    @BindView(R.id.lin)
    LinearLayout lin;
    private List<Fragment> fragments = new ArrayList<>();
    private FragmentTabAdapter tabAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initRed();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    private void initView() {
        fragments.add(new HomeFragment());
        fragments.add(new VideoFragment());
        fragments.add(new VipFragment());
        fragments.add(new ShoppingCartFragment());
        fragments.add(new MineFragment());
        tabAdapter = new FragmentTabAdapter(this, fragments, R.id.fl_layout);
        initListener();
    }

    @OnClick({R.id.ll_tab_home, R.id.ll_tab_video, R.id.ll_tab_vip, R.id.ll_tab_shop_car, R.id.ll_tab_mine})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_tab_home:
                initRed();
                tabAdapter.setCurrentFragment(0);
                break;
            case R.id.ll_tab_video:
                initRed();
                tabAdapter.setCurrentFragment(1);
                break;
            case R.id.ll_tab_vip:
                initGrey();
                tabAdapter.setCurrentFragment(2);
                break;
            case R.id.ll_tab_shop_car:
                initWhite();
                tabAdapter.setCurrentFragment(3);
                break;
            case R.id.ll_tab_mine:
                initJuice();
                tabAdapter.setCurrentFragment(4);
                break;
        }
    }

    protected void initListener() {
        tabAdapter.setOnTabChangeListener(new FragmentTabAdapter.OnTabChangeListener() {
            @Override
            public void OnTabChanged(int index) {
//                tvTabHome.setTextColor(getResources().getColor(R.color.grey));
//                tvTabVideo.setTextColor(getResources().getColor(R.color.grey));
//                tvTabVip.setTextColor(getResources().getColor(R.color.grey));
                switch (index) {
                    case 0:
                        ivTabHome.setImageResource(R.mipmap.home_1);
                        ivTabVideo.setImageResource(R.mipmap.video);
                        ivTabVip.setImageResource(R.mipmap.vip);
                        ivTabShopCar.setImageResource(R.mipmap.shopcar);
                        ivTabMine.setImageResource(R.mipmap.mine);
                        break;
                    case 1:
                        ivTabHome.setImageResource(R.mipmap.home);
                        ivTabVideo.setImageResource(R.mipmap.video_1);
                        ivTabVip.setImageResource(R.mipmap.vip);
                        ivTabShopCar.setImageResource(R.mipmap.shopcar);
                        ivTabMine.setImageResource(R.mipmap.mine);
                        break;
                    case 2:
                        ivTabHome.setImageResource(R.mipmap.home);
                        ivTabVideo.setImageResource(R.mipmap.video);
                        ivTabVip.setImageResource(R.mipmap.vip);
                        ivTabShopCar.setImageResource(R.mipmap.shopcar);
                        ivTabMine.setImageResource(R.mipmap.mine);
                        break;
                    case 3:
                        ivTabHome.setImageResource(R.mipmap.home);
                        ivTabVideo.setImageResource(R.mipmap.video);
                        ivTabVip.setImageResource(R.mipmap.vip);
                        ivTabShopCar.setImageResource(R.mipmap.shopcar_1);
                        ivTabMine.setImageResource(R.mipmap.mine);
                        break;
                    case 4:
                        ivTabHome.setImageResource(R.mipmap.home);
                        ivTabVideo.setImageResource(R.mipmap.video);
                        ivTabVip.setImageResource(R.mipmap.vip);
                        ivTabShopCar.setImageResource(R.mipmap.shopcar);
                        ivTabMine.setImageResource(R.mipmap.mine_1);
                        break;
                }
            }
        });
    }


    private void initData() {

    }

}