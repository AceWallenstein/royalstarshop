package com.pinnoocle.royalstarshop.vip;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pedaily.yc.ycdialoglib.toast.ToastUtils;
import com.pinnoocle.royalstarshop.MainActivity;
import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.bean.LoginBean;
import com.pinnoocle.royalstarshop.bean.LoginModel;
import com.pinnoocle.royalstarshop.bean.ResultModel;
import com.pinnoocle.royalstarshop.common.BaseActivity;
import com.pinnoocle.royalstarshop.login.LoginActivity;
import com.pinnoocle.royalstarshop.nets.DataRepository;
import com.pinnoocle.royalstarshop.nets.Injection;
import com.pinnoocle.royalstarshop.nets.RemotDataSource;
import com.pinnoocle.royalstarshop.utils.FastData;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class InvitationCodeActivity extends BaseActivity {
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.tv_invitation_code)
    TextView tvInvitationCode;
    @BindView(R.id.ed_code)
    EditText edCode;
    @BindView(R.id.tv_submit)
    TextView tvSubmit;
    @BindView(R.id.tv_tip)
    TextView tvTip;
    @BindView(R.id.tv_tip_content)
    TextView tvTipContent;
    @BindView(R.id.tv_skip)
    TextView tvSkip;
    private DataRepository dataRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initTransparent();
        setContentView(R.layout.activity_invitation_code);
        ButterKnife.bind(this);
        dataRepository = Injection.dataRepository(this);

    }

    private void bindParent(String code) {
        ViewLoading.show(this);
        LoginBean loginBean = new LoginBean();
        loginBean.code = code;
        loginBean.token = FastData.getToken();
        loginBean.wxapp_id = "10001";
        dataRepository.bindParent(loginBean, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(InvitationCodeActivity.this);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(InvitationCodeActivity.this);
                ResultModel loginModel = (ResultModel) data;
                if (loginModel.getCode() == 1) {
//                    startActivity(new Intent(InvitationCodeActivity.this, MainActivity.class));
                    finish();
                }
            }
        });
    }

    @OnClick({R.id.tv_submit, R.id.tv_skip})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_submit:
                if(!TextUtils.isEmpty(edCode.getText().toString())){
                    bindParent(edCode.getText().toString());
                }else {
                    ToastUtils.showToast("请输入邀请码");
                }
                break;
            case R.id.tv_skip:
                startActivity(new Intent(InvitationCodeActivity.this, VipActivity.class));
                finish();
                break;
        }
    }
}


