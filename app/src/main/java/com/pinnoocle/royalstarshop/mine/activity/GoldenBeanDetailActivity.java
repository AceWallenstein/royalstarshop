package com.pinnoocle.royalstarshop.mine.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.adapter.GoldenBeanAdapter;
import com.pinnoocle.royalstarshop.bean.LoginBean;
import com.pinnoocle.royalstarshop.bean.PointsModel;
import com.pinnoocle.royalstarshop.common.BaseActivity;
import com.pinnoocle.royalstarshop.nets.DataRepository;
import com.pinnoocle.royalstarshop.nets.Injection;
import com.pinnoocle.royalstarshop.nets.RemotDataSource;
import com.pinnoocle.royalstarshop.utils.FastData;
import com.pinnoocle.royalstarshop.widget.CommItemDecoration;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GoldenBeanDetailActivity extends BaseActivity implements OnRefreshLoadMoreListener {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.tv_num)
    TextView tvNum;
    @BindView(R.id.tv_get)
    TextView tvGet;
    @BindView(R.id.tv_out)
    TextView tvOut;
    @BindView(R.id.ll_comers)
    LinearLayout llComers;
    @BindView(R.id.recycleView)
    RecyclerView recycleView;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
    private DataRepository dataRepository;
    private GoldenBeanAdapter goldenBeanAdapter;
    private int page = 1;
    private List<PointsModel.DataBeanX.ListBean.DataBean> data1 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initWhite();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_golden_bean_detail);
        ButterKnife.bind(this);
        dataRepository = Injection.dataRepository(this);

        goldenBeanAdapter = new GoldenBeanAdapter(this);
        recycleView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recycleView.addItemDecoration(new CommItemDecoration(this, DividerItemDecoration.VERTICAL, 0xffeeeeee, 2));
        recycleView.setAdapter(goldenBeanAdapter);

        refresh.setOnRefreshLoadMoreListener(this);

        userPointsLog(page);
    }

    private void userPointsLog(int page) {
        ViewLoading.show(this);
        LoginBean loginBean = new LoginBean();
        loginBean.wxapp_id = "10001";
        loginBean.token = FastData.getToken();
        loginBean.page = page + "";
        dataRepository.userPointsLog(loginBean, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                refresh.finishRefresh();
                refresh.finishLoadMore();
                ViewLoading.dismiss(GoldenBeanDetailActivity.this);
            }

            @Override
            public void onSuccess(Object data) {
                refresh.finishRefresh();
                ViewLoading.dismiss(GoldenBeanDetailActivity.this);
                PointsModel pointsModel = (PointsModel) data;
                if (pointsModel.getCode() == 1) {
                    tvNum.setText(pointsModel.getData().getList().getTotal() + "");
                    tvGet.setText(pointsModel.getData().getShouru() + "");
                    tvOut.setText(pointsModel.getData().getZhichu() + "");
                    if (pointsModel.getData().getList().getCurrent_page() == pointsModel.getData().getList().getLast_page()) {
                        refresh.finishLoadMoreWithNoMoreData();
                    } else {
                        refresh.finishLoadMore();
                    }
                    data1.addAll(pointsModel.getData().getList().getData());
                    goldenBeanAdapter.setData(data1);
                }
            }
        });
    }

    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        page++;
        userPointsLog(page);
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        page = 1;
        data1.clear();
        userPointsLog(page);
    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }
}