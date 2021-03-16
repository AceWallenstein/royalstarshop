package com.pinnoocle.royalstarshop.home.fragment;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.adapter.GoodsCommentAdapter;
import com.pinnoocle.royalstarshop.adapter.MyCommentAdapter;
import com.pinnoocle.royalstarshop.bean.CommentListModel;
import com.pinnoocle.royalstarshop.bean.LoginBean;
import com.pinnoocle.royalstarshop.common.BaseFragment;
import com.pinnoocle.royalstarshop.nets.DataRepository;
import com.pinnoocle.royalstarshop.nets.Injection;
import com.pinnoocle.royalstarshop.nets.RemotDataSource;
import com.pinnoocle.royalstarshop.utils.FastData;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class GoodsCommentFragment extends BaseFragment implements OnRefreshLoadMoreListener {


    @BindView(R.id.tv_empty)
    TextView tvEmpty;
    @BindView(R.id.recycleView)
    RecyclerView recycleView;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
    private DataRepository dataRepository;
    private String goods_id;
    private String scoreType;
    private GoodsCommentAdapter adapter;
    private int page =1;
    private List<CommentListModel.DataBeanX.ListBean.DataBean> dataBeanList = new ArrayList<CommentListModel.DataBeanX.ListBean.DataBean>();


    public GoodsCommentFragment(String goods_id, String scoreType) {
        this.goods_id = goods_id;
        this.scoreType = scoreType;
    }

    @Override
    protected int LayoutId() {
        return R.layout.fragment_goods_comment;
    }

    @Override
    protected void initView() {
        super.initView();
        recycleView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new GoodsCommentAdapter(getContext());
        recycleView.setAdapter(adapter);
        refresh.setOnRefreshLoadMoreListener(this);

    }

    @Override
    protected void initData() {
        super.initData();
        dataRepository = Injection.dataRepository(getContext());
        commentList();
    }

    private void commentList() {
        LoginBean loginBean = new LoginBean();
        loginBean.wxapp_id = "10001";
        loginBean.token = FastData.getToken();
        loginBean.goods_id = goods_id;
        loginBean.scoreType = scoreType;
        loginBean.page = page + "";
        ViewLoading.show(getContext());
        dataRepository.commentList(loginBean, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(getContext());
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(getContext());
                refresh.finishRefresh();
                CommentListModel commentListModel = (CommentListModel) data;
                if (commentListModel.getCode() == 1) {
                    if (commentListModel.getData().getList().getCurrent_page() == commentListModel.getData().getList().getLast_page()) {
                        refresh.finishLoadMoreWithNoMoreData();
                    } else {
                        refresh.finishLoadMore();
                    }
                    if (commentListModel.getData().getList().getData().size() == 0) {
                        tvEmpty.setVisibility(View.VISIBLE);
                        recycleView.setVisibility(View.GONE);
                    } else {
                        tvEmpty.setVisibility(View.GONE);
                        recycleView.setVisibility(View.VISIBLE);
                        dataBeanList.addAll(commentListModel.getData().getList().getData());
                        adapter.setData(dataBeanList);
                    }
                }

            }
        });
    }

    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        page++;
        commentList();
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        page = 1;
        dataBeanList.clear();
        commentList();
    }

}
