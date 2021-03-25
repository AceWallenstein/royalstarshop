package com.pinnoocle.royalstarshop.mine.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.adapter.OrderAdapter;
import com.pinnoocle.royalstarshop.bean.GoodsDetailModel;
import com.pinnoocle.royalstarshop.bean.LoginBean;
import com.pinnoocle.royalstarshop.bean.OrderListModel;
import com.pinnoocle.royalstarshop.bean.ResultModel;
import com.pinnoocle.royalstarshop.bean.StatusModel;
import com.pinnoocle.royalstarshop.common.BaseAdapter;
import com.pinnoocle.royalstarshop.common.BaseFragment;
import com.pinnoocle.royalstarshop.event.CartAllCheckedEvent;
import com.pinnoocle.royalstarshop.mine.activity.OrderCommentActivity;
import com.pinnoocle.royalstarshop.mine.activity.OrderDetailActivity;
import com.pinnoocle.royalstarshop.mine.activity.OrderPayActivity;
import com.pinnoocle.royalstarshop.nets.DataRepository;
import com.pinnoocle.royalstarshop.nets.Injection;
import com.pinnoocle.royalstarshop.nets.RemotDataSource;
import com.pinnoocle.royalstarshop.utils.FastData;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.timmy.tdialog.TDialog;
import com.timmy.tdialog.base.BindViewHolder;
import com.timmy.tdialog.listener.OnBindViewListener;
import com.timmy.tdialog.listener.OnViewClickListener;
import com.zzhoujay.richtext.ImageHolder;
import com.zzhoujay.richtext.RichText;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class OrderFragment extends BaseFragment implements OnRefreshLoadMoreListener {
    @BindView(R.id.tv_empty)
    TextView tvEmpty;
    @BindView(R.id.recycleView)
    RecyclerView recycleView;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;

    private String type;
    private DataRepository dataRepository;
    private OrderAdapter orderAdapter;
    private List<OrderListModel.DataBeanX.ListBean.DataBean> dataBeanList = new ArrayList<>();
    private int page = 1;

    public OrderFragment(String type) {
        this.type = type;
    }

    @Override
    protected int LayoutId() {
        return R.layout.fragment_order;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN, priority = 100, sticky = false) //在ui线程执行，优先级为100
    public void onEvent(String event) {
        if(event.equals("order_refresh")){
            page = 1;
            dataBeanList.clear();
            orderList();
        }
    }

    @Override
    protected void initView() {
        recycleView.setLayoutManager(new LinearLayoutManager(getContext()));
        orderAdapter = new OrderAdapter(getContext());
        recycleView.setAdapter(orderAdapter);
        refresh.setOnRefreshLoadMoreListener(this);
        orderAdapter.setOnItemDataClickListener(new BaseAdapter.OnItemDataClickListener<OrderListModel.DataBeanX.ListBean.DataBean>() {
            @Override
            public void onItemViewClick(View view, int position, OrderListModel.DataBeanX.ListBean.DataBean o) {
                switch (view.getId()) {
                    case R.id.tv_cancel:
                        if (o.getState_text().equals("待付款")) {  //取消
                            showOrderCancelDialog(o.getOrder_id() + "");
                        } else if (o.getState_text().equals("待付款")) {//联系客服

                        }
                        break;

                    case R.id.tv_pay:
                        if (o.getState_text().equals("待付款")) {  //去付款
                            Intent intent = new Intent(getContext(), OrderPayActivity.class);
                            intent.putExtra("order_id",o.getOrder_id()+"");
                            intent.putExtra("order_no",o.getOrder_no()+"");
                            intent.putExtra("order_money",o.getOrder_price());
                            startActivity(intent);
                        } else if (o.getState_text().equals("待收货")) {//确认收货
                            showOrderConfirmDialog(o.getOrder_id() + "",o.getOrder_no());
                        } else if (o.getState_text().equals("已完成")) {//去评价
                            Intent intent = new Intent(getContext(), OrderCommentActivity.class);
                            intent.putExtra("order_id",o.getOrder_id()+"");
                            startActivity(intent);

                        }

                        break;

                    default:
                        startActivity(new Intent(getContext(), OrderDetailActivity.class));
                        break;
                }
            }
        });
    }

    @Override
    protected void initData() {
        dataRepository = Injection.dataRepository(getContext());
        orderList();
    }

    private void orderList() {

        LoginBean loginBean = new LoginBean();
        loginBean.wxapp_id = "10001";
        loginBean.token = FastData.getToken();
        loginBean.dataType = type;
        loginBean.page = page + "";
        ViewLoading.show(getContext());
        dataRepository.orderList(loginBean, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(getContext());
                refresh.finishRefresh();
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(getContext());
                OrderListModel orderListModel = (OrderListModel) data;
                refresh.finishRefresh();
                if (orderListModel.getCode() == 1) {
                    if (orderListModel.getData().getList().getCurrent_page() == orderListModel.getData().getList().getLast_page()) {
                        refresh.finishLoadMoreWithNoMoreData();
                    } else {
                        refresh.finishLoadMore();
                    }
                    if (dataBeanList.size() == 0 && orderListModel.getData().getList().getData().size() == 0) {
                        tvEmpty.setVisibility(View.VISIBLE);
                        recycleView.setVisibility(View.GONE);
                    } else {
                        tvEmpty.setVisibility(View.GONE);
                        recycleView.setVisibility(View.VISIBLE);
                        dataBeanList.addAll(orderListModel.getData().getList().getData());
                        orderAdapter.setData(dataBeanList);
                    }

                }
            }
        });
    }

    private void orderCancel(String order_ids) {
        LoginBean loginBean = new LoginBean();
        loginBean.wxapp_id = "10001";
        loginBean.token = FastData.getToken();
        loginBean.order_id	 = order_ids;
        ViewLoading.show(getContext());
        dataRepository.orderCancel(loginBean, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(getContext());
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(getContext());
                StatusModel statusModel = (StatusModel) data;
                refresh.finishRefresh();
                if (statusModel.getCode() == 1) {
                   EventBus.getDefault().post("order_refresh");
                }
            }

        });
    }

    private void orderReceipt(String order_ids,String order_no) {
        LoginBean loginBean = new LoginBean();
        loginBean.wxapp_id = "10001";
        loginBean.token = FastData.getToken();
        loginBean.order_id = order_ids;
        ViewLoading.show(getContext());
        dataRepository.orderReceipt(loginBean, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(getContext());
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(getContext());
                StatusModel statusModel = (StatusModel) data;
                refresh.finishRefresh();
                if (statusModel.getCode() == 1) {
                    EventBus.getDefault().post("order_refresh");
//                    showOrderCommentDialog(order_ids,order_no);
                }
            }

        });
    }


    private void showOrderCancelDialog(String order_ids) {
        new TDialog.Builder(getActivity().getSupportFragmentManager())
                .setLayoutRes(R.layout.order_cancel_dialog)
                .setScreenWidthAspect(getContext(), 0.7f)
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

    private void showOrderConfirmDialog(String order_ids,String order_no) {
        new TDialog.Builder(getActivity().getSupportFragmentManager())
                .setLayoutRes(R.layout.order_confirm_dialog)
                .setScreenWidthAspect(getContext(), 0.7f)
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
                                orderReceipt(order_ids,order_no);
                                tDialog.dismiss();
                                break;
                        }
                    }
                })
                .create()
                .show();
    }

    private void showOrderCommentDialog(String order_ids,String order_no) {
        new TDialog.Builder(getActivity().getSupportFragmentManager())
                .setLayoutRes(R.layout.order_comment_dialog)
                .setScreenWidthAspect(getContext(), 0.7f)
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
                                Intent intent = new Intent(getContext(), OrderCommentActivity.class);
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



    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        page++;
        orderList();
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        page = 1;
        dataBeanList.clear();
        orderList();
    }

}
