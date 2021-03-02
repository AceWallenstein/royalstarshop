package com.pinnoocle.royalstarshop.home.fragment;

import androidx.recyclerview.widget.RecyclerView;

import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.common.BaseFragment;

import butterknife.BindView;

public class GoodsCommentFragment extends BaseFragment {
    @BindView(R.id.recycleView)
    RecyclerView recycleView;

    @Override
    protected int LayoutId() {
        return R.layout.fragment_goods_comment;
    }
}
