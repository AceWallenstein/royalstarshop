package com.pinnoocle.royalstarshop.home.fragment;

import android.content.Intent;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pinnoocle.royalstarshop.MainActivity;
import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.adapter.GoodsMenusAdapter;
import com.pinnoocle.royalstarshop.adapter.GoodsOneAdapter;
import com.pinnoocle.royalstarshop.adapter.GoodsTwoAdapter;
import com.pinnoocle.royalstarshop.adapter.TitleAdapter;
import com.pinnoocle.royalstarshop.bean.IndexModel;
import com.pinnoocle.royalstarshop.bean.LoginBean;
import com.pinnoocle.royalstarshop.bean.LoginModel;
import com.pinnoocle.royalstarshop.bean.TitleBean;
import com.pinnoocle.royalstarshop.common.BaseAdapter;
import com.pinnoocle.royalstarshop.common.BaseFragment;
import com.pinnoocle.royalstarshop.home.activity.GoodsDetailActivity;
import com.pinnoocle.royalstarshop.login.LoginActivity;
import com.pinnoocle.royalstarshop.nets.DataRepository;
import com.pinnoocle.royalstarshop.nets.Injection;
import com.pinnoocle.royalstarshop.nets.RemotDataSource;
import com.pinnoocle.royalstarshop.utils.FastData;
import com.pinnoocle.royalstarshop.widget.CommItemDecoration;
import com.timmy.tdialog.TDialog;
import com.timmy.tdialog.base.BindViewHolder;
import com.timmy.tdialog.listener.OnViewClickListener;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class HomeFragment extends BaseFragment {
    @BindView(R.id.iv_comment)
    ImageView ivComment;
    @BindView(R.id.iv_kefu)
    ImageView ivKefu;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.ed_search)
    EditText edSearch;
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
    private List<Integer> bannerList = new ArrayList<>();
    private GoodsMenusAdapter goodsMenusAdapter;
    private DataRepository dataRepository;

    @Override
    protected int LayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {
        bannerList.add(R.mipmap.banner);
        initBanner();
        initGoodMenus();
        initRv1();
        initRv2();
        initRv3();
        initViewPager();
    }



    @Override
    protected void initData() {
        dataRepository = Injection.dataRepository(getContext());
        index();
    }

    private void index() {
        LoginBean loginBean = new LoginBean();
        loginBean.wxapp_id = "10001";
        dataRepository.index(loginBean,new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {

            }

            @Override
            public void onSuccess(Object data) {
                IndexModel indexModel = (IndexModel) data;
                if(indexModel.getCode() == 1){
                    List<IndexModel.DataBean.ListBean> list = indexModel.getData().getList();
                    if(list.size()<6){
                        layoutProgress.setVisibility(View.GONE);
                    }else {
                        layoutProgress.setVisibility(View.VISIBLE);

                    }
                    goodsMenusAdapter.setData(list);
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

        banner.isAutoLoop(false)
                .setAdapter(new BannerImageAdapter<Integer>(bannerList) {
                    @Override
                    public void onBindView(BannerImageHolder holder, Integer data, int position, int size) {
                        holder.imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                        //图片加载自己实现
                        Glide.with(holder.itemView)
                                .load(data)
                                .fitCenter()
                                .apply(RequestOptions.bitmapTransform(new RoundedCorners(30)))
                                .into(holder.imageView);
                    }
                })
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
    }

    private void initRv1() {
        GoodsOneAdapter oneAdapter = new GoodsOneAdapter(getContext());
        oneAdapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onItemViewClick(View view, int position) {
                startActivity(new Intent(getContext(), GoodsDetailActivity.class));
            }
        });
        rv1.setLayoutManager(new GridLayoutManager(getContext(), 3));
//        rv1.addItemDecoration(new CommItemDecoration(getContext(), DividerItemDecoration.HORIZONTAL, getResources().getColor(R.color.white1), 60));
        rv1.setAdapter(oneAdapter);
    }

    private void initRv2() {
        GoodsTwoAdapter twoAdapter = new GoodsTwoAdapter(getContext());
        rv2.setLayoutManager(new GridLayoutManager(getContext(), 3));
        rv2.addItemDecoration(new CommItemDecoration(getContext(), DividerItemDecoration.VERTICAL, getResources().getColor(R.color.white), 60));
        rv2.setAdapter(twoAdapter);
    }

    private void initRv3() {
        List<TitleBean> titleBeans = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            titleBeans.add(new TitleBean("热销爆款", "火爆商品"));
        }
        TitleAdapter titleAdapter = new TitleAdapter(getContext());
        titleAdapter.setData(titleBeans);
        rv3.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        rv3.addItemDecoration(new CommItemDecoration(getContext(), DividerItemDecoration.HORIZONTAL, getResources().getColor(R.color.white), 60));
        rv3.setAdapter(titleAdapter);
        titleAdapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onItemViewClick(View view, int position) {
                titleAdapter.setPos(position);
            }
        });

    }
    private void initViewPager() {
        List<Fragment> fragments = new ArrayList<>();
        for (int i = 0; i <4; i++) {
            GoodListFragment goodListFragment = new GoodListFragment();
            fragments.add(goodListFragment);
        };
        vpGoodsList.setAdapter(new FragmentPagerAdapter(getFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });
    }


    private void setImageViewSize(ImageView imageView, int width) {
        ViewGroup.LayoutParams params = imageView.getLayoutParams();
        params.width = width;
        imageView.setLayoutParams(params);
    }

}



