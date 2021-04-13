package com.pinnoocle.royalstarshop;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.pedaily.yc.ycdialoglib.toast.ToastUtils;
import com.pinnoocle.royalstarshop.adapter.FragmentTabAdapter;
import com.pinnoocle.royalstarshop.bean.LoginBean;
import com.pinnoocle.royalstarshop.bean.UserDetailModel;
import com.pinnoocle.royalstarshop.common.AppManager;
import com.pinnoocle.royalstarshop.common.BaseActivity;
import com.pinnoocle.royalstarshop.home.fragment.HomeFragment;
import com.pinnoocle.royalstarshop.login.LoginActivity;
import com.pinnoocle.royalstarshop.mine.fragment.MineFragment;
import com.pinnoocle.royalstarshop.nets.DataRepository;
import com.pinnoocle.royalstarshop.nets.Injection;
import com.pinnoocle.royalstarshop.nets.RemotDataSource;
import com.pinnoocle.royalstarshop.shoppingcart.ShoppingCartFragment;
import com.pinnoocle.royalstarshop.utils.FastData;
import com.pinnoocle.royalstarshop.utils.StatusBarUtil;
import com.pinnoocle.royalstarshop.utils.StatusBarUtils;
import com.pinnoocle.royalstarshop.video.VideoFragment;
import com.pinnoocle.royalstarshop.vip.VipActivity;
import com.pinnoocle.royalstarshop.vip.VipFragment;
import com.pinnoocle.royalstarshop.vip.VipRenewActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

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
    private DataRepository dataRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        StatusBarUtils.setColor(this.getWindow(), getResources().getColor(R.color.transparent));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppManager.getInstance().addActivity(this);
        initTransparent();
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
        StatusBarUtils.setColor(this.getWindow(), getResources().getColor(R.color.transparent));
        switch (view.getId()) {
            case R.id.ll_tab_home:
                initTransparent();
                tabAdapter.setCurrentFragment(0);
                break;
            case R.id.ll_tab_video:
                initTransparent();
                tabAdapter.setCurrentFragment(1);
                break;
            case R.id.ll_tab_vip:
                initTransparent();
                tabAdapter.setCurrentFragment(2);
                userInfo();

                break;
            case R.id.ll_tab_shop_car:
                initWhite();
                StatusBarUtils.setColor(this.getWindow(), getResources().getColor(R.color.white));
                tabAdapter.setCurrentFragment(3);
                if (TextUtils.isEmpty(FastData.getToken())) {
                   new Handler().postDelayed(new Runnable() {
                       @Override
                       public void run() {
                           EventBus.getDefault().post("7");
                       }
                   }, 100);
                }
                break;
            case R.id.ll_tab_mine:
                initTransparent();
                tabAdapter.setCurrentFragment(4);
                if (TextUtils.isEmpty(FastData.getToken())) {
                    Intent intent = new Intent(this, LoginActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    startActivity(intent);
                    return;
                }
                break;
        }
    }

    private void  userInfo() {
        if (TextUtils.isEmpty(FastData.getToken())) {
            Intent intent = new Intent(mContext, LoginActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
            return;
        }
        LoginBean loginBean = new LoginBean();
        loginBean.token = FastData.getToken();
        loginBean.wxapp_id = "10001";
        dataRepository.userDetail(loginBean, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {

            }

            @Override
            public void onSuccess(Object data) {

                UserDetailModel userDetailModel = (UserDetailModel) data;
                if (userDetailModel.getCode() == 1) {

                    if (userDetailModel.getData().getUserInfo().getIsVip() == 0) {
                        startActivity(new Intent(mContext, VipActivity.class));
                    } else {
                        if (userDetailModel.getData().getUserInfo().getIs_exprire() == 0) {
                            EventBus.getDefault().post("5");
                        } else {
//                            startActivity(new Intent(mContext, VipRenewActivity.class));

                        }
                    }
                }
            }
        });
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
        dataRepository = Injection.dataRepository(mContext);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Subscribe(threadMode = ThreadMode.MAIN, priority = 100, sticky = false) //在ui线程执行，优先级为100
    public void onEvent(String event)
    {
        if(event.equals("to_shop_cart")){
            initWhite();
            tabAdapter.setCurrentFragment(3);
        }else if(event.equals("3")){
            initTransparent();
            tabAdapter.setCurrentFragment(1);
        }else if(event.equals("5")){
            initTransparent();
            EventBus.getDefault().post("4");
            tabAdapter.setCurrentFragment(2);
        }else if(event.equals("6")){
            initTransparent();
            tabAdapter.setCurrentFragment(0);
        }else if(event.equals("8")){
            initTransparent();
            tabAdapter.setCurrentFragment(4);
        }

    }


    /**
     * 手机返回键监听
     */
    long firstTime = 0;

    @Override
    public void onBackPressed() {
        long secondTime = System.currentTimeMillis();
        if (secondTime - firstTime > 800) { // 两次点击间隔大于800毫秒，不退出
            ToastUtils.showToast("再按一次退出程序");
            firstTime = secondTime; // 更新firstTime
        } else {
            finish();
        }
    }
}