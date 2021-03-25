package com.pinnoocle.royalstarshop.home.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.bean.LoginBean;
import com.pinnoocle.royalstarshop.bean.MessageCountModel;
import com.pinnoocle.royalstarshop.common.BaseActivity;
import com.pinnoocle.royalstarshop.login.LoginActivity;
import com.pinnoocle.royalstarshop.nets.DataRepository;
import com.pinnoocle.royalstarshop.nets.Injection;
import com.pinnoocle.royalstarshop.nets.RemotDataSource;
import com.pinnoocle.royalstarshop.utils.FastData;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MessageNewActivity extends BaseActivity {

    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.iv_sys_message)
    ImageView ivSysMessage;
    @BindView(R.id.tv_sys_message)
    TextView tvSysMessage;
    @BindView(R.id.tv_sys_message_num)
    TextView tvSysMessageNum;
    @BindView(R.id.tv_dot_sys)
    TextView tvDotSys;
    @BindView(R.id.rv_system_message)
    RelativeLayout rvSystemMessage;
    @BindView(R.id.iv_shop_message)
    ImageView ivShopMessage;
    @BindView(R.id.tv_express_message)
    TextView tvExpressMessage;
    @BindView(R.id.tv_express_message_num)
    TextView tvExpressMessageNum;
    @BindView(R.id.tv_dot_express)
    TextView tvDotExpress;
    @BindView(R.id.rv_express_message)
    RelativeLayout rvExpressMessage;
    private DataRepository dataRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initWhite();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_new);
        ButterKnife.bind(this);
        initView();
        initData();
    }


    private void initView() {

    }

    private void initData() {
        dataRepository = Injection.dataRepository(mContext);
        messageNum();
    }


    private void messageNum() {
        if (TextUtils.isEmpty(FastData.getToken())) {
            Intent intent = new Intent(this, LoginActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
            finish();
            return;
        }
        LoginBean loginBean = new LoginBean();
        loginBean.wxapp_id = "10001";
        loginBean.token = FastData.getToken();
        ViewLoading.show(this);
        dataRepository.messageCount(loginBean, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(mContext);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(mContext);
                MessageCountModel messageCountModel = (MessageCountModel) data;
                if (messageCountModel.getCode() == 1) {
                    MessageCountModel.DataBean.SystemBean system = messageCountModel.getData().getSystem();
                    if (system.getCount() > 0) {
                        tvDotSys.setVisibility(View.GONE);
                    } else {
                        if (system.getCount() > 99) {
                            tvDotSys.setText("99+");
                        } else {
                            tvDotSys.setText(system.getCount());
                        }
                    }
                    tvSysMessageNum.setText(messageCountModel.getData().getSystem().getLastNews().getContent());

                    MessageCountModel.DataBean.TradeBean trade = messageCountModel.getData().getTrade();
                    if (trade.getCount() > 0) {
                        tvDotExpress.setVisibility(View.GONE);
                    } else {
                        if (trade.getCount() > 99) {
                            tvDotExpress.setText("99+");
                        } else {
                            tvDotExpress.setText(trade.getCount());
                        }
                    }
                    tvExpressMessageNum.setText(messageCountModel.getData().getSystem().getLastNews().getContent());

                }
            }
        });

    }

    @OnClick({R.id.rv_system_message, R.id.rv_express_message})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rv_system_message:
                Intent intent = new Intent(mContext, MessageListActivity.class);
                intent.putExtra("type","10");
                startActivity(intent);

                break;
            case R.id.rv_express_message:
                Intent intent1 = new Intent(mContext, MessageListActivity.class);
                intent1.putExtra("type","20");
                startActivity(intent1);

                break;
        }
    }
}