package com.pinnoocle.royalstarshop.mine.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.adapter.OrderConfirmAdapter;
import com.pinnoocle.royalstarshop.bean.AddressListModel;
import com.pinnoocle.royalstarshop.bean.SureOrderModel;
import com.pinnoocle.royalstarshop.common.BaseActivity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OrderConfirmActivity extends BaseActivity {
    @BindView(R.id.iv_bg)
    ImageView ivBg;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.tv_address)
    TextView tvAddress;
    @BindView(R.id.rl_address)
    RelativeLayout rlAddress;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.iv_weixin_pay)
    ImageView ivWeixinPay;
    @BindView(R.id.iv_alipay)
    ImageView ivAlipay;
    @BindView(R.id.tv_total)
    TextView tvTotal;
    @BindView(R.id.tv_total_price)
    TextView tvTotalPrice;
    @BindView(R.id.tv_discount)
    TextView tvDiscount;
    @BindView(R.id.tv_settlement)
    TextView tvSettlement;
    @BindView(R.id.rl_panel)
    RelativeLayout rlPanel;
    private SureOrderModel.DataBean sureOrderData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initWhite();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_confirm);
        ButterKnife.bind(this);
        initView();
        initData();
    }


    private void initView() {

    }

    private void initData() {
        if (getIntent().getSerializableExtra("sureOrderData") != null) {
            Serializable serializableExtra = getIntent().getSerializableExtra("sureOrderData");
            sureOrderData = (SureOrderModel.DataBean) serializableExtra;
            if (sureOrderData.getAddress() != null) {

                tvName.setText(sureOrderData.getAddress().getName());
                tvPhone.setText(sureOrderData.getAddress().getPhone());
                tvAddress.setText(sureOrderData.getAddress().getRegion().toString());
            }
            tvTotalPrice.setText(sureOrderData.getOrder_total_price());
            OrderConfirmAdapter adapter = new OrderConfirmAdapter(this);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            adapter.setData( sureOrderData.getGoods_list());
            recyclerView.setAdapter(adapter);
        }

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (data.getSerializableExtra("result") != null) {
                Serializable result = data.getSerializableExtra("result");
                AddressListModel.DataBean.ListBean  userShipBean = (AddressListModel.DataBean.ListBean) result;
                if (userShipBean == null) {
                    return;
                }
                tvName.setText(userShipBean.getName());
                String phone = userShipBean.getPhone().replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
                tvPhone.setText(phone);
                tvAddress.setText(userShipBean.getRegion().getProvince()+ userShipBean.getRegion().getCity() + userShipBean.getRegion().getRegion());
            }
        }
    }

    @OnClick({R.id.iv_back, R.id.rl_address, R.id.tv_settlement})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.rl_address:
                Intent intent = new Intent(this, AddressActivity.class);
                intent.putExtra("from", "from");
                startActivityForResult(intent, 9);

                break;
            case R.id.tv_settlement:
                break;
        }
    }
}
