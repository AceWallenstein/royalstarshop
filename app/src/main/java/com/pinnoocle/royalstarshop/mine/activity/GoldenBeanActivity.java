package com.pinnoocle.royalstarshop.mine.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.adapter.GoldenBeanAdapter;
import com.pinnoocle.royalstarshop.adapter.MoneyListAdapter;
import com.pinnoocle.royalstarshop.bean.LoginBean;
import com.pinnoocle.royalstarshop.bean.MoneyListModel;
import com.pinnoocle.royalstarshop.bean.PointsModel;
import com.pinnoocle.royalstarshop.common.BaseActivity;
import com.pinnoocle.royalstarshop.nets.DataRepository;
import com.pinnoocle.royalstarshop.nets.Injection;
import com.pinnoocle.royalstarshop.nets.RemotDataSource;
import com.pinnoocle.royalstarshop.utils.FastData;
import com.pinnoocle.royalstarshop.widget.CommItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GoldenBeanActivity extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.tv_gold)
    TextView tvGold;
    @BindView(R.id.tv_money)
    TextView tvMoney;
    @BindView(R.id.tv_more)
    TextView tvMore;
    @BindView(R.id.view)
    View view;
    @BindView(R.id.recycleView)
    RecyclerView recycleView;
    private DataRepository dataRepository;
    private GoldenBeanAdapter goldenBeanAdapter;
    private int page = 1;
    private List<PointsModel.DataBeanX.ListBean.DataBean> data1 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initTransparent();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_golden_bean);
        ButterKnife.bind(this);
        dataRepository = Injection.dataRepository(this);
        tvMoney.setText(getIntent().getStringExtra("golden"));

        goldenBeanAdapter = new GoldenBeanAdapter(this);
        recycleView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recycleView.addItemDecoration(new CommItemDecoration(this, DividerItemDecoration.VERTICAL, 0xffeeeeee, 2));
        recycleView.setAdapter(goldenBeanAdapter);

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
                ViewLoading.dismiss(GoldenBeanActivity.this);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(GoldenBeanActivity.this);
                PointsModel pointsModel = (PointsModel) data;
                if (pointsModel.getCode() == 1) {
                    data1.addAll(pointsModel.getData().getList().getData());
                    goldenBeanAdapter.setData(data1);
                }
            }
        });
    }

    @OnClick({R.id.iv_back, R.id.tv_more})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_more:
                startActivity(new Intent(this, GoldenBeanDetailActivity.class));
                break;
        }
    }
}