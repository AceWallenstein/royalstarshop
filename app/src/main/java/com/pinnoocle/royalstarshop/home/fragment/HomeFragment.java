package com.pinnoocle.royalstarshop.home.fragment;

import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.adapter.FragmentTabAdapter;
import com.pinnoocle.royalstarshop.common.BaseFragment;
import com.pinnoocle.royalstarshop.utils.FontDisplayUtil;
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
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.iv_tab_1)
    ImageView ivTab1;
    @BindView(R.id.iv_tab_2)
    ImageView ivTab2;
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
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new TabFragment());
        fragments.add(new TabFragment());
        viewPager.setAdapter(new FragmentPagerAdapter(getFragmentManager()) {
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
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    ivTab1.setImageResource(R.drawable.tab_rect);
                    ivTab2.setImageResource(R.drawable.tab_rect_1);
                    setImageViewSize(ivTab1, FontDisplayUtil.dip2px(getContext(), 15));
                    setImageViewSize(ivTab2, FontDisplayUtil.dip2px(getContext(), 6));

                } else if (position == 1) {
                    ivTab1.setImageResource(R.drawable.tab_rect_1);
                    ivTab2.setImageResource(R.drawable.tab_rect);
                    setImageViewSize(ivTab1, FontDisplayUtil.dip2px(getContext(), 6));
                    setImageViewSize(ivTab2, FontDisplayUtil.dip2px(getContext(), 15));
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

}



