package com.pinnoocle.royalstarshop.home.fragment;

import android.content.Intent;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
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
import com.pinnoocle.royalstarshop.common.BaseAdapter;
import com.pinnoocle.royalstarshop.common.BaseFragment;
import com.pinnoocle.royalstarshop.home.activity.CommentActivity;
import com.pinnoocle.royalstarshop.home.activity.GoodsDetailActivity;
import com.pinnoocle.royalstarshop.home.activity.GoodsListActivity;
import com.pinnoocle.royalstarshop.home.activity.GoodsVideoDetailActivity;
import com.pinnoocle.royalstarshop.home.activity.SearchActivity;
import com.pinnoocle.royalstarshop.nets.DataRepository;
import com.pinnoocle.royalstarshop.nets.Injection;
import com.pinnoocle.royalstarshop.nets.RemotDataSource;
import com.pinnoocle.royalstarshop.widget.CommItemDecoration;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.timmy.tdialog.TDialog;
import com.timmy.tdialog.base.BindViewHolder;
import com.timmy.tdialog.listener.OnViewClickListener;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;

import org.greenrobot.eventbus.EventBus;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class HomeFragment extends BaseFragment implements OnRefreshListener {
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
    @BindView(R.id.scrollView)
    NestedScrollView scrollView;
    @BindView(R.id.tv_1)
    TextView tv1;
    @BindView(R.id.tv_vip_1)
    TextView tvVip1;
    @BindView(R.id.rv_1)
    RecyclerView rv1;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.rv_2)
    RecyclerView rv2;
    @BindView(R.id.rv_3)
    RecyclerView rv3;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.v_progress)
    View vProgress;
    @BindView(R.id.layout)
    RelativeLayout layoutProgress;
    @BindView(R.id.vp_goods_list)
    ViewPager vpGoodsList;
    @BindView(R.id.iv_bg)
    ImageView ivBg;
    @BindView(R.id.tv_more)
    TextView tvMore;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
    private List<String> bannerList = new ArrayList<>();
    private GoodsMenusAdapter goodsMenusAdapter;
    private DataRepository dataRepository;
    private GoodsOneAdapter oneAdapter;
    private GoodsTwoAdapter twoAdapter;
    private TitleAdapter titleAdapter;
    private List<HomeModel.DataBean.TagGoodsBean> tagGoods = new ArrayList<>();
    private GoodsFragment goodListFragment;
    private int lastValue;
    private boolean moveRight;

    @Override
    protected int LayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {

        initGoodMenus();
        initRv1();
        initRv2();
        initRv3();
        refresh.setOnRefreshListener(this);
    }


    @Override
    protected void initData() {
        dataRepository = Injection.dataRepository(getContext());
        index();
        banner();
        home();
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
                    for (int i = 0; i < bannerModel.getData().size(); i++) {
                        bannerList.add(bannerModel.getData().get(i).getImage().getFile_path());
                    }
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


    @Override
    public void onResume() {
        super.onResume();
//        showDialog();
    }

    private void showDialog() {
        TDialog tDialog = new TDialog.Builder(getFragmentManager())
                .setLayoutRes(R.layout.dialog_rob_members)    //设置弹窗展示的xml布局
//                .setDialogView(view)  //设置弹窗布局,直接传入View
                .setGravity(Gravity.CENTER)     //设置弹窗展示位置
                .setScreenWidthAspect(getContext(), 0.7f)
                .setDimAmount(0.6f)     //设置弹窗背景透明度(0-1f)
                .setCancelableOutside(false)     //弹窗在界面外是否可以点击取消
                .addOnClickListener(R.id.iv_close)   //添加进行点击控件的id
                .setOnViewClickListener(new OnViewClickListener() {
                    @Override
                    public void onViewClick(BindViewHolder viewHolder, View view, TDialog tDialog) {
                        switch (view.getId()) {
                            case R.id.iv_close:
                                tDialog.dismiss();
                                break;
                        }
                    }
                })
                .create()   //创建TDialog
                .show();//展示

    }

    private void initBanner() {

        banner.setAdapter(new BannerImageAdapter<String>(bannerList) {
            @Override
            public void onBindView(BannerImageHolder holder, String data, int position, int size) {
                //图片加载自己实现
                holder.imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                Glide.with(holder.itemView)
                        .load(data)
                        .into(holder.imageView);
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
                Intent intent = new Intent(getContext(), GoodsDetailActivity.class);
                intent.putExtra("goods_id", o.getGoods_id() + "");
                startActivity(intent);
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


    private void setImageViewSize(ImageView imageView, int width) {
        ViewGroup.LayoutParams params = imageView.getLayoutParams();
        params.width = width;
        imageView.setLayoutParams(params);
    }

    @OnClick({R.id.iv_comment, R.id.tv_search, R.id.tv_more})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_comment:
                Intent intent1 = new Intent(getContext(), CommentActivity.class);
                startActivity(intent1);
                break;
            case R.id.tv_search:
                Intent intent = new Intent(getContext(), SearchActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_more:
                EventBus.getDefault().post("3");
                break;
        }
    }


    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        initData();
    }
}



