package com.pinnoocle.royalstarshop.home.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.core.BasePopupView;
import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pedaily.yc.ycdialoglib.toast.ToastUtils;
import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.adapter.FragmentTabAdapter;
import com.pinnoocle.royalstarshop.bean.CommentListModel;
import com.pinnoocle.royalstarshop.bean.GoodsDetailModel;
import com.pinnoocle.royalstarshop.bean.LoginBean;
import com.pinnoocle.royalstarshop.bean.ResultModel;
import com.pinnoocle.royalstarshop.bean.ServiceBean;
import com.pinnoocle.royalstarshop.bean.UserDetailModel;
import com.pinnoocle.royalstarshop.common.BaseActivity;
import com.pinnoocle.royalstarshop.home.fragment.GoodsTabCommentFragment;
import com.pinnoocle.royalstarshop.login.LoginActivity;
import com.pinnoocle.royalstarshop.nets.DataRepository;
import com.pinnoocle.royalstarshop.nets.Injection;
import com.pinnoocle.royalstarshop.nets.RemotDataSource;
import com.pinnoocle.royalstarshop.utils.FastData;
import com.pinnoocle.royalstarshop.utils.StatusBarUtil;
import com.pinnoocle.royalstarshop.utils.StatusBarUtils;
import com.pinnoocle.royalstarshop.vip.VipRenewActivity;
import com.pinnoocle.royalstarshop.widget.DialogPledge;
import com.pinnoocle.royalstarshop.widget.DialogShopCar;
import com.pinnoocle.royalstarshop.widget.VerticalMarqueeLayout;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;
import com.zzhoujay.richtext.ImageHolder;
import com.zzhoujay.richtext.RichText;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

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
    @BindView(R.id.iv_mark)
    ImageView ivMark;
    @BindView(R.id.ll_mark)
    LinearLayout llMark;
    @BindView(R.id.iv_shop_car)
    ImageView ivShopCar;
    @BindView(R.id.ll_shop_car)
    LinearLayout llShopCar;
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
    @BindView(R.id.banner_indicator)
    TextView bannerIndicator;
    @BindView(R.id.marquee_root)
    VerticalMarqueeLayout marqueeRoot;
    @BindView(R.id.tv_price)
    TextView tvPrice;
    @BindView(R.id.tv_vip_price)
    TextView tvVipPrice;
    @BindView(R.id.ll_add_shop_cart)
    LinearLayout llAddShopCart;
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
    @BindView(R.id.rl_pledge)
    RelativeLayout rlPledge;
    @BindView(R.id.tv_evaluation)
    TextView tvEvaluation;
    @BindView(R.id.tv_more)
    TextView tvMore;
    @BindView(R.id.rl_appraise)
    RelativeLayout rlAppraise;
    @BindView(R.id.rb_all)
    RadioButton rbAll;
    @BindView(R.id.rb_good)
    RadioButton rbGood;
    @BindView(R.id.rb_m)
    RadioButton rbM;
    @BindView(R.id.rb_bad)
    RadioButton rbBad;
    @BindView(R.id.radiogroup)
    RadioGroup radiogroup;
    @BindView(R.id.fl_layout)
    FrameLayout flLayout;
    @BindView(R.id.tv_content)
    TextView tvContent;
    @BindView(R.id.tv_comment_num)
    TextView tvCommentNum;
    private DataRepository dataRepository;
    private List<String> bannerList;
    private GoodsDetailModel.DataBean dataBean;
    private BasePopupView selectDialog;
    private GoodsDetailModel goodsDetailModel;
    private BasePopupView dialogPledge;
    private BasePopupView pledgePopupView;
    private List<Fragment> fragments = new ArrayList<>();
    private FragmentTabAdapter tabAdapter;


    protected void onCreate(Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.getDecorView().setSystemUiVisibility(android.view.View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | android.view.View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.white));
        }
        StatusBarUtil.StatusBarLightMode(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_goods_detail);
        ButterKnife.bind(this);
        RichText.initCacheDir(this);
        initView();
        initData();
    }

    private void initView() {
        String goods_id = getIntent().getStringExtra("goods_id");
        fragments.add(new GoodsTabCommentFragment(goods_id, ""));
        fragments.add(new GoodsTabCommentFragment(goods_id, "10"));
        fragments.add(new GoodsTabCommentFragment(goods_id, "20"));
        fragments.add(new GoodsTabCommentFragment(goods_id, "30"));
        tabAdapter = new FragmentTabAdapter(this, fragments, R.id.fl_layout);
        radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_all:
                        tabAdapter.setCurrentFragment(0);
                        break;
                    case R.id.rb_good:
                        tabAdapter.setCurrentFragment(1);
                        break;
                    case R.id.rb_m:
                        tabAdapter.setCurrentFragment(2);
                        break;
                    case R.id.rb_bad:
                        tabAdapter.setCurrentFragment(3);
                        break;
                }
            }
        });
    }

    private void initData() {
        dataRepository = Injection.dataRepository(this);
        goodsDetail();
        addGoodsLog();
        commentList();
    }

    private void addGoodsLog() {
        LoginBean loginBean = new LoginBean();
        loginBean.wxapp_id = "10001";
        loginBean.token = FastData.getToken();
        loginBean.goods_id = getIntent().getStringExtra("goods_id");
        ViewLoading.show(this);
        dataRepository.addGoodsLog(loginBean, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(mContext);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(mContext);
                ResultModel resultModel = (ResultModel) data;
                if (resultModel.getCode() == 1) {
                    EventBus.getDefault().post("4");
                }
            }
        });
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
                goodsDetailModel = (GoodsDetailModel) data;
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
                    if (goodsDetailModel.getData().getDetail().getIs_collect() == 0) {
                        ivMark.setImageResource(R.mipmap.mark);
                    } else {
                        ivMark.setImageResource(R.mipmap.mark_1);
                    }
                    dataBean = goodsDetailModel.getData();
                    initBanner(images);
                    RichText.from(goodsDetailModel.getData().getDetail().getContent()).bind(this)
                            .showBorder(false)
                            .autoPlay(false)
                            .size(ImageHolder.MATCH_PARENT, ImageHolder.WRAP_CONTENT)
                            .into(tvContent);

                }
            }
        });
    }

    private void goodsCollect() {
        if (TextUtils.isEmpty(FastData.getToken())) {
            Intent intent = new Intent(this, LoginActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
            return;
        }

        LoginBean loginBean = new LoginBean();
        loginBean.wxapp_id = "10001";
        loginBean.token = FastData.getToken();
        loginBean.goods_id = getIntent().getStringExtra("goods_id");
        loginBean.goods_sku_id = goodsDetailModel.getData().getDetail().getGoods_sku().getGoods_sku_id() + "";
        ViewLoading.show(this);
        dataRepository.goodsCollect(loginBean, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(mContext);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(mContext);
                ResultModel resultModel = (ResultModel) data;
                if (resultModel.getCode() == 1) {
                    goodsDetail();
                }
                ToastUtils.showToast(resultModel.getMsg());
            }
        });
    }

    private void commentList() {
        LoginBean loginBean = new LoginBean();
        loginBean.wxapp_id = "10001";
        loginBean.token = FastData.getToken();
        loginBean.goods_id = getIntent().getStringExtra("goods_id");
        ViewLoading.show(this);
        dataRepository.commentList(loginBean, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(mContext);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(mContext);
                CommentListModel commentListModel = (CommentListModel) data;
                if (commentListModel.getCode() == 1) {
                    int all = commentListModel.getData().getTotal().getAll();
                    int goods = commentListModel.getData().getTotal().getPraise();
                    int review = commentListModel.getData().getTotal().getReview();
                    int bad = commentListModel.getData().getTotal().getNegative();
                    String all_ = dealNum(all);
                    String goods_ = dealNum(goods);
                    String review_ = dealNum(review);
                    String bad_ = dealNum(bad);
                    tvCommentNum.setText("("+all_+")");
                    rbAll.setText("全部(" + all_ + ")");
                    rbGood.setText("好评(" + goods_ + ")");
                    rbM.setText("中评(" + review_ + ")");
                    rbBad.setText("差评(" + bad_ + ")");
                }

            }
        });
    }

    private void userInfo() {
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
                    if (userDetailModel.getData().getUserInfo().getIsVip() == 1) {
                        showSelectDialog("vip");
                    } else {
                        EventBus.getDefault().post("5");
                        finish();
                    }
                }
            }
        });
    }


    private String dealNum(int all) {
        if (all > 99) {
            return "99+";
        }
        return all + "";
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


    private void showSelectDialog(String type) {
        if (dataBean != null) {
            selectDialog = new XPopup.Builder(this)
                    .enableDrag(false)
                    .asCustom(new DialogShopCar(this, getSupportFragmentManager(), dataBean, type));
            selectDialog.show();

        }
    }

    private void showPledgeDialog() {
        List<ServiceBean> service = new ArrayList<>();
        service.add(new ServiceBean("假一赔十", "商家质保产品正品，如发现假货直接上报投诉，平台将会严重处理，返退钱款并给予奖励。", R.mipmap.compensation));
        service.add(new ServiceBean("7天无理由退换", "商家产品支持7天无理由退换货。", R.mipmap.retreat));
        service.add(new ServiceBean("免费上门安装", "商家免费上门安装，免费送货上门，也可联系当地的门店工作人员协商上门安装具体事项。", R.mipmap.free));
        dialogPledge = new DialogPledge(this, service);
        if (pledgePopupView == null) {
            pledgePopupView = new XPopup.Builder(this)
                    .enableDrag(false)
                    .asCustom(dialogPledge);
        }
        pledgePopupView.show();

    }


    @OnClick({R.id.ll_customer_service, R.id.ll_shop_car, R.id.ll_mark, R.id.ll_vip_buy, R.id.ll_normal_buy, R.id.tv_more, R.id.ll_add_shop_cart, R.id.iv_back, R.id.rl_pledge})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_customer_service:
                break;
            case R.id.ll_shop_car:
                EventBus.getDefault().postSticky("to_shop_cart");
                finish();
                break;
            case R.id.ll_mark:
                goodsCollect();
                break;
            case R.id.ll_vip_buy:
                userInfo();

                break;
            case R.id.ll_normal_buy:
                showSelectDialog("normal");
                break;
            case R.id.tv_more:
                Intent intent = new Intent(this, GoodsCommentActivity.class);
                intent.putExtra("goods_id", getIntent().getStringExtra("goods_id"));
                startActivity(intent);
                break;
            case R.id.ll_add_shop_cart:
                showSelectDialog("add_shop_cart");
                break;
            case R.id.iv_back:
                finish();
                break;
            case R.id.rl_pledge:
                showPledgeDialog();
                break;
        }
    }


}
