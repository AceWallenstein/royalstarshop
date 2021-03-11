package com.pinnoocle.royalstarshop.mine.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pedaily.yc.ycdialoglib.toast.ToastUtils;
import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.adapter.QuestionAdapter;
import com.pinnoocle.royalstarshop.adapter.QuestionRecordAdapter;
import com.pinnoocle.royalstarshop.bean.FeedbackListModel;
import com.pinnoocle.royalstarshop.bean.LoginBean;
import com.pinnoocle.royalstarshop.bean.StatusModel;
import com.pinnoocle.royalstarshop.common.BaseActivity;
import com.pinnoocle.royalstarshop.nets.DataRepository;
import com.pinnoocle.royalstarshop.nets.Injection;
import com.pinnoocle.royalstarshop.nets.RemotDataSource;
import com.pinnoocle.royalstarshop.utils.FastData;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class QuestionRecordActivity extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    private DataRepository dataRepository;
    private QuestionRecordAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initWhite();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_record);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    private void initView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new QuestionRecordAdapter(this);
        recyclerView.setAdapter(adapter);
    }

    private void initData() {
        dataRepository = Injection.dataRepository(this);
        feedbackList();
    }

    private void feedbackList() {
        ViewLoading.show(this);
        LoginBean loginBean = new LoginBean();
        loginBean.wxapp_id = "10001";
        loginBean.token = FastData.getToken();
        dataRepository.feedbackList(loginBean, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(QuestionRecordActivity.this);

            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(QuestionRecordActivity.this);
                FeedbackListModel feedbackListModel = (FeedbackListModel) data;
                if (feedbackListModel.getCode() == 1) {
                    List<FeedbackListModel.DataBeanX.DataBean> dataBeanList = feedbackListModel.getData().getData();
                    adapter.setData(dataBeanList);
                }
//                ToastUtils.showToast(statusModel.getMsg());
            }
        });
    }


    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }
}
