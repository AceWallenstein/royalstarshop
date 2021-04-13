package com.pinnoocle.royalstarshop.mine.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
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
import com.pinnoocle.royalstarshop.bean.OrderDetailModel;
import com.pinnoocle.royalstarshop.bean.OrderListModel;
import com.pinnoocle.royalstarshop.bean.StatusModel;
import com.pinnoocle.royalstarshop.common.BaseActivity;
import com.pinnoocle.royalstarshop.common.BaseAdapter;
import com.pinnoocle.royalstarshop.home.activity.GoodsDetailActivity;
import com.pinnoocle.royalstarshop.home.activity.VipGoodsDetailActivity;
import com.pinnoocle.royalstarshop.nets.DataRepository;
import com.pinnoocle.royalstarshop.nets.Injection;
import com.pinnoocle.royalstarshop.nets.RemotDataSource;
import com.pinnoocle.royalstarshop.utils.FastData;
import com.timmy.tdialog.TDialog;
import com.timmy.tdialog.base.BindViewHolder;
import com.timmy.tdialog.listener.OnBindViewListener;
import com.timmy.tdialog.listener.OnViewClickListener;

import org.angmarch.views.NiceSpinner;
import org.greenrobot.eventbus.EventBus;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class VipOrderDetailActivity extends BaseActivity {


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
    @BindView(R.id.tv_golden_bean_deduction)
    TextView tvGoldenBeanDeduction;
    @BindView(R.id.tv_pay_money)
    TextView tvPayMoney;
    @BindView(R.id.iv_no_question)
    ImageView ivNoQuestion;
    @BindView(R.id.tv_no_question)
    TextView tvNoQuestion;
    @BindView(R.id.rl_2)
    RelativeLayout rl2;
    @BindView(R.id.tv_contact_after_sales)
    TextView tvContactAfterSales;
    @BindView(R.id.rl_1)
    RelativeLayout rl1;
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
    @BindView(R.id.tv_cancel)
    TextView tvCancel;
    @BindView(R.id.tv_pay)
    TextView tvPay;
    @BindView(R.id.rl_panel)
    RelativeLayout rlPanel;
    private DataRepository dataRepository;
    private OrderDetailAdapter adapter;
    private OrderDetailModel orderDetailModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initWhite();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vip_order_detail);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    private void initView() {
        NiceSpinner niceSpinner = findViewById(R.id.nice_spinner);
        niceSpinner.setBackgroundResource(R.drawable.bg_stroke_3);
        niceSpinner.setTextSize(14);
        List<String> dataset = new LinkedList<>(Arrays.asList("One", "Two", "Three", "Four", "Five"));
        niceSpinner.attachDataSource(dataset);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new OrderDetailAdapter(this);
        recyclerView.setAdapter(adapter);

    }

    private void initData() {
        dataRepository = Injection.dataRepository(this);
        orderDetail();
    }


    private void orderDetail() {
        LoginBean loginBean = new LoginBean();
        loginBean.wxapp_id = "10001";
        loginBean.token = FastData.getToken();
        loginBean.order_id = getIntent().getIntExtra("order_id", 0) + "";

        ViewLoading.show(this);
        dataRepository.orderDetail(loginBean, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(mContext);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(mContext);
                orderDetailModel = (OrderDetailModel) data;
                if (orderDetailModel.getCode() == 1) {
                    tvGoldenBeanDeduction.setText("￥" + orderDetailModel.getData().getOrder().getPoints_money());
                    tvStatus.setText(orderDetailModel.getData().getOrder().getState_text());
                    tvName.setText(orderDetailModel.getData().getOrder().getAddress().getName());
                    tvPhone.setText(orderDetailModel.getData().getOrder().getAddress().getPhone());
                    tvAddress.setText(orderDetailModel.getData().getOrder().getAddress().getRegion().toString() + orderDetailModel.getData().getOrder().getAddress().getDetail());
                    tvGoodsMoney.setText("￥" + orderDetailModel.getData().getOrder().getTotal_price());
                    tvPayMoney.setText("￥" + orderDetailModel.getData().getOrder().getPay_price());
                    tvOrderCode.setText(orderDetailModel.getData().getOrder().getOrder_no());
                    tvOrderTime.setText(orderDetailModel.getData().getOrder().getCreate_time());
                    List<OrderDetailModel.DataBean.OrderBean.GoodsBeanX> goods = orderDetailModel.getData().getOrder().getGoods();
                    adapter.setType(orderDetailModel.getData().getOrder().getState_text());
                    adapter.setData(goods);

                    rl1.setVisibility(View.GONE);
                    llAfterSales.setVisibility(View.GONE);

                    switch (orderDetailModel.getData().getOrder().getState_text()) {
                        case "待付款":
                            rl1.setVisibility(View.GONE);
                            break;
                        case "待发货":
                        case "已取消":
                        case "已完成":
                            rl1.setVisibility(View.GONE);
                            rlPanel.setVisibility(View.GONE);
                            break;
                        case "待收货":
                            tvCancel.setVisibility(View.GONE);
                            tvPay.setText("确认收货");
                            break;
                        case "待评价":
                            tvCancel.setText("删除订单");
                            tvPay.setText("去评价");
                            break;
                        case "等待审核中":
                            llAfterSales.setVisibility(View.VISIBLE);
                            break;

                    }
                    adapter.setOnItemDataClickListener(new BaseAdapter.OnItemDataClickListener<OrderDetailModel.DataBean.OrderBean.GoodsBeanX>() {
                        @Override
                        public void onItemViewClick(View view, int position, OrderDetailModel.DataBean.OrderBean.GoodsBeanX o) {
                            if (view.getId() == R.id.tv_after_sale) {
                                Intent intent = new Intent(VipOrderDetailActivity.this, ApplyForAfterSalesActivity.class);
                                intent.putExtra("order_id", getIntent().getIntExtra("order_id", 0) + "");
                                intent.putExtra("order_goods_id", o.getOrder_goods_id());

                                startActivity(intent);
                            }else if(view.getId()==R.id.rl_goods){
                                Intent intent = new Intent(mContext, VipGoodsDetailActivity.class);
                                intent.putExtra("goods_id",o.getGoods_id()+"");
                                startActivity(intent);
                            }else if(view.getId()==R.id.iv_question){
                                showTipDialog();
                            }
                        }
                    });

                }
            }
        });
    }
    private void showTipDialog() {
        TDialog tDialog = new TDialog.Builder(getSupportFragmentManager())
                .setLayoutRes(R.layout.dialog_tip)
                //设置弹窗展示的xml布局
                .setCancelableOutside(true)
                .setScreenWidthAspect(this, 0.7f)
                .setGravity(Gravity.CENTER)     //设置弹窗展示位置
                .create()   //创建TDialog
                .show();//展示

    }


    private void orderReceipt(String order_ids, String order_no) {
        LoginBean loginBean = new LoginBean();
        loginBean.wxapp_id = "10001";
        loginBean.token = FastData.getToken();
        loginBean.order_id = order_ids;
        ViewLoading.show(VipOrderDetailActivity.this);
        dataRepository.orderReceipt(loginBean, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(VipOrderDetailActivity.this);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(VipOrderDetailActivity.this);
                StatusModel statusModel = (StatusModel) data;
                if (statusModel.getCode() == 1) {
                    orderDetail();
                    EventBus.getDefault().post("order_refresh");
                    showOrderCommentDialog(order_ids, order_no);
                }
            }

        });
    }

    private void orderCancel(String order_ids) {
        LoginBean loginBean = new LoginBean();
        loginBean.wxapp_id = "10001";
        loginBean.token = FastData.getToken();
        loginBean.order_id = order_ids;
        ViewLoading.show(VipOrderDetailActivity.this);
        dataRepository.orderCancel(loginBean, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(VipOrderDetailActivity.this);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(VipOrderDetailActivity.this);
                StatusModel statusModel = (StatusModel) data;
                if (statusModel.getCode() == 1) {
                    orderDetail();
                    EventBus.getDefault().post("order_refresh");

                }
            }

        });
    }

    private void showOrderConfirmDialog(String order_ids, String order_no) {
        new TDialog.Builder(getSupportFragmentManager())
                .setLayoutRes(R.layout.order_confirm_dialog)
                .setScreenWidthAspect(this, 0.7f)
                .setGravity(Gravity.CENTER)
                .setCancelableOutside(false)
                .addOnClickListener(R.id.tv_cancel, R.id.tv_sure)
                .setOnBindViewListener(new OnBindViewListener() {
                    @Override
                    public void bindView(BindViewHolder viewHolder) {
                        TextView tv_content = viewHolder.itemView.findViewById(R.id.tv_content);
                        tv_content.setText("确认签收订单：" + order_no);
                    }
                })
                .setOnViewClickListener(new OnViewClickListener() {
                    @Override
                    public void onViewClick(BindViewHolder viewHolder, View view, TDialog tDialog) {
                        switch (view.getId()) {
                            case R.id.tv_cancel:
                                tDialog.dismiss();
                                break;
                            case R.id.tv_sure:
                                orderReceipt(order_ids, order_no);
                                tDialog.dismiss();
                                break;
                        }
                    }
                })
                .create()
                .show();
    }


    private void showOrderCommentDialog(String order_ids, String order_no) {
        new TDialog.Builder(VipOrderDetailActivity.this.getSupportFragmentManager())
                .setLayoutRes(R.layout.order_comment_dialog)
                .setScreenWidthAspect(VipOrderDetailActivity.this, 0.7f)
                .setGravity(Gravity.CENTER)
                .setCancelableOutside(false)
                .addOnClickListener(R.id.tv_cancel, R.id.tv_sure)
                .setOnBindViewListener(new OnBindViewListener() {
                    @Override
                    public void bindView(BindViewHolder viewHolder) {
                        TextView tv_content = viewHolder.itemView.findViewById(R.id.tv_content);
                        tv_content.setText("确认签收订单：" + order_no + "成功，，现在去评价订单？");
                    }
                })
                .setOnViewClickListener(new OnViewClickListener() {
                    @Override
                    public void onViewClick(BindViewHolder viewHolder, View view, TDialog tDialog) {
                        switch (view.getId()) {
                            case R.id.tv_cancel:
                                tDialog.dismiss();
                                break;
                            case R.id.tv_sure:
                                Intent intent = new Intent(VipOrderDetailActivity.this, OrderCommentActivity.class);
                                intent.putExtra("order_id", order_ids);
                                startActivity(intent);
                                tDialog.dismiss();
                                break;
                        }
                    }
                })
                .create()
                .show();
    }


    private void showOrderCancelDialog(String order_ids) {
        new TDialog.Builder(VipOrderDetailActivity.this.getSupportFragmentManager())
                .setLayoutRes(R.layout.order_cancel_dialog)
                .setScreenWidthAspect(VipOrderDetailActivity.this, 0.7f)
                .setGravity(Gravity.CENTER)
                .setCancelableOutside(false)
                .addOnClickListener(R.id.tv_cancel, R.id.tv_sure)
                .setOnBindViewListener(new OnBindViewListener() {
                    @Override
                    public void bindView(BindViewHolder viewHolder) {
                    }
                })
                .setOnViewClickListener(new OnViewClickListener() {
                    @Override
                    public void onViewClick(BindViewHolder viewHolder, View view, TDialog tDialog) {
                        switch (view.getId()) {
                            case R.id.tv_cancel:
                                tDialog.dismiss();
                                break;
                            case R.id.tv_sure:
                                orderCancel(order_ids);
                                tDialog.dismiss();

                                break;
                        }
                    }
                })
                .create()
                .show();
    }


    @OnClick({R.id.iv_back, R.id.tv_pay, R.id.tv_cancel})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_pay:
                if (tvPay.getText().toString().equals("确认收货")) {
                    showOrderConfirmDialog(orderDetailModel.getData().getOrder().getOrder_id() + "", orderDetailModel.getData().getOrder().getOrder_no());
                } else if (tvPay.getText().toString().equals("去评价")) {
                    Intent intent = new Intent(VipOrderDetailActivity.this, OrderCommentActivity.class);
                    intent.putExtra("order_id", orderDetailModel.getData().getOrder().getOrder_id() + "");
                    startActivity(intent);
                } else if (tvPay.getText().toString().equals("去付款")) {
                    Intent intent = new Intent(this, OrderPayActivity.class);
                    intent.putExtra("order_id", orderDetailModel.getData().getOrder().getOrder_id() + "");
                    intent.putExtra("order_no", orderDetailModel.getData().getOrder().getOrder_no() + "");
                    intent.putExtra("order_money", orderDetailModel.getData().getOrder().getOrder_price());
                    startActivity(intent);
                }
                break;
            case R.id.tv_cancel://删除订单
                showOrderCancelDialog(orderDetailModel.getData().getOrder().getOrder_id() + "");
                break;
        }
    }
}
