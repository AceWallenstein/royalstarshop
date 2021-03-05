package com.pinnoocle.royalstarshop.home.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.bean.GoodsDetailModel;
import com.pinnoocle.royalstarshop.bean.LoginBean;
import com.pinnoocle.royalstarshop.common.BaseActivity;
import com.pinnoocle.royalstarshop.nets.DataRepository;
import com.pinnoocle.royalstarshop.nets.Injection;
import com.pinnoocle.royalstarshop.nets.RemotDataSource;
import com.pinnoocle.royalstarshop.widget.NoScrollViewPager;
import com.pinnoocle.royalstarshop.widget.VerticalMarqueeLayout;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GoodsDetailActivity extends BaseActivity {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.iv_customer_service)
    ImageView ivCustomerService;
    @BindView(R.id.ll_customer_service)
    LinearLayout llCustomerService;
    @BindView(R.id.iv_shop_car)
    ImageView ivShopCar;
    @BindView(R.id.ll_shop_car)
    LinearLayout llShopCar;
    @BindView(R.id.iv_mark)
    ImageView ivMark;
    @BindView(R.id.ll_mark)
    LinearLayout llMark;
    @BindView(R.id.tv_normal_price)
    TextView tvNormalPrice;
    @BindView(R.id.tv_normal_buy)
    TextView tvNormalBuy;
    @BindView(R.id.ll_normal_buy)
    LinearLayout llNormalBuy;
    @BindView(R.id.tv_vip_price_1)
    TextView tvVipPrice1;
    @BindView(R.id.tv_vip_buy)
    TextView tvVipBuy;
    @BindView(R.id.ll_vip_buy)
    LinearLayout llVipBuy;
    @BindView(R.id.ll_buy)
    LinearLayout llBuy;
    @BindView(R.id.goods_banner)
    Banner goodsBanner;
    @BindView(R.id.marquee_root)
    VerticalMarqueeLayout marqueeRoot;
    @BindView(R.id.tv_price)
    TextView tvPrice;
    @BindView(R.id.tv_vip_price)
    TextView tvVipPrice;
    @BindView(R.id.ll_price)
    RelativeLayout llPrice;
    @BindView(R.id.tv_active)
    TextView tvActive;
    @BindView(R.id.tv_goods_title)
    TextView tvGoodsTitle;
    @BindView(R.id.rl_goods_title)
    RelativeLayout rlGoodsTitle;
    @BindView(R.id.tv_compensation)
    TextView tvCompensation;
    @BindView(R.id.tv_retreat)
    TextView tvRetreat;
    @BindView(R.id.tv_free)
    TextView tvFree;
    @BindView(R.id.tv_evaluation)
    TextView tvEvaluation;
    @BindView(R.id.tv_more)
    TextView tvMore;
    @BindView(R.id.rl_appraise)
    RelativeLayout rlAppraise;
    @BindView(R.id.flowlayout)
    TagFlowLayout flowlayout;
    @BindView(R.id.viewPager)
    NoScrollViewPager viewPager;
    @BindView(R.id.tv_content)
    TextView tvContent;
    @BindView(R.id.banner_indicator)
    TextView bannerIndicator;
    private DataRepository dataRepository;
    private List<String> bannerList;

    protected void onCreate(Bundle savedInstanceState) {
        initWhite();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_goods_detail);
        ButterKnife.bind(this);
//        RichText.initCacheDir(this);
        initView();
        initData();
    }

    private void initView() {

    }

    private void initData() {
        dataRepository = Injection.dataRepository(this);
        goodsDetail();
    }

    private void goodsDetail() {
        LoginBean loginBean = new LoginBean();
        loginBean.wxapp_id = "10001";
        loginBean.goods_id = getIntent().getStringExtra("goods_id");
        ViewLoading.show(this);
        dataRepository.goodsDetail(loginBean, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(mContext);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(mContext);
                GoodsDetailModel goodsDetailModel = (GoodsDetailModel) data;
                if (goodsDetailModel.getCode() == 1) {
                    tvPrice.setText("￥" + goodsDetailModel.getData().getDetail().getGoods_sku().getGoods_price());
                    tvVipPrice.setText("会员价￥" + goodsDetailModel.getData().getDetail().getGoods_sku().getBalance_price());
                    tvNormalPrice.setText("￥" + goodsDetailModel.getData().getDetail().getGoods_sku().getGoods_price());
                    tvVipPrice1.setText("￥" + goodsDetailModel.getData().getDetail().getGoods_sku().getBalance_price());
                    tvGoodsTitle.setText(goodsDetailModel.getData().getDetail().getGoods_name());
                    List<String> images = new ArrayList<>();
                    List<GoodsDetailModel.DataBean.DetailBean.ImageBean> image = goodsDetailModel.getData().getDetail().getImage();
                    for (int i = 0; i < image.size(); i++) {
                        images.add(image.get(i).getFile_path());
                    }
                    initBanner(images);
                }
            }
        });
    }

    private void initBanner(List<String> album) {
        bannerList = new ArrayList<>();
        bannerList = album;
        goodsBanner.isAutoLoop(false)
                .setAdapter(new BannerImageAdapter<String>(bannerList) {
                    @Override
                    public void onBindView(BannerImageHolder holder, String data, int position, int size) {
                        holder.imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                        //图片加载自己实现
                        Glide.with(holder.itemView)
                                .load(data)
                                .fitCenter()
                                .into(holder.imageView);
                    }
                })
                .isAutoLoop(false);
        bannerIndicator.setText("1/" + bannerList.size());

    }

}
