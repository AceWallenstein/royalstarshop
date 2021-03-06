package com.pinnoocle.royalstarshop.home.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.adapter.FragmentAdapter;
import com.pinnoocle.royalstarshop.adapter.GoodsMenusAdapter;
import com.pinnoocle.royalstarshop.adapter.GoodsOneAdapter;
import com.pinnoocle.royalstarshop.adapter.GoodsTwoAdapter;
import com.pinnoocle.royalstarshop.adapter.TitleAdapter;
import com.pinnoocle.royalstarshop.bean.BannerModel;
import com.pinnoocle.royalstarshop.bean.HomeModel;
import com.pinnoocle.royalstarshop.bean.IndexModel;
import com.pinnoocle.royalstarshop.bean.LoginBean;
import com.pinnoocle.royalstarshop.bean.UserDetailModel;
import com.pinnoocle.royalstarshop.bean.VipGoodsModel;
import com.pinnoocle.royalstarshop.common.BaseAdapter;
import com.pinnoocle.royalstarshop.common.BaseFragment;
import com.pinnoocle.royalstarshop.event.UpdateTotalPriceEvent;
import com.pinnoocle.royalstarshop.home.activity.GoodsDetailActivity;
import com.pinnoocle.royalstarshop.home.activity.GoodsListActivity;
import com.pinnoocle.royalstarshop.home.activity.GoodsVideoDetailActivity;
import com.pinnoocle.royalstarshop.home.activity.MessageActivity;
import com.pinnoocle.royalstarshop.home.activity.MessageNewActivity;
import com.pinnoocle.royalstarshop.home.activity.SearchActivity;
import com.pinnoocle.royalstarshop.home.activity.VipListActivity;
import com.pinnoocle.royalstarshop.login.LoginActivity;
import com.pinnoocle.royalstarshop.nets.DataRepository;
import com.pinnoocle.royalstarshop.nets.Injection;
import com.pinnoocle.royalstarshop.nets.RemotDataSource;
import com.pinnoocle.royalstarshop.utils.FastData;
import com.pinnoocle.royalstarshop.vip.VipActivity;
import com.pinnoocle.royalstarshop.vip.VipRenewActivity;
import com.pinnoocle.royalstarshop.widget.ChatView;
import com.pinnoocle.royalstarshop.widget.CommItemDecoration;
import com.pinnoocle.royalstarshop.widget.MyViewPager;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.timmy.tdialog.TDialog;
import com.timmy.tdialog.base.BindViewHolder;
import com.timmy.tdialog.listener.OnViewClickListener;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class HomeFragment extends BaseFragment implements OnRefreshListener {

    @BindView(R.id.iv_bg)
    ImageView ivBg;
    @BindView(R.id.iv_comment)
    ImageView ivComment;
    @BindView(R.id.iv_kefu)
    ImageView ivKefu;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.tv_search)
    TextView tvSearch;
    @BindView(R.id.banner)
    Banner banner;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.v_progress)
    View vProgress;
    @BindView(R.id.layout)
    RelativeLayout layoutProgress;
    @BindView(R.id.ll_one)
    LinearLayout llOne;
    @BindView(R.id.iv_banner)
    ImageView ivBanner;
    @BindView(R.id.iv_vip_goods)
    ImageView ivVipGoods;
    @BindView(R.id.rl_banner)
    RelativeLayout rlBanner;
    @BindView(R.id.tv_1)
    TextView tv1;
    @BindView(R.id.iv_vip_goods_1)
    ImageView ivVipGoods1;
    @BindView(R.id.iv_go)
    ImageView ivGo;
    @BindView(R.id.tv_vip_1)
    TextView tvVip1;
    @BindView(R.id.rv_1)
    RecyclerView rv1;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_more)
    TextView tvMore;
    @BindView(R.id.rv_2)
    RecyclerView rv2;
    @BindView(R.id.rv_3)
    RecyclerView rv3;
    @BindView(R.id.vp_goods_list)
    MyViewPager vpGoodsList;
    @BindView(R.id.scrollView)
    NestedScrollView scrollView;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
    private List<BannerModel.DataBean> bannerList = new ArrayList<>();
    private GoodsMenusAdapter goodsMenusAdapter;
    private DataRepository dataRepository;
    private GoodsOneAdapter oneAdapter;
    private GoodsTwoAdapter twoAdapter;
    private TitleAdapter titleAdapter;
    private List<HomeModel.DataBean.TagGoodsBean> tagGoods = new ArrayList<>();
    private GoodsFragment goodListFragment;
    private int lastValue;
    private boolean moveRight;
    private boolean loaded = false;
    private ChatView fab;
    private TDialog tDialog;
    private boolean isVip;

    @Override
    protected int LayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
    }




    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    protected void initView() {
        dataRepository = Injection.dataRepository(getContext());
        initGoodMenus();
        initRv1();
        initRv2();
        initRv3();
        refresh.setOnRefreshListener(this);
        vipInfo();
        //传入上下文Activity
        fab = new ChatView(getActivity());
        fab.setOnClickListener(v -> {
            showDialog();
            fab.setVisibility(View.GONE);
        });
    }


    @Override
    protected void initData() {

        index();
        banner();
        home();
        getVipGoods();
    }

    private void index() {
        LoginBean loginBean = new LoginBean();
        loginBean.wxapp_id = "10001";
        dataRepository.index(loginBean, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {

            }

            @Override
            public void onSuccess(Object data) {
                IndexModel indexModel = (IndexModel) data;
                if (indexModel.getCode() == 1) {
                    List<IndexModel.DataBean.ListBean> list = indexModel.getData().getList();
                    if (list.size() < 6) {
                        layoutProgress.setVisibility(View.GONE);
                    } else {
                        layoutProgress.setVisibility(View.VISIBLE);

                    }
                    goodsMenusAdapter.setData(list);
                }
            }
        });
    }


    private void banner() {
        LoginBean loginBean = new LoginBean();
        loginBean.wxapp_id = "10001";
        dataRepository.banner(loginBean, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {

            }

            @Override
            public void onSuccess(Object data) {
                BannerModel bannerModel = (BannerModel) data;
                if (bannerModel.getCode() == 1) {
//                    for (int i = 0; i < bannerModel.getData().size(); i++) {
//                        bannerList.add(bannerModel.getData().get(i).getImage().getFile_path());
//                    }
                    bannerList = bannerModel.getData();
                    initBanner();
                }
            }
        });
    }

    private void home() {
        LoginBean loginBean = new LoginBean();
        loginBean.wxapp_id = "10001";
        ViewLoading.show(getContext());
        dataRepository.home(loginBean, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(getContext());
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(getContext());
                HomeModel homeModel = (HomeModel) data;
                if (homeModel.getCode() == 1) {
                    refresh.finishRefresh();
                    List<HomeModel.DataBean.VipGoodsBean> vipGoods = homeModel.getData().getVipGoods();
                    oneAdapter.setData(vipGoods);
                    List<HomeModel.DataBean.VideoGoodsBean> videoGoods = homeModel.getData().getVideoGoods();
                    twoAdapter.setData(videoGoods);
                    tagGoods = homeModel.getData().getTagGoods();
                    titleAdapter.setData(tagGoods);
                    initViewPager();
                }
            }
        });
    }

    private void getVipGoods() {
        LoginBean loginBean = new LoginBean();
        loginBean.wxapp_id = "10001";
        dataRepository.getVipGoods(loginBean, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {

            }

            @Override
            public void onSuccess(Object data) {
                VipGoodsModel vipGoodsModel = (VipGoodsModel) data;
                if (vipGoodsModel.getCode() == 1) {
                    Glide.with(getContext()).load(vipGoodsModel.getData().getVip_goods().getGoods_image()).into(ivVipGoods);
                    Glide.with(getContext()).load(vipGoodsModel.getData().getVip_banner().getFile_path()).into(ivBanner);


                }
            }
        });
    }


    @Override
    public void onResume() {
        super.onResume();
        if(isVip){
            if(fab.isShown()){
                fab.hide();
            }
        }
    }

    private void showDialog() {
        //展示
        tDialog = new TDialog.Builder(getFragmentManager())
                .setLayoutRes(R.layout.dialog_rob_members)    //设置弹窗展示的xml布局
//                .setDialogView(view)  //设置弹窗布局,直接传入View
                .setGravity(Gravity.CENTER)     //设置弹窗展示位置
                .setScreenWidthAspect(getContext(), 0.7f)
                .setDimAmount(0.6f)     //设置弹窗背景透明度(0-1f)
                .setCancelableOutside(false)     //弹窗在界面外是否可以点击取消
                .addOnClickListener(R.id.iv_close, R.id.go_vip)   //添加进行点击控件的id
                .setOnViewClickListener(new OnViewClickListener() {
                    @Override
                    public void onViewClick(BindViewHolder viewHolder, View view, TDialog tDialog) {
                        switch (view.getId()) {
                            case R.id.iv_close:
                                tDialog.dismiss();
                                fab.setVisibility(View.VISIBLE);

                                break;
                            case R.id.go_vip:
//                                EventBus.getDefault().post("5");
//                                EventBus.getDefault().post("4");
                                if (TextUtils.isEmpty(FastData.getToken())) {
                                    Intent intent = new Intent(getContext(), LoginActivity.class);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                                    startActivity(intent);
                                    return;
                                }
                                startActivity(new Intent(mContext, VipActivity.class));
                                tDialog.dismiss();
                                fab.setVisibility(View.VISIBLE);

                                break;
                        }
                    }
                })
                .create()   //创建TDialog
                .show();
        loaded = true;

    }

    private void initBanner() {

        banner.setAdapter(new BannerImageAdapter<BannerModel.DataBean>(bannerList) {
            @Override
            public void onBindView(BannerImageHolder holder, BannerModel.DataBean data, int position, int size) {
                //图片加载自己实现
                holder.imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                Glide.with(holder.itemView)
                        .load(data.getImage().getFile_path())
                        .into(holder.imageView);
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(data.getGoods_id()!=0){
                            Intent intent = new Intent(mContext, GoodsDetailActivity.class);
                            intent.putExtra("goods_id", data.getGoods_id() + "");
                            startActivity(intent);
                        }else if(data.getCategory_id()!=0){
                            Intent intent = new Intent(getContext(), GoodsListActivity.class);
                            intent.putExtra("category_id", data.getCategory_id() + "");
                            intent.putExtra("title", data.getCategory().getName() + "");
                            startActivity(intent);
                        }
                    }
                });
            }
        })
                .setBannerRound(20)
                .isAutoLoop(true);
    }

    private void initGoodMenus() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        goodsMenusAdapter = new GoodsMenusAdapter(getContext());
        recyclerView.setAdapter(goodsMenusAdapter);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int range = recyclerView.computeHorizontalScrollRange(); //全长度
                int extent = recyclerView.computeHorizontalScrollExtent(); // 当前显示的长度
                int offset = recyclerView.computeHorizontalScrollOffset(); //已滑动的偏移量

                //屏幕外的长度
                float wai = range - extent;
                // 已滑动长度的比例
                float huabi = (float) (offset * 1.0) / wai; //注意！！！，如果用Int型，会取整；

                int huafan = layoutProgress.getWidth() - vProgress.getWidth(); //可滑动范围
                float translationX = huabi * huafan; // view偏移量
                vProgress.setTranslationX(translationX);
            }
        });
        goodsMenusAdapter.setOnItemDataClickListener(new BaseAdapter.OnItemDataClickListener<IndexModel.DataBean.ListBean>() {
            @Override
            public void onItemViewClick(View view, int position, IndexModel.DataBean.ListBean o) {
                Intent intent = new Intent(getContext(), GoodsListActivity.class);
                intent.putExtra("category_id", o.getCategory_id() + "");
                intent.putExtra("title", o.getName() + "");
                startActivity(intent);
            }
        });
    }

    private void initRv1() {
        oneAdapter = new GoodsOneAdapter(getContext());
        oneAdapter.setOnItemDataClickListener(new BaseAdapter.OnItemDataClickListener<HomeModel.DataBean.VipGoodsBean>() {
            @Override
            public void onItemViewClick(View view, int position, HomeModel.DataBean.VipGoodsBean o) {
                isVip(o.getGoods_id() + "");

            }
        });
        rv1.setLayoutManager(new GridLayoutManager(getContext(), 3));
//        rv1.addItemDecoration(new CommItemDecoration(getContext(), DividerItemDecoration.HORIZONTAL, getResources().getColor(R.color.white1), 60));
        rv1.setAdapter(oneAdapter);
    }

    private void initRv2() {
        twoAdapter = new GoodsTwoAdapter(getContext());
        rv2.setLayoutManager(new GridLayoutManager(getContext(), 3));
        rv2.addItemDecoration(new CommItemDecoration(getContext(), DividerItemDecoration.VERTICAL, getResources().getColor(R.color.white), 60));
        rv2.setAdapter(twoAdapter);

        twoAdapter.setOnItemDataClickListener(new BaseAdapter.OnItemDataClickListener<HomeModel.DataBean.VideoGoodsBean>() {
            @Override
            public void onItemViewClick(View view, int position, HomeModel.DataBean.VideoGoodsBean o) {
                Intent intent = new Intent(getActivity(), GoodsVideoDetailActivity.class);
                intent.putExtra("dataBeanList", (Serializable) o);
                startActivity(intent);
            }
        });
    }

    private void initRv3() {
        titleAdapter = new TitleAdapter(getContext());
        rv3.setLayoutManager(new GridLayoutManager(getContext(), 4));
//        rv3.addItemDecoration(new CommItemDecoration(getContext(), DividerItemDecoration.HORIZONTAL, getResources().getColor(R.color.white), 60));
        rv3.setAdapter(titleAdapter);
        titleAdapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onItemViewClick(View view, int position) {
                titleAdapter.setPos(position);
                vpGoodsList.setCurrentItem(position);
            }
        });

    }

    private void initViewPager() {
        List<Fragment> fragments = new ArrayList<>();
        for (int i = 0; i < tagGoods.size(); i++) {
            if (tagGoods.get(i).getList().size() > 0) {
                goodListFragment = new GoodsFragment(tagGoods.get(i).getList());
            } else {
                goodListFragment = new GoodsFragment("1");
            }
            fragments.add(goodListFragment);
        }
        FragmentAdapter adatper = new FragmentAdapter(getFragmentManager(), fragments);
        vpGoodsList.setAdapter(adatper);
        vpGoodsList.setOffscreenPageLimit(fragments.size());

        vpGoodsList.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (lastValue > positionOffsetPixels) {
                    moveRight = true;
                } else if (lastValue < positionOffsetPixels) {
                    moveRight = false;
                }
                lastValue = positionOffsetPixels;
            }

            @Override
            public void onPageSelected(int position) {
                if (moveRight) {
                    titleAdapter.setPos(position);
                    rv3.scrollToPosition(position - 1);
                } else {
                    titleAdapter.setPos(position);
                    rv3.scrollToPosition(position);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void vipInfo() {
        if (TextUtils.isEmpty(FastData.getToken())) {
            showDialog();
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
                refresh.finishRefresh();
                UserDetailModel userDetailModel = (UserDetailModel) data;
                if (userDetailModel.getCode() == 1) {
                    if (userDetailModel.getData().getUserInfo().getIsVip() == 0) {
                        if (!loaded) {
                            showDialog();
                        }
                    } else {
                        isVip = true;
                        fab.hide();
                        if(tDialog!=null&&!tDialog.isHidden())
                        {
                            tDialog.dismiss();
                        }
                    }
                }
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN, priority = 100, sticky = false) //在ui线程执行，优先级为100
    public void onEvent(String event) {
        if (event.equals("9")) {
            vipInfo();

        }
    }

    private void isVip(String goods_id) {
        if (TextUtils.isEmpty(FastData.getToken())) {
            Intent intent = new Intent(getContext(), LoginActivity.class);
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
                refresh.finishRefresh();
                UserDetailModel userDetailModel = (UserDetailModel) data;
                if (userDetailModel.getCode() == 1) {

                    if (userDetailModel.getData().getUserInfo().getIsVip() == 0) {
                        startActivity(new Intent(mContext, VipActivity.class));
                    } else {
                        if (userDetailModel.getData().getUserInfo().getIs_exprire() == 0) {
                            Intent intent = new Intent(getContext(), GoodsDetailActivity.class);
                            intent.putExtra("goods_id", goods_id);
                            startActivity(intent);
                        } else {
                            startActivity(new Intent(mContext, VipActivity.class));

                        }
                    }
                }
            }
        });
    }

    private void isVipMore() {
        if (TextUtils.isEmpty(FastData.getToken())) {
            Intent intent = new Intent(getContext(), LoginActivity.class);
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
                refresh.finishRefresh();
                UserDetailModel userDetailModel = (UserDetailModel) data;
                if (userDetailModel.getCode() == 1) {

                    if (userDetailModel.getData().getUserInfo().getIsVip() == 0) {
                        startActivity(new Intent(mContext, VipActivity.class));
                    } else {
                        if (userDetailModel.getData().getUserInfo().getIs_exprire() == 0) {
                            Intent intent = new Intent(getContext(), VipListActivity.class);
                            startActivity(intent);
                        } else {
                            startActivity(new Intent(mContext, VipActivity.class));

                        }
                    }
                }
            }
        });
    }



    private void userInfo() {
        if (TextUtils.isEmpty(FastData.getToken())) {
            Intent intent = new Intent(getContext(), LoginActivity.class);
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
                refresh.finishRefresh();
                UserDetailModel userDetailModel = (UserDetailModel) data;
                if (userDetailModel.getCode() == 1) {

                    if (userDetailModel.getData().getUserInfo().getIsVip() == 0) {
                        startActivity(new Intent(mContext, VipActivity.class));
                    } else {
                        if (userDetailModel.getData().getUserInfo().getIs_exprire() == 0) {
                            EventBus.getDefault().post("5");
                        } else {
                            startActivity(new Intent(getContext(), VipRenewActivity.class));

                        }
                    }
                }
            }
        });
    }


    private void setImageViewSize(ImageView imageView, int width) {
        ViewGroup.LayoutParams params = imageView.getLayoutParams();
        params.width = width;
        imageView.setLayoutParams(params);
    }

    @OnClick({R.id.iv_comment, R.id.tv_search, R.id.tv_more, R.id.iv_go, R.id.iv_banner,R.id.tv_more_1})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_comment:
                Intent intent1 = new Intent(getContext(), MessageNewActivity.class);
                startActivity(intent1);
                break;
            case R.id.tv_search:
                Intent intent = new Intent(getContext(), SearchActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_more:
                EventBus.getDefault().post("3");
                break;
            case R.id.iv_go:
            case R.id.iv_banner:
                userInfo();
                break;
            case R.id.tv_more_1:
                isVipMore();
//                startActivity(new Intent(mContext, VipListActivity.class));
                break;
        }
    }


    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        initData();
    }


}



