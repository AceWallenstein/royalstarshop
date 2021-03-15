package com.pinnoocle.royalstarshop.mine.fragment;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.adapter.MyCommentAdapter;
import com.pinnoocle.royalstarshop.bean.CommentModel;
import com.pinnoocle.royalstarshop.bean.LoginBean;
import com.pinnoocle.royalstarshop.bean.OrderListModel;
import com.pinnoocle.royalstarshop.common.BaseFragment;
import com.pinnoocle.royalstarshop.nets.DataRepository;
import com.pinnoocle.royalstarshop.nets.Injection;
import com.pinnoocle.royalstarshop.nets.RemotDataSource;
import com.pinnoocle.royalstarshop.utils.FastData;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MyCommentsFragment extends BaseFragment implements OnRefreshLoadMoreListener {
    @BindView(R.id.tv_empty)
    TextView tvEmpty;
    @BindView(R.id.recycleView)
    RecyclerView recycleView;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;

    private String type;
    private DataRepository dataRepository;
    private MyCommentAdapter adapter;
    private List<OrderListModel.DataBeanX.ListBean.DataBean> dataBeanList = new ArrayList<>();
    private int page = 1;

    public MyCommentsFragment(String type) {
        this.type = type;
    }

    @Override
    protected int LayoutId() {
        return R.layout.fragment_my_comments;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN, priority = 100, sticky = false) //在ui线程执行，优先级为100
    public void onEvent(String event) {
        if(event.equals("comment_refresh")){
            page = 1;
            dataBeanList.clear();
            myComments();
        }
    }

    @Override
    protected void initView() {
        recycleView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new MyCommentAdapter(getContext());
        recycleView.setAdapter(adapter);
        refresh.setOnRefreshLoadMoreListener(this);
    }

    @Override
    protected void initData() {
        dataRepository = Injection.dataRepository(getContext());

    }

    private void myComments() {
        LoginBean loginBean = new LoginBean();
        loginBean.wxapp_id = "10001";
        loginBean.token = FastData.getToken();
        loginBean.page = page + "";
        ViewLoading.show(getContext());
        dataRepository.myComments(loginBean, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(getContext());
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(getContext());
                CommentModel commentModel = (CommentModel) data;
                refresh.finishRefresh();
//                if (orderListModel.getCode() == 1) {
//                    if (orderListModel.getData().getList().getCurrent_page() == orderListModel.getData().getList().getLast_page()) {
//                        refresh.finishLoadMoreWithNoMoreData();
//                    } else {
//                        refresh.finishLoadMore();
//                    }
//                    if (dataBeanList.size() == 0 && orderListModel.getData().getList().getData().size() == 0) {
//                        tvEmpty.setVisibility(View.VISIBLE);
//                        recycleView.setVisibility(View.GONE);
//                    } else {
//                        tvEmpty.setVisibility(View.GONE);
//                        recycleView.setVisibility(View.VISIBLE);
//                        dataBeanList.addAll(orderListModel.getData().getList().getData());
//                        commentAdapter.setData(dataBeanList);
//                    }
//
//                }
            }
        });
    }

    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        page++;
        myComments();
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        page = 1;
        dataBeanList.clear();
        myComments();
    }

}
