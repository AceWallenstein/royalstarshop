package com.pinnoocle.royalstarshop.home.fragment;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.adapter.GoodsAdapter;
import com.pinnoocle.royalstarshop.adapter.GoodsListAdapter;
import com.pinnoocle.royalstarshop.bean.HomeModel;
import com.pinnoocle.royalstarshop.common.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class GoodsFragment extends BaseFragment {
    @BindView(R.id.recycleView)
    RecyclerView recycleView;
    List<HomeModel.DataBean.TagGoodsBean.ListBean> list = new ArrayList<>();
    private String s = "";

    public GoodsFragment(List<HomeModel.DataBean.TagGoodsBean.ListBean> list) {
        this.list = list;
    }

    public GoodsFragment(String s) {
        this.s = s;
    }

    @Override
    protected int LayoutId() {
        return R.layout.fragment_goods;
    }

    @Override
    protected void initView() {
        recycleView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        GoodsListAdapter goodsAdapter = new GoodsListAdapter(getContext());
        if (!s.equals("1")) {
            goodsAdapter.setData(list);
        }
        recycleView.setAdapter(goodsAdapter);
    }
}
