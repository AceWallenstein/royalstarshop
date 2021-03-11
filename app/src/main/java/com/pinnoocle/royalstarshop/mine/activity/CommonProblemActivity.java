package com.pinnoocle.royalstarshop.mine.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.adapter.QuestionAdapter;
import com.pinnoocle.royalstarshop.adapter.ScanListAdapter;
import com.pinnoocle.royalstarshop.bean.CollectListModel;
import com.pinnoocle.royalstarshop.bean.LoginBean;
import com.pinnoocle.royalstarshop.bean.QuestionModel;
import com.pinnoocle.royalstarshop.common.BaseActivity;
import com.pinnoocle.royalstarshop.common.BaseAdapter;
import com.pinnoocle.royalstarshop.nets.DataRepository;
import com.pinnoocle.royalstarshop.nets.Injection;
import com.pinnoocle.royalstarshop.nets.RemotDataSource;
import com.pinnoocle.royalstarshop.utils.FastData;
import com.pinnoocle.royalstarshop.widget.CommItemDecoration;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CommonProblemActivity extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.recycleView)
    RecyclerView recycleView;
    @BindView(R.id.tv_feed_back)
    TextView tvFeedBack;
    private QuestionAdapter questionAdapter;
    private DataRepository dataRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initWhite();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_problem);
        ButterKnife.bind(this);
        dataRepository = Injection.dataRepository(this);

        questionAdapter = new QuestionAdapter(this);
        recycleView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recycleView.addItemDecoration(new CommItemDecoration(this, DividerItemDecoration.VERTICAL, 0xffeeeeee, 1));
        recycleView.setAdapter(questionAdapter);

        questionAdapter.setOnItemDataClickListener(new BaseAdapter.OnItemDataClickListener<QuestionModel.DataBean>() {
            @Override
            public void onItemViewClick(View view, int position, QuestionModel.DataBean o) {
                Intent intent = new Intent(CommonProblemActivity.this, CommonProblemDetailActivity.class);
                intent.putExtra("content", o.getContent());
                intent.putExtra("title", o.getTitle());
                startActivity(intent);
            }
        });
        question();
    }

    private void question() {
        ViewLoading.show(this);
        LoginBean loginBean = new LoginBean();
        loginBean.wxapp_id = "10001";
        dataRepository.question(loginBean, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(CommonProblemActivity.this);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(CommonProblemActivity.this);
                QuestionModel questionModel = (QuestionModel) data;
                if (questionModel.getCode() == 1) {
                    questionAdapter.setData(questionModel.getData());
                }
            }
        });
    }

    @OnClick({R.id.iv_back, R.id.tv_feed_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_feed_back:

                break;
        }
    }
}