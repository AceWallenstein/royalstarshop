package com.pinnoocle.royalstarshop.home.fragment;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.adapter.GoodsAdapter;
import com.pinnoocle.royalstarshop.common.BaseFragment;

import butterknife.BindView;

public class GoodsFragment extends BaseFragment {
    @BindView(R.id.recycleView)
    RecyclerView recycleView;

    @Override
    protected int LayoutId() {
        return R.layout.fragment_goods;
    }

    @Override
    protected void initView() {
        recycleView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        GoodsAdapter goodsAdapter = new GoodsAdapter(getContext());
        recycleView.setAdapter(goodsAdapter);
    }
}
