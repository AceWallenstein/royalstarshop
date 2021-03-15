package com.pinnoocle.royalstarshop.video;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.adapter.AdoptAdapter;
import com.pinnoocle.royalstarshop.bean.GoodsListsModel;
import com.pinnoocle.royalstarshop.bean.LoginBean;
import com.pinnoocle.royalstarshop.common.BaseFragment;
import com.pinnoocle.royalstarshop.home.activity.GoodsDetailActivity;
import com.pinnoocle.royalstarshop.nets.DataRepository;
import com.pinnoocle.royalstarshop.nets.Injection;
import com.pinnoocle.royalstarshop.nets.RemotDataSource;
import com.pinnoocle.royalstarshop.widget.CommItemDecoration;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class VideoFragment extends BaseFragment implements AdoptAdapter.OnItemClickListener, OnRefreshLoadMoreListener {
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.ed_search)
    EditText edSearch;
    @BindView(R.id.recycleView)
    RecyclerView recycleView;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
    AdoptAdapter videoAdapter;
    private DataRepository dataRepository;
    private int page = 1;
    private List<GoodsListsModel.DataBeanX.ListBean.DataBean> dataBeanList = new ArrayList<>();

    @Override
    protected int LayoutId() {
        return R.layout.fragment_video;
    }

    @Override
    protected void initData() {
        dataRepository = Injection.dataRepository(getContext());
        goodsLists(page);
    }

    private void goodsLists(int page) {
        ViewLoading.show(getContext());
        LoginBean loginBean = new LoginBean();
        loginBean.wxapp_id = "10001";
        loginBean.type = "2";
        loginBean.page = page + "";
        dataRepository.goodsLists(loginBean, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(getContext());
                refresh.finishRefresh();
                refresh.finishLoadMore();
            }

            @Override
            public void onSuccess(Object data) {
                refresh.finishRefresh();
                ViewLoading.dismiss(getContext());
                GoodsListsModel goodsListsModel = (GoodsListsModel) data;
                if (goodsListsModel.getCode() == 1) {
                    if (goodsListsModel.getData().getList().getCurrent_page() == goodsListsModel.getData().getList().getLast_page()) {
                        refresh.finishLoadMoreWithNoMoreData();
                    } else {
                        refresh.finishLoadMore();
                    }
                    dataBeanList.addAll(goodsListsModel.getData().getList().getData());
                    videoAdapter.setData(dataBeanList);
                }
            }
        });
    }

    @Override
    protected void initView() {
        recycleView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recycleView.addItemDecoration(new CommItemDecoration(getContext(), DividerItemDecoration.VERTICAL, getResources().getColor(R.color.transparent), 30));
        videoAdapter = new AdoptAdapter(getContext());
        recycleView.setAdapter(videoAdapter);

        videoAdapter.setOnItemClickListener(this);

        refresh.setOnRefreshLoadMoreListener(this);
    }

    @Override
    public void onItemClick(View v, int position) {
        if(v.getId() == R.id.iv_image){
            Intent intent = new Intent(getActivity(), VideoDetailActivity.class);
            intent.putExtra("dataBeanList", (Serializable) dataBeanList);
            intent.putExtra("pos", position);
            startActivity(intent);
        }else {
            Intent intent = new Intent(getActivity(), GoodsDetailActivity.class);
            intent.putExtra("goods_id", dataBeanList.get(position).getGoods_id() + "");
            startActivity(intent);
        }
    }

    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        page++;
        goodsLists(page);
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        page = 1;
        dataBeanList.clear();
        goodsLists(page);
    }
}
