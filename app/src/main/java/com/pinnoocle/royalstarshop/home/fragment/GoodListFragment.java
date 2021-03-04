package com.pinnoocle.royalstarshop.home.fragment;

import android.content.Intent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.adapter.GoodsAdapter;
import com.pinnoocle.royalstarshop.common.BaseAdapter;
import com.pinnoocle.royalstarshop.common.BaseFragment;
import com.pinnoocle.royalstarshop.nets.DataRepository;
import com.pinnoocle.royalstarshop.nets.Injection;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import butterknife.BindView;

public class GoodListFragment extends BaseFragment implements OnRefreshLoadMoreListener {
    @BindView(R.id.recycleView)
    RecyclerView recycleView;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;

    private int category_id;
    private DataRepository dataRepository;

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
        GoodsAdapter goodsAdapter = new GoodsAdapter(getContext());
        recycleView.setAdapter(goodsAdapter);
        refresh.setOnRefreshLoadMoreListener(this);
    }

    @Override
    protected void initData() {
        dataRepository = Injection.dataRepository(getContext());
        categoryList();
    }

    private void categoryList() {

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
