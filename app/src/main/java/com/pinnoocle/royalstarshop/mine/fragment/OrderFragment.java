package com.pinnoocle.royalstarshop.mine.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.adapter.OrderAdapter;
import com.pinnoocle.royalstarshop.bean.GoodsDetailModel;
import com.pinnoocle.royalstarshop.bean.LoginBean;
import com.pinnoocle.royalstarshop.bean.OrderListModel;
import com.pinnoocle.royalstarshop.common.BaseAdapter;
import com.pinnoocle.royalstarshop.common.BaseFragment;
import com.pinnoocle.royalstarshop.mine.activity.OrderDetailActivity;
import com.pinnoocle.royalstarshop.nets.DataRepository;
import com.pinnoocle.royalstarshop.nets.Injection;
import com.pinnoocle.royalstarshop.nets.RemotDataSource;
import com.pinnoocle.royalstarshop.utils.FastData;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.zzhoujay.richtext.ImageHolder;
import com.zzhoujay.richtext.RichText;

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
    protected void initView() {
        recycleView.setLayoutManager(new LinearLayoutManager(getContext()));
        orderAdapter = new OrderAdapter(getContext());
        recycleView.setAdapter(orderAdapter);
        refresh.setOnRefreshLoadMoreListener(this);
        orderAdapter.setOnItemDataClickListener(new BaseAdapter.OnItemDataClickListener<OrderListModel.DataBeanX.ListBean.DataBean>() {
            @Override
            public void onItemViewClick(View view, int position, OrderListModel.DataBeanX.ListBean.DataBean o) {
                switch (view.getId()){
                    case R.id.tv_cancel:

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
