package com.pinnoocle.royalstarshop.mine.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pedaily.yc.ycdialoglib.toast.ToastUtils;
import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.adapter.CollectionAdapter;
import com.pinnoocle.royalstarshop.adapter.ScanListAdapter;
import com.pinnoocle.royalstarshop.bean.CartAddModel;
import com.pinnoocle.royalstarshop.bean.CollectListModel;
import com.pinnoocle.royalstarshop.bean.HomeModel;
import com.pinnoocle.royalstarshop.bean.LoginBean;
import com.pinnoocle.royalstarshop.bean.ScanListModel;
import com.pinnoocle.royalstarshop.common.BaseActivity;
import com.pinnoocle.royalstarshop.common.BaseAdapter;
import com.pinnoocle.royalstarshop.event.ShopCartRefreshEvent;
import com.pinnoocle.royalstarshop.home.activity.GoodsDetailActivity;
import com.pinnoocle.royalstarshop.nets.DataRepository;
import com.pinnoocle.royalstarshop.nets.Injection;
import com.pinnoocle.royalstarshop.nets.RemotDataSource;
import com.pinnoocle.royalstarshop.utils.FastData;
import com.pinnoocle.royalstarshop.widget.CommItemDecoration;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ScanListActivity extends BaseActivity implements OnRefreshLoadMoreListener {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.recycleView)
    RecyclerView recycleView;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
    private ScanListAdapter scanListAdapter;
    private DataRepository dataRepository;
    private int page = 1;
    private List<ScanListModel.DataBeanX.DataBean> data1 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initWhite();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_list);
        ButterKnife.bind(this);
        dataRepository = Injection.dataRepository(this);

        scanListAdapter = new ScanListAdapter(this);
        recycleView.setLayoutManager(new GridLayoutManager(this, 2));
        recycleView.setAdapter(scanListAdapter);

        refresh.setOnRefreshLoadMoreListener(this);

        scanListAdapter.setOnItemDataClickListener(new BaseAdapter.OnItemDataClickListener<ScanListModel.DataBeanX.DataBean>() {
            @Override
            public void onItemViewClick(View view, int position, ScanListModel.DataBeanX.DataBean o) {
                switch (view.getId()){
                    case R.id.iv_shop_car:
                        cartAdd(o.getGoods_id(),o.getGoods_sku().getGoods_sku_id(),1);
                        break;
                    default:
                        Intent intent = new Intent(ScanListActivity.this, GoodsDetailActivity.class);
                        intent.putExtra("goods_id", o.getGoods_id() + "");
                        startActivity(intent);
                        break;
                }
            }
        });

        scanList(page);
    }

    private void cartAdd(int goods_id, int goods_sku_id, int goods_num) {
        ViewLoading.show(this);
        LoginBean loginBean = new LoginBean();
        loginBean.wxapp_id = "10001";
        loginBean.token = FastData.getToken();
        loginBean.goods_id = goods_id + "";
        loginBean.goods_sku_id = goods_sku_id + "";
        loginBean.goods_num = goods_num+"";
        dataRepository.cartAdd(loginBean, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(ScanListActivity.this);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(ScanListActivity.this);
                CartAddModel cartAddModel = (CartAddModel) data;
                if (cartAddModel.getCode() == 1) {
                    EventBus.getDefault().post(new ShopCartRefreshEvent());
                }
                ToastUtils.showToast(cartAddModel.getMsg());
            }
        });
    }

    private void scanList(int page) {
        ViewLoading.show(this);
        LoginBean loginBean = new LoginBean();
        loginBean.wxapp_id = "10001";
        loginBean.token = FastData.getToken();
        loginBean.page = page + "";
        dataRepository.scanList(loginBean, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                refresh.finishRefresh();
                refresh.finishLoadMore();
                ViewLoading.dismiss(ScanListActivity.this);
            }

            @Override
            public void onSuccess(Object data) {
                refresh.finishRefresh();
                ViewLoading.dismiss(ScanListActivity.this);
                ScanListModel scanListModel = (ScanListModel) data;
                if (scanListModel.getCode() == 1) {
                    if (scanListModel.getData().getCurrent_page() == scanListModel.getData().getLast_page()) {
                        refresh.finishLoadMoreWithNoMoreData();
                    } else {
                        refresh.finishLoadMore();
                    }
                    data1.addAll(scanListModel.getData().getData());
                    scanListAdapter.setData(data1);
                }
            }
        });
    }

    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        page++;
        scanList(page);
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        page = 1;
        data1.clear();
        scanList(page);
    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }
}