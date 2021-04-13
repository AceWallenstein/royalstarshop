package com.pinnoocle.royalstarshop.mine.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.adapter.AfterSalesAdapter;
import com.pinnoocle.royalstarshop.adapter.OrderAdapter;
import com.pinnoocle.royalstarshop.bean.LoginBean;
import com.pinnoocle.royalstarshop.bean.RefundListsModel;
import com.pinnoocle.royalstarshop.common.BaseActivity;
import com.pinnoocle.royalstarshop.common.BaseAdapter;
import com.pinnoocle.royalstarshop.event.CartAllCheckedEvent;
import com.pinnoocle.royalstarshop.nets.DataRepository;
import com.pinnoocle.royalstarshop.nets.Injection;
import com.pinnoocle.royalstarshop.nets.RemotDataSource;
import com.pinnoocle.royalstarshop.utils.FastData;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuRecyclerView;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AfterSalesListActivity extends BaseActivity implements OnRefreshLoadMoreListener {


    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.recycleView)
    SwipeMenuRecyclerView recycleView;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
    @BindView(R.id.tv_empty)
    TextView tvEmpty;
    private DataRepository dataRepository;
    private int page = 1;
    private List<RefundListsModel.DataBeanX.ListBean.DataBean> dataBeanList = new ArrayList<>();
    private AfterSalesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initWhite();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_sales_list);
        ButterKnife.bind(this);
        initView();
        initData();
    }


    private void initView() {
        recycleView.setLayoutManager(new LinearLayoutManager(mContext));
        adapter = new AfterSalesAdapter(mContext);
        recycleView.setAdapter(adapter);
        refresh.setOnRefreshLoadMoreListener(this);
        adapter.setOnItemDataClickListener(new BaseAdapter.OnItemDataClickListener<RefundListsModel.DataBeanX.ListBean.DataBean>() {
            @Override
            public void onItemViewClick(View view, int position, RefundListsModel.DataBeanX.ListBean.DataBean o) {
                Intent intent = new Intent(mContext, AfterSalesDetailActivity.class);
                intent.putExtra("order_refund_id",o.getOrder_refund_id()+"");
                startActivity(intent);
            }
        });
    }

    private void initData() {
        dataRepository = Injection.dataRepository(this);
        refundLists();
    }

    private void refundLists() {
        ViewLoading.show(this);
        LoginBean loginBean = new LoginBean();
        loginBean.wxapp_id = "10001";
        loginBean.token = FastData.getToken();
        loginBean.page = page + "";
        dataRepository.refundLists(loginBean, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                refresh.finishRefresh();
                ViewLoading.dismiss(AfterSalesListActivity.this);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(AfterSalesListActivity.this);
                RefundListsModel refundListsModel = (RefundListsModel) data;
                tvEmpty.setVisibility(View.VISIBLE);
                recycleView.setVisibility(View.GONE);
                refresh.finishRefresh();
                if (refundListsModel.getCode() == 1) {
                    if (refundListsModel.getData().getList().getCurrent_page() == refundListsModel.getData().getList().getLast_page()) {
                        refresh.finishLoadMoreWithNoMoreData();
                    } else {
                        refresh.finishLoadMore();
                    }
                    if (dataBeanList.size() == 0 && refundListsModel.getData().getList().getData().size() == 0) {
                        tvEmpty.setVisibility(View.VISIBLE);
                        recycleView.setVisibility(View.GONE);
                    } else {
                        tvEmpty.setVisibility(View.GONE);
                        recycleView.setVisibility(View.VISIBLE);
                        dataBeanList.addAll(refundListsModel.getData().getList().getData());

                        adapter.setData(dataBeanList);
                    }
                }
            }
        });
    }


    @Subscribe(threadMode = ThreadMode.MAIN, priority = 100, sticky = false) //在ui线程执行，优先级为100
    public void onEvent(String event) {
        if(event.equals("6")){
            page = 1;
            dataBeanList.clear();
            refundLists();
        }

    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }

    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        page++;
        refundLists();
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        page = 1;
        dataBeanList.clear();
        refundLists();
    }
}
