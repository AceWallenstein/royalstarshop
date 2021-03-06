package com.pinnoocle.royalstarshop.mine.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.core.widget.NestedScrollView;

import com.bumptech.glide.Glide;
import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pedaily.yc.ycdialoglib.toast.ToastUtils;
import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.bean.LoginBean;
import com.pinnoocle.royalstarshop.bean.RefundDetailModel;
import com.pinnoocle.royalstarshop.bean.ReturnAddressModel;
import com.pinnoocle.royalstarshop.bean.StatusModel;
import com.pinnoocle.royalstarshop.common.BaseActivity;
import com.pinnoocle.royalstarshop.home.activity.GoodsDetailActivity;
import com.pinnoocle.royalstarshop.nets.DataRepository;
import com.pinnoocle.royalstarshop.nets.Injection;
import com.pinnoocle.royalstarshop.nets.RemotDataSource;
import com.pinnoocle.royalstarshop.utils.FastData;
import com.pinnoocle.royalstarshop.utils.NumberUtil;
import com.pinnoocle.royalstarshop.widget.GlideRoundTransform;

import org.angmarch.views.NiceSpinner;
import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.bumptech.glide.request.RequestOptions.bitmapTransform;

public class AfterSalesDetailActivity extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.iv_bg)
    ImageView ivBg;
    @BindView(R.id.iv_mark)
    ImageView ivMark;
    @BindView(R.id.tv_status)
    TextView tvStatus;
    @BindView(R.id.ll_status)
    LinearLayout llStatus;
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
    @BindView(R.id.iv_shop)
    ImageView ivShop;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_goods_pattern)
    TextView tvGoodsPattern;
    @BindView(R.id.tv_num)
    TextView tvNum;
    @BindView(R.id.tv_goods_money)
    TextView tvGoodsMoney;
    @BindView(R.id.tv_goods_freight)
    TextView tvGoodsFreight;
    @BindView(R.id.tv_goods_points)
    TextView tvGoodsPoints;
    @BindView(R.id.rl_beans)
    RelativeLayout rlBeans;
    @BindView(R.id.tv_pay_money)
    TextView tvPayMoney;
    @BindView(R.id.after_sales_type)
    TextView afterSalesType;
    @BindView(R.id.after_sales_reason)
    TextView afterSalesReason;
    @BindView(R.id.iv_money)
    ImageView ivMoney;
    @BindView(R.id.rl_money)
    RelativeLayout rlMoney;
    @BindView(R.id.nice_spinner)
    NiceSpinner niceSpinner;
    @BindView(R.id.tv_sure)
    TextView tvSure;
    @BindView(R.id.ll_after_sales)
    LinearLayout llAfterSales;
    @BindView(R.id.scrollView)
    NestedScrollView scrollView;
    @BindView(R.id.ed_express_code)
    EditText edExpressCode;
    @BindView(R.id.rl_goods)
    RelativeLayout rlGoods;
    @BindView(R.id.tv_cancel)
    TextView tvCancel;
    @BindView(R.id.rl_panel)
    RelativeLayout rlPanel;
    @BindView(R.id.tv_price)
    TextView tvPrice;
    private DataRepository dataRepository;

    private RefundDetailModel refundDetailModel;
    private List<RefundDetailModel.DataBean.ExpressListBean> expressList;


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
                refundDetailModel = (RefundDetailModel) data;
                if (refundDetailModel.getCode() == 1) {
                    tvStatus.setText(refundDetailModel.getData().getDetail().getState_text());
                    if (refundDetailModel.getData().getDetail().getAddress() != null) {
                        tvName.setText(refundDetailModel.getData().getDetail().getAddress().getName());
                        tvPhone.setText(refundDetailModel.getData().getDetail().getAddress().getPhone());
                        tvAddress.setText(refundDetailModel.getData().getDetail().getAddress().getRegion().toString() + refundDetailModel.getData().getDetail().getAddress().getDetail());
                    }

//                    if (TextUtils.isEmpty(refundDetailModel.getData().getDetail().getTotal_freight()) || refundDetailModel.getData().getDetail().getTotal_freight().equals("0")) {
//                        tvGoodsFreight.setText("包邮");
//                    } else {
//                    }
                   expressList = refundDetailModel.getData().getExpressList();
                    List<String> details = new ArrayList<>();
                    for (int i = 0; i < AfterSalesDetailActivity.this.expressList.size(); i++) {
                        details.add(AfterSalesDetailActivity.this.expressList.get(i).getExpress_name());
                    }
                    List<String> dataset = new LinkedList<>(details);
                    niceSpinner.attachDataSource(dataset);

                    tvGoodsPoints.setText(refundDetailModel.getData().getDetail().getOrder_goods().getPoints_bonus() + "金豆");
                    tvOrderCode.setText(refundDetailModel.getData().getDetail().getOrder_master().getOrder_no());
                    tvOrderTime.setText(refundDetailModel.getData().getDetail().getOrder_master().getCreate_time());
                    afterSalesType.setText(refundDetailModel.getData().getDetail().getType().getText());
                    afterSalesReason.setText(refundDetailModel.getData().getDetail().getApply_desc());
                    RefundDetailModel.DataBean.DetailBean.OrderGoodsBean order_goods = refundDetailModel.getData().getDetail().getOrder_goods();
                    Glide.with(mContext).load(order_goods.getImage().getFile_path()).apply(bitmapTransform(new GlideRoundTransform(mContext))).into(ivShop);
                    tvTitle.setText(order_goods.getGoods_name());
                    tvGoodsPattern.setText(order_goods.getGoods_attr());
                    tvNum.setText("x" + order_goods.getTotal_num());

                    if (refundDetailModel.getData().getDetail().getOrder_master().getIs_vip_order() == 1) {
                        tvGoodsMoney.setText(NumberUtil.String2Int(refundDetailModel.getData().getDetail().getOrder_goods().getTotal_price())+"金豆");
                        tvGoodsFreight.setText(NumberUtil.String2Int(refundDetailModel.getData().getDetail().getOrder_goods().getTotal_freight())+"金豆");
                        tvPayMoney.setText(refundDetailModel.getData().getDetail().getOrder_master().getPoints_num()+"金豆");
                        tvPrice.setText(NumberUtil.String2Int(refundDetailModel.getData().getDetail().getOrder_goods().getGoods_price()) + "金豆");

                    } else {
                        tvPrice.setText("￥" + refundDetailModel.getData().getDetail().getOrder_goods().getGoods_price());
                        tvGoodsMoney.setText("￥" + refundDetailModel.getData().getDetail().getOrder_goods().getTotal_price());
                        tvGoodsFreight.setText("￥" + refundDetailModel.getData().getDetail().getOrder_goods().getTotal_freight());
                        tvPayMoney.setText("￥" + refundDetailModel.getData().getDetail().getRefund_money());
                    }

                    if (refundDetailModel.getData().getDetail().getState_text().equals("等待审核中")) {
                        llAfterSales.setVisibility(View.GONE);
                        rlBeans.setVisibility(View.GONE);
                    }

                    if (refundDetailModel.getData().getDetail().getIs_agree().getValue() == 0) {

                        rlPanel.setVisibility(View.VISIBLE);
                    } else {

                        rlPanel.setVisibility(View.GONE);
                    }
                    switch (refundDetailModel.getData().getDetail().getState_text()) {
                        case "等待审核中":     //进行中
                            llAfterSales.setVisibility(View.GONE);
                            rlBeans.setVisibility(View.GONE);

                            break;
                        case "已发货，待平台确认":
                            llAfterSales.setVisibility(View.GONE);
                            rlBeans.setVisibility(View.GONE);
                            break;


                    }

                }
            }
        });
    }


    private void refundDelivery() {
        LoginBean loginBean = new LoginBean();
        loginBean.wxapp_id = "10001";
        loginBean.token = FastData.getToken();
        loginBean.order_refund_id = refundDetailModel.getData().getDetail().getOrder_refund_id() + "";
        loginBean.express_id = expressList.get(niceSpinner.getSelectedIndex()).getExpress_id() + "";
        ;
        loginBean.express_no = edExpressCode.getText().toString();
        ;
        ViewLoading.show(mContext);

        dataRepository.refundDelivery(loginBean, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(mContext);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(mContext);
                StatusModel statusModel = (StatusModel) data;
                if (statusModel.getCode() == 1) {
                    finish();
                    EventBus.getDefault().post("6");
                }
                ToastUtils.showToast(statusModel.getMsg());

            }
        });
    }

    private void refundCancel() {
        LoginBean loginBean = new LoginBean();
        loginBean.wxapp_id = "10001";
        loginBean.token = FastData.getToken();
        loginBean.order_refund_id = refundDetailModel.getData().getDetail().getOrder_refund_id() + "";
        ViewLoading.show(mContext);

        dataRepository.refundCancel(loginBean, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(mContext);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(mContext);
                StatusModel statusModel = (StatusModel) data;
                if (statusModel.getCode() == 1) {
                    finish();
                    EventBus.getDefault().post("6");
                    ToastUtils.showToast("取消成功");
                } else {
                    ToastUtils.showToast(statusModel.getMsg());
                }

            }
        });
    }


    @OnClick({R.id.iv_back, R.id.tv_sure, R.id.rl_goods, R.id.tv_cancel})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_sure:
                if (TextUtils.isEmpty(edExpressCode.getText().toString())) {
                    ToastUtils.showToast("请输入物流单号");
                    return;
                }
                refundDelivery();

                break;
            case R.id.rl_goods:
                Intent intent = new Intent(mContext, GoodsDetailActivity.class);
                intent.putExtra("goods_id", refundDetailModel.getData().getDetail().getOrder_goods().getGoods_id() + "");
                mContext.startActivity(intent);
                break;
            case R.id.tv_cancel:
                refundCancel();
                break;

        }
    }
}
