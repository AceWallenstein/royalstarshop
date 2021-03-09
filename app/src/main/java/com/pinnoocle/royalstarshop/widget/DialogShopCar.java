package com.pinnoocle.royalstarshop.widget;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;

import com.bumptech.glide.Glide;
import com.lxj.xpopup.core.BottomPopupView;
import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pedaily.yc.ycdialoglib.toast.ToastUtils;
import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.bean.CartAddModel;
import com.pinnoocle.royalstarshop.bean.GoodsDetailModel;
import com.pinnoocle.royalstarshop.bean.LoginBean;
import com.pinnoocle.royalstarshop.bean.OrderCartModel;
import com.pinnoocle.royalstarshop.bean.ResultModel;
import com.pinnoocle.royalstarshop.bean.SureOrderModel;
import com.pinnoocle.royalstarshop.event.ShopCartRefreshEvent;
import com.pinnoocle.royalstarshop.event.TagRefleshEvent;
import com.pinnoocle.royalstarshop.home.activity.TaskBigImgActivity;
import com.pinnoocle.royalstarshop.mine.activity.OrderConfirmActivity;
import com.pinnoocle.royalstarshop.nets.DataRepository;
import com.pinnoocle.royalstarshop.nets.Injection;
import com.pinnoocle.royalstarshop.nets.RemotDataSource;
import com.pinnoocle.royalstarshop.utils.FastData;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DialogShopCar extends BottomPopupView implements View.OnClickListener {

    private GoodsDetailModel.DataBean dataBean;
    private String spec_sku_id;
    private GoodsDetailModel.DataBean.SpecDataBean specData;
    private FragmentManager fm;
    private List<SkuView> skuViews = new ArrayList<>();
    private ArrayList<String> imageList = new ArrayList<>();
    private Context context;
    private ImageView ivShop;
    private TextView tvPrice;
    private TextView tvStock;
    private ImageView ivClose;
    private LinearLayout mSkuView;
    private NumberButton1 numberButton;
    private TextView tvBuy;
    private List<String> item_ids = new ArrayList<>();
    private DataRepository dataRepository;
    private String item_id;
    private String type;
    private int goods_sku_id;


    public DialogShopCar(@NonNull Context context, FragmentManager fm, GoodsDetailModel.DataBean dataBean, String type) {
        super(context);
        this.fm = fm;
        this.context = context;
        this.dataBean = dataBean;
        this.specData = dataBean.getSpecData();
        this.spec_sku_id = dataBean.getDetail().getGoods_sku().getSpec_sku_id();
        this.type = type;
    }

    @Override
    protected int getImplLayoutId() {
        return R.layout.dialog_shop_car;
    }

    @Override
    protected void onCreate() {
        super.onCreate();
        initView();
        initListener();
//        initNumberButton(numberButton);
        EventBus.getDefault().register(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }


    private void initListener() {
        ivClose.setOnClickListener(this);
        ivShop.setOnClickListener(this);
        tvBuy.setOnClickListener(this);

    }

    private void initView() {

        ivShop = findViewById(R.id.iv_shop);
        tvPrice = findViewById(R.id.tv_price);
        tvStock = findViewById(R.id.tv_stock);
        ivClose = findViewById(R.id.iv_close);
        mSkuView = findViewById(R.id.mSkuView);
        numberButton = findViewById(R.id.number_button);
        tvBuy = findViewById(R.id.tv_buy);

        initData();
    }

    private void initData() {
        dataRepository = Injection.dataRepository(getContext());
        if (specData != null) {
            List<GoodsDetailModel.DataBean.SpecDataBean.SpecAttrBeanX> spec_attr = specData.getSpec_attr();
            initSpec(spec_attr);

        }
        GoodsDetailModel.DataBean.DetailBean.GoodsSkuBean goods_sku = dataBean.getDetail().getGoods_sku();
        Glide.with(context).load(goods_sku.getImage()).fitCenter().into(ivShop);
        tvStock.setText("库存" + goods_sku.getStock_num() + "件");
        if (type.equals("vip")) {
            tvPrice.setText("￥" + goods_sku.getBalance_price());
        } else {
            tvPrice.setText("￥" + goods_sku.getGoods_price());
        }
        goods_sku_id = goods_sku.getGoods_sku_id();
    }

    private void initSpec(List<GoodsDetailModel.DataBean.SpecDataBean.SpecAttrBeanX> spec_attr) {

        for (int i = 0; i < spec_attr.size(); i++) {
            String group_name = spec_attr.get(i).getGroup_name();
            SkuView skuView = new SkuView(context);
            List<GoodsDetailModel.DataBean.SpecDataBean.SpecAttrBeanX.SpecItemsBeanX> spec_items = spec_attr.get(i).getSpec_items();
            skuView.setSkuData(group_name, spec_items);
            skuViews.add(skuView);
            mSkuView.addView(skuView);
        }
    }

    private void getProductInfo(String id) {
        item_ids.clear();
        for (int i = 0; i < skuViews.size(); i++) {
            Integer next = skuViews.get(i).getFlowlayout().getSelectedList().iterator().next();
            String item_id = skuViews.get(i).getData().get(next).getItem_id();
            item_ids.add(item_id);
        }
        if (item_ids.size() == skuViews.size()) {
            item_id = "";
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < item_ids.size(); i++) {
                if (i == item_ids.size() - 1) {
                    sb.append(item_ids.get(i));
                } else {
                    sb.append(item_ids.get(i) + "_");
                }
            }
            item_id = sb.toString();
            List<GoodsDetailModel.DataBean.SpecDataBean.SpecListBeanX> spec_list = specData.getSpec_list();
            for (int i = 0; i < spec_list.size(); i++) {
                if (spec_list.get(i).getSpec_sku_id().equals(item_id)) {
                    goods_sku_id = spec_list.get(i).getGoods_sku_id();
                    GoodsDetailModel.DataBean.SpecDataBean.SpecListBeanX.FormBeanX form = spec_list.get(i).getForm();
                    Glide.with(context).load(form.getImage_path()).fitCenter().into(ivShop);
                    tvStock.setText("库存" + form.getStock_num() + "件");
                    tvPrice.setText("￥" + form.getGoods_price());
                }

            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_close:
                dismiss();
                break;
            case R.id.tv_buy:
                if (skuViews.size() != 0) {

                    if (skuViews.get(0).isSelectNone()) {
                        ToastUtils.showToast("请选择商品规格");
                        return;
                    }
                    if(type.equals("add_shop_cart")){
                        cartAdd();
                    }else {
                        sureOrder();
                    }
                }

//                ToastUtils.showToast("暂不支持支付");
//                Intent intent = new Intent(getContext(), OrderConfirmActivity.class);
//                getContext().startActivity(intent);
                break;
            case R.id.iv_shop:
                viewPluImg(imageList, 0);
                break;
        }
    }

    private void sureOrder() {
        Map<String, String> map = new HashMap<>();
        map.put("wxapp_id", "10001");
        map.put("token", FastData.getToken());
        map.put("goods_id", dataBean.getDetail().getGoods_id() + "");
        map.put("goods_sku_id", goods_sku_id + "");
        map.put("goods_num", numberButton.getNumber() + "");
        ViewLoading.show(context);
        dataRepository.sureOrder(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(context);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(context);
                SureOrderModel sureOrderModel = (SureOrderModel) data;
                if (sureOrderModel.getCode() == 1) {
                    Intent intent = new Intent(context, OrderConfirmActivity.class);
                    intent.putExtra("sureOrderData", sureOrderModel.getData());
                    context.startActivity(intent);
                }
//                ToastUtils.showToast(sureOrderModel.getMsg());
            }
        });
    }

    private void cartAdd() {
        ViewLoading.show(getContext());
        LoginBean loginBean = new LoginBean();
        loginBean.wxapp_id = "10001";
        loginBean.token = FastData.getToken();
        loginBean.goods_id = dataBean.getDetail().getGoods_id() + "";
        loginBean.goods_sku_id = goods_sku_id+"";
        loginBean.goods_num = numberButton.getNumber() + "";
        dataRepository.cartAdd(loginBean, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(getContext());
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(getContext());
                CartAddModel cartAddModel = (CartAddModel) data;
                if(cartAddModel.getCode() == 1){
                    EventBus.getDefault().post(new ShopCartRefreshEvent());
                }
                ToastUtils.showToast(cartAddModel.getMsg());
            }
        });
    }



    private void viewPluImg(ArrayList<String> list, int index) {
        Intent imgIntent = new Intent(getContext(), TaskBigImgActivity.class);
        imgIntent.putStringArrayListExtra("paths", list);
        imgIntent.putExtra("position", index);
        getContext().startActivity(imgIntent);
    }

    @Subscribe(threadMode = ThreadMode.MAIN, priority = 100, sticky = false) //在ui线程执行，优先级为100
    public void onEvent(TagRefleshEvent event) {
        String id = event.getId();
        getProductInfo(id);
    }


}