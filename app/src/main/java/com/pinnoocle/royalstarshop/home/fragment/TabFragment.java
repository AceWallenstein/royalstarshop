package com.pinnoocle.royalstarshop.home.fragment;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.adapter.GoodsMenusAdapter;
import com.pinnoocle.royalstarshop.common.BaseFragment;
import com.pinnoocle.royalstarshop.widget.CommItemDecoration;

import butterknife.BindView;

public class TabFragment extends BaseFragment {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @Override
    protected int LayoutId() {
        return R.layout.fragment_tab_one;
    }

    @Override
    protected void initData() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView.addItemDecoration(new CommItemDecoration(getContext(), DividerItemDecoration.HORIZONTAL, getResources().getColor(R.color.white1), 25));
        recyclerView.setAdapter(new GoodsMenusAdapter(getContext()));
    }
}
