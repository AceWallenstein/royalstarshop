package com.pinnoocle.royalstarshop.home.fragment;

import android.content.Intent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.adapter.GoodsAdapter;
import com.pinnoocle.royalstarshop.bean.CategoryListModel;
import com.pinnoocle.royalstarshop.bean.GoodsListsModel;
import com.pinnoocle.royalstarshop.bean.LoginBean;
import com.pinnoocle.royalstarshop.common.BaseAdapter;
import com.pinnoocle.royalstarshop.common.BaseFragment;
import com.pinnoocle.royalstarshop.home.activity.SearchActivity;
import com.pinnoocle.royalstarshop.nets.DataRepository;
import com.pinnoocle.royalstarshop.nets.Injection;
import com.pinnoocle.royalstarshop.nets.RemotDataSource;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.List;

import butterknife.BindView;

public class GoodListFragment extends BaseFragment implements OnRefreshLoadMoreListener {
    @BindView(R.id.recycleView)
    RecyclerView recycleView;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;

    private int category_id;
    private DataRepository dataRepository;
    private GoodsAdapter goodsAdapter;

    public GoodListFragment(int category_id) {
        this.category_id = category_id;
    }

    @Override
    protected int LayoutId() {
        return R.layout.fragment_goods_list;
    }

    @Override
    protected void initView() {
        recycleView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        goodsAdapter = new GoodsAdapter(getContext());
        recycleView.setAdapter(goodsAdapter);
        refresh.setOnRefreshLoadMoreListener(this);
    }

    @Override
    protected void initData() {
        dataRepository = Injection.dataRepository(getContext());
        goodsLists();
    }

    private void goodsLists() {
        ViewLoading.show(getContext());
        LoginBean loginBean = new LoginBean();
        loginBean.wxapp_id = "10001";
        loginBean.category_id = category_id+"";
        dataRepository.categoryList(loginBean, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(getContext());
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(getContext());
                CategoryListModel categoryListModel = (CategoryListModel) data;
                if(categoryListModel.getCode() == 1){
                    List<CategoryListModel.DataBean.ListBean> listBeans = categoryListModel.getData().getList();
                    goodsAdapter.setData(listBeans);
                }
            }
        });
    }

    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        refresh.finishLoadMore();
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        refresh.finishRefresh();
    }
}
