package com.pinnoocle.royalstarshop.mine.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.adapter.OrderDetailAdapter;
import com.pinnoocle.royalstarshop.bean.LoginBean;
import com.pinnoocle.royalstarshop.bean.RefundDetailModel;
import com.pinnoocle.royalstarshop.common.BaseActivity;
import com.pinnoocle.royalstarshop.nets.DataRepository;
import com.pinnoocle.royalstarshop.nets.Injection;
import com.pinnoocle.royalstarshop.nets.RemotDataSource;
import com.pinnoocle.royalstarshop.utils.FastData;

import org.angmarch.views.NiceSpinner;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AfterSalesDetailActivity extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.iv_bg)
    ImageView ivBg;
    @BindView(R.id.tv_status)
    TextView tvStatus;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.iv_gps)
    ImageView ivGps;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.tv_address)
    TextView tvAddress;
    @BindView(R.id.rl_address)
    RelativeLayout rlAddress;
    @BindView(R.id.tv_order_time)
    TextView tvOrderTime;
    @BindView(R.id.tv_order_code_1)
    TextView tvOrderCode1;
    @BindView(R.id.tv_order_code)
    TextView tvOrderCode;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.tv_goods_money)
    TextView tvGoodsMoney;
    @BindView(R.id.tv_goods_freight)
    TextView tvGoodsFreight;
    @BindView(R.id.tv_goods_points)
    TextView tvGoodsPoints;
    @BindView(R.id.tv_pay_money)
    TextView tvPayMoney;
    @BindView(R.id.after_sales_type)
    TextView afterSalesType;
    @BindView(R.id.after_sales_reason)
    TextView afterSalesReason;
    @BindView(R.id.ll_after_sales)
    LinearLayout llAfterSales;
    @BindView(R.id.nice_spinner)
    NiceSpinner niceSpinner;
    @BindView(R.id.iv_money)
    ImageView ivMoney;
    @BindView(R.id.rl_money)
    RelativeLayout rlMoney;
    @BindView(R.id.scrollView)
    NestedScrollView scrollView;
    @BindView(R.id.iv_mark)
    ImageView ivMark;
    @BindView(R.id.ll_status)
    LinearLayout llStatus;
    @BindView(R.id.tv_sure)
    TextView tvSure;
    @BindView(R.id.rl_beans)
    RelativeLayout rlBeans;
    private DataRepository dataRepository;
    private OrderDetailAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initWhite();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_sales_detail);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    private void initView() {
        NiceSpinner niceSpinner = findViewById(R.id.nice_spinner);
        niceSpinner.setBackgroundResource(R.drawable.bg_stroke_3);
        niceSpinner.setTextSize(14);
        List<String> dataset = new LinkedList<>(Arrays.asList("中通快递", "申通快递", "韵达快递"));
        niceSpinner.attachDataSource(dataset);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new OrderDetailAdapter(this);
        recyclerView.setAdapter(adapter);

    }

    private void initData() {
        dataRepository = Injection.dataRepository(this);
        refundDetail();
    }


    private void refundDetail() {
        LoginBean loginBean = new LoginBean();
        loginBean.wxapp_id = "10001";
        loginBean.token = FastData.getToken();
        loginBean.order_refund_id = getIntent().getStringExtra("order_refund_id");

        ViewLoading.show(this);
        dataRepository.refundDetail(loginBean, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(mContext);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(mContext);
                RefundDetailModel refundDetailModel = (RefundDetailModel) data;
                if (refundDetailModel.getCode() == 1) {
                    tvStatus.setText(refundDetailModel.getData().getDetail().getState_text());
                    if (refundDetailModel.getData().getDetail().getAddress() != null) {
                        tvName.setText(refundDetailModel.getData().getDetail().getAddress().getName());
                        tvPhone.setText(refundDetailModel.getData().getDetail().getAddress().getPhone());
                        tvAddress.setText(refundDetailModel.getData().getDetail().getAddress().getRegion().toString() + refundDetailModel.getData().getDetail().getAddress().getDetail());
                    }
                    tvGoodsMoney.setText("￥" + refundDetailModel.getData().getDetail().getOrder_goods().getTotal_price());
//                    tvGoodsFreight.setText("￥"+refundDetailModel.getData().getDetail().get());
                    tvPayMoney.setText("￥" + refundDetailModel.getData().getDetail().getRefund_money());
                    tvGoodsPoints.setText(refundDetailModel.getData().getDetail().getOrder_goods().getPoints_bonus() + "金豆");
                    tvOrderCode.setText(refundDetailModel.getData().getDetail().getOrder_master().getOrder_no());
                    tvOrderTime.setText(refundDetailModel.getData().getDetail().getOrder_master().getCreate_time());
                    afterSalesType.setText(refundDetailModel.getData().getDetail().getType().getText());
                    afterSalesReason.setText(refundDetailModel.getData().getDetail().getApply_desc());

                    if (refundDetailModel.getData().getDetail().getState_text().equals("等待审核中")) {
                        llAfterSales.setVisibility(View.GONE);
                        rlBeans.setVisibility(View.GONE);
                    }

                    //                    switch (refundDetailModel.getData().getDetail().getStatus().getValue()) {
//                        case 0:     //进行中
//                                llAfterSales.setVisibility(View.GONE);
//                                rlBeans.setVisibility(View.GONE);
//                            break;
//                        case 10:    //拒绝
//                            break;
//                        case 20:        //已完成
//                            break;
//                        case 30:        //取消
//                            break;
//
//                    }

                }
            }
        });
    }


    @OnClick({R.id.iv_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;

        }
    }
}
