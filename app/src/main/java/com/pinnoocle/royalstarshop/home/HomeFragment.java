package com.pinnoocle.royalstarshop.home;

import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.adapter.GoodsMenusAdapter;
import com.pinnoocle.royalstarshop.common.BaseFragment;
import com.pinnoocle.royalstarshop.widget.CommItemDecoration;
import com.timmy.tdialog.TDialog;
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
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.v_progress)
    View vProgress;
    @BindView(R.id.layout)
    RelativeLayout layoutProgress;
    private List<Integer> bannerList = new ArrayList<>();

    @Override
    protected int LayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {
        bannerList.add(R.mipmap.banner);
        initBanner();
        initGoodMenus();
    }

    @Override
    public void onResume() {
        super.onResume();
        showDialog();
    }

    private void showDialog() {
        TDialog tDialog = new TDialog.Builder(getFragmentManager())
                .setLayoutRes(R.layout.dialog_rob_members)    //设置弹窗展示的xml布局
                .setCancelableOutside(false)
//                .setDialogView(view)  //设置弹窗布局,直接传入View
                .setGravity(Gravity.CENTER)     //设置弹窗展示位置
                .setDimAmount(0.6f)     //设置弹窗背景透明度(0-1f)
                .setCancelableOutside(false)     //弹窗在界面外是否可以点击取消
//                        .setDialogAnimationRes(R.style.animate_dialog)  //设置弹窗动画
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
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext() , LinearLayoutManager.HORIZONTAL , false));
        recyclerView.addItemDecoration(new CommItemDecoration(getContext(), DividerItemDecoration.HORIZONTAL, getResources().getColor(R.color.white1), 25));
        recyclerView.setAdapter(new GoodsMenusAdapter(getContext()));
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
                float wai = range - extent ;
                // 已滑动长度的比例
                float huabi = (float) (offset * 1.0) / wai; //注意！！！，如果用Int型，会取整；

                int huafan = layoutProgress.getWidth() - vProgress.getWidth(); //可滑动范围
                float translationX = huabi * huafan; // view偏移量
                vProgress.setTranslationX(translationX);
            }
        });
    }


}



