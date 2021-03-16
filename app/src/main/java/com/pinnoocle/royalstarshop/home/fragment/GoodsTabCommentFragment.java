package com.pinnoocle.royalstarshop.home.fragment;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.adapter.GoodsCommentAdapter;
import com.pinnoocle.royalstarshop.bean.CommentListModel;
import com.pinnoocle.royalstarshop.bean.LoginBean;
import com.pinnoocle.royalstarshop.common.BaseFragment;
import com.pinnoocle.royalstarshop.nets.DataRepository;
import com.pinnoocle.royalstarshop.nets.Injection;
import com.pinnoocle.royalstarshop.nets.RemotDataSource;
import com.pinnoocle.royalstarshop.utils.FastData;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class GoodsTabCommentFragment extends BaseFragment {


    @BindView(R.id.recycleView)
    RecyclerView recycleView;
    private DataRepository dataRepository;
    private String goods_id;
    private String scoreType;
    private GoodsCommentAdapter adapter;
    private int page = 1;
    private List<CommentListModel.DataBeanX.ListBean.DataBean> dataBeanList = new ArrayList<CommentListModel.DataBeanX.ListBean.DataBean>();


    public GoodsTabCommentFragment(String goods_id, String scoreType) {
        this.goods_id = goods_id;
        this.scoreType = scoreType;
    }

    @Override
    protected int LayoutId() {
        return R.layout.fragment_goods_tab_comment;
    }

    @Override
    protected void initView() {
        super.initView();
        recycleView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new GoodsCommentAdapter(getContext());
        recycleView.setAdapter(adapter);


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
        dataRepository.commentList(loginBean, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {

            }

            @Override
            public void onSuccess(Object data) {
                CommentListModel commentListModel = (CommentListModel) data;
                if (commentListModel.getCode() == 1) {
                    for (int i = 0; i < commentListModel.getData().getList().getData().size(); i++) {
                        dataBeanList.add(commentListModel.getData().getList().getData().get(i));
                        if (i > 2)
                            return;
                    }
                    adapter.setData(dataBeanList);
                }
            }


        });
    }

}
