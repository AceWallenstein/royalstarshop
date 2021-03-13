package com.pinnoocle.royalstarshop.mine.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pedaily.yc.ycdialoglib.toast.ToastUtils;
import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.adapter.CollectionAdapter;
import com.pinnoocle.royalstarshop.adapter.MoneyListAdapter;
import com.pinnoocle.royalstarshop.bean.CollectListModel;
import com.pinnoocle.royalstarshop.bean.LoginBean;
import com.pinnoocle.royalstarshop.bean.MoneyListModel;
import com.pinnoocle.royalstarshop.bean.ResultModel;
import com.pinnoocle.royalstarshop.common.BaseActivity;
import com.pinnoocle.royalstarshop.nets.DataRepository;
import com.pinnoocle.royalstarshop.nets.Injection;
import com.pinnoocle.royalstarshop.nets.RemotDataSource;
import com.pinnoocle.royalstarshop.utils.FastData;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProfitDetailActivity extends BaseActivity implements OnRefreshLoadMoreListener {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.tv_num)
    TextView tvNum;
    @BindView(R.id.tv_money)
    TextView tvMoney;
    @BindView(R.id.ll_comers)
    LinearLayout llComers;
    @BindView(R.id.recycleView)
    RecyclerView recycleView;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
    private DataRepository dataRepository;
    private MoneyListAdapter moneyListAdapter;
    private int page = 1;
    private List<MoneyListModel.DataBeanX.ListBean.DataBean> data1 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initWhite();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profit_detail);
        ButterKnife.bind(this);
        dataRepository = Injection.dataRepository(this);

        moneyListAdapter = new MoneyListAdapter(this);
        recycleView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recycleView.setAdapter(moneyListAdapter);

        refresh.setOnRefreshLoadMoreListener(this);
        moneyList(page);
    }

    private void moneyList(int page) {
        ViewLoading.show(this);
        LoginBean loginBean = new LoginBean();
        loginBean.wxapp_id = "10001";
        loginBean.token = FastData.getToken();
        loginBean.page = page + "";
        dataRepository.moneyList(loginBean, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                refresh.finishRefresh();
                refresh.finishLoadMore();
                ViewLoading.dismiss(ProfitDetailActivity.this);
            }

            @Override
            public void onSuccess(Object data) {
                refresh.finishRefresh();
                ViewLoading.dismiss(ProfitDetailActivity.this);
                MoneyListModel moneyListModel = (MoneyListModel) data;
                if (moneyListModel.getCode() == 1) {
                    tvNum.setText(moneyListModel.getData().getList().getTotal() + "");
                    tvMoney.setText(moneyListModel.getData().getTotal());
                    if (moneyListModel.getData().getList().getCurrent_page() == moneyListModel.getData().getList().getLast_page()) {
                        refresh.finishLoadMoreWithNoMoreData();
                    } else {
                        refresh.finishLoadMore();
                    }
                    data1.addAll(moneyListModel.getData().getList().getData());
                    moneyListAdapter.setData(data1);
                }
            }
        });
    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }

    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {

    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {

    }
}