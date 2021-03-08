package com.pinnoocle.royalstarshop.widget;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;

import com.lxj.xpopup.core.BottomPopupView;
import com.pedaily.yc.ycdialoglib.toast.ToastUtils;
import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.bean.GoodsDetailModel;
import com.pinnoocle.royalstarshop.home.activity.TaskBigImgActivity;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

public class DialogShopCar extends BottomPopupView implements View.OnClickListener {


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
    private NumberButton numberButton;
    private TextView tvBuy;


    public DialogShopCar(@NonNull Context context, FragmentManager fm, GoodsDetailModel.DataBean.SpecDataBean specData) {
        super(context);
        this.fm = fm;
        this.context = context;
        this.specData = specData;
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
//        EventBus.getDefault().register(this);
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
        if (specData != null) {
            List<GoodsDetailModel.DataBean.SpecDataBean.SpecAttrBeanX> spec_attr = specData.getSpec_attr();
            initSpec(spec_attr);
        }
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

    private void viewPluImg(ArrayList<String> list, int index) {
        Intent imgIntent = new Intent(getContext(), TaskBigImgActivity.class);
        imgIntent.putStringArrayListExtra("paths", list);
        imgIntent.putExtra("position", index);
        getContext().startActivity(imgIntent);
    }


}