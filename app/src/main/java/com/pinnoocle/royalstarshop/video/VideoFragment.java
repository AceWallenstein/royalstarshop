package com.pinnoocle.royalstarshop.video;

import android.content.Intent;
import android.widget.EditText;
import android.widget.RelativeLayout;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.adapter.AdoptAdapter;
import com.pinnoocle.royalstarshop.common.BaseFragment;
import com.pinnoocle.royalstarshop.widget.CommItemDecoration;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import butterknife.BindView;

public class VideoFragment extends BaseFragment implements AdoptAdapter.OnItemClickListener {
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.ed_search)
    EditText edSearch;
    @BindView(R.id.recycleView)
    RecyclerView recycleView;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
    AdoptAdapter videoAdapter;

    @Override
    protected int LayoutId() {
        return R.layout.fragment_video;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        recycleView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recycleView.addItemDecoration(new CommItemDecoration(getContext(), DividerItemDecoration.VERTICAL, getResources().getColor(R.color.transparent), 30));
        videoAdapter = new AdoptAdapter(getContext());
        recycleView.setAdapter(videoAdapter);

        videoAdapter.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(getActivity(), VideoDetailActivity.class);
        startActivity(intent);
    }
}
