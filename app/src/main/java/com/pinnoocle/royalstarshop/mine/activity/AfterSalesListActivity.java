package com.pinnoocle.royalstarshop.mine.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;

import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.bean.LoginBean;
import com.pinnoocle.royalstarshop.bean.RefundListsModel;
import com.pinnoocle.royalstarshop.common.BaseActivity;
import com.pinnoocle.royalstarshop.nets.DataRepository;
import com.pinnoocle.royalstarshop.nets.Injection;
import com.pinnoocle.royalstarshop.nets.RemotDataSource;
import com.pinnoocle.royalstarshop.utils.FastData;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuRecyclerView;

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
    @BindView(R.id.rl_empty)
    RelativeLayout rlEmpty;
    private DataRepository dataRepository;
    private int page = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initTransparent();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_sales_list);
        ButterKnife.bind(this);
        initView();
        initData();
    }


    private void initView() {
        refresh.setOnRefreshLoadMoreListener(this);
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
                refresh.finishLoadMore();
                ViewLoading.dismiss(AfterSalesListActivity.this);
            }

            @Override
            public void onSuccess(Object data) {
                refresh.finishRefresh();
                ViewLoading.dismiss(AfterSalesListActivity.this);
                RefundListsModel refundListsModel = (RefundListsModel) data;
                rlEmpty.setVisibility(View.VISIBLE);
                recycleView.setVisibility(View.GONE);
                refresh.finishRefresh();
//                if (collectListModel.getCode() == 1) {
//                    if (orderListModel.getData().getList().getCurrent_page() == orderListModel.getData().getList().getLast_page()) {
                refresh.finishLoadMoreWithNoMoreData();
//                    } else {
                refresh.finishLoadMore();
//                    }
//                    if (dataBeanList.size() == 0 && orderListModel.getData().getList().getData().size() == 0) {
//                        tvEmpty.setVisibility(View.VISIBLE);
//                        recycleView.setVisibility(View.GONE);
//                    } else {
//                        tvEmpty.setVisibility(View.GONE);
//                        recycleView.setVisibility(View.VISIBLE);
//                        dataBeanList.addAll(orderListModel.getData().getList().getData());
//                        orderAdapter.setData(dataBeanList);
//                    }
//                }
            }
        });
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
//        dataBeanList.clear();
        refundLists();
    }
}
