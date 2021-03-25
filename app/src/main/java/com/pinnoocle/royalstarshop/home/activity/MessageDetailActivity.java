package com.pinnoocle.royalstarshop.home.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.bean.LoginBean;
import com.pinnoocle.royalstarshop.bean.MessageDetailModel;
import com.pinnoocle.royalstarshop.common.BaseActivity;
import com.pinnoocle.royalstarshop.nets.DataRepository;
import com.pinnoocle.royalstarshop.nets.Injection;
import com.pinnoocle.royalstarshop.nets.RemotDataSource;
import com.pinnoocle.royalstarshop.utils.FastData;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MessageDetailActivity extends BaseActivity {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.iv_type)
    ImageView ivType;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_content)
    TextView tvContent;
    @BindView(R.id.tv_time)
    TextView tvTime;
    private DataRepository dataRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initWhite();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_detail);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    private void initView() {

    }

    private void initData() {
        dataRepository = Injection.dataRepository(mContext);
        messageDetail();
    }

    private void messageDetail() {
        LoginBean loginBean = new LoginBean();
        loginBean.wxapp_id = "10001";
        loginBean.token = FastData.getToken();
        loginBean.id = getIntent().getStringExtra("id");
        ViewLoading.show(this);
        dataRepository.messageDetail(loginBean, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(mContext);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(mContext);
                MessageDetailModel messageDetailModel = (MessageDetailModel) data;
                if (messageDetailModel.getCode() == 1) {
                    tvContent.setText(messageDetailModel.getData().getContent());
                    if (messageDetailModel.getData().getType() == 10) {
                        ivType.setImageResource(R.mipmap.system_message);
                        tvTitle.setText("系统消息");
                    } else {
                        ivType.setImageResource(R.mipmap.transaction_logistics);
                        tvTitle.setText("物流消息");
                    }

                    if (!TextUtils.isEmpty(messageDetailModel.getData().getTitle())) {
                        tvTitle.setText(messageDetailModel.getData().getTitle());
                    }
                    tvTime.setText(messageDetailModel.getData().getUpdate_time());

                }
            }
        });

    }


    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }
}
