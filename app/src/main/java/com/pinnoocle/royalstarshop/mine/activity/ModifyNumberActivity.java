package com.pinnoocle.royalstarshop.mine.activity;

import android.app.ActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pedaily.yc.ycdialoglib.toast.ToastUtils;
import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.bean.CodeModel;
import com.pinnoocle.royalstarshop.bean.LoginBean;
import com.pinnoocle.royalstarshop.bean.ResultModel;
import com.pinnoocle.royalstarshop.bean.StatusModel;
import com.pinnoocle.royalstarshop.common.AppManager;
import com.pinnoocle.royalstarshop.common.BaseActivity;
import com.pinnoocle.royalstarshop.login.LoginActivity;
import com.pinnoocle.royalstarshop.nets.DataRepository;
import com.pinnoocle.royalstarshop.nets.Injection;
import com.pinnoocle.royalstarshop.nets.RemotDataSource;
import com.pinnoocle.royalstarshop.utils.CountDownTimerUtils;
import com.pinnoocle.royalstarshop.utils.FastData;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ModifyNumberActivity extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.ed_phone)
    EditText edPhone;
    @BindView(R.id.tv_get_code)
    TextView tvGetCode;
    @BindView(R.id.tv_quit)
    TextView tvQuit;
    @BindView(R.id.ed_code)
    EditText edCode;
    private DataRepository dataRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initWhite();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_number);
        ButterKnife.bind(this);
        dataRepository = Injection.dataRepository(this);
    }

    private void sendMessages(String phone) {
        ViewLoading.show(this);
        LoginBean loginBean = new LoginBean();
        loginBean.mobile = phone;
        loginBean.type = "2";
        loginBean.wxapp_id = "10001";
        dataRepository.getCode(loginBean, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(ModifyNumberActivity.this);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(ModifyNumberActivity.this);
                ToastUtils.showToast("验证码发送成功");
                CodeModel data1 = (CodeModel) data;
                if (data1.getCode() == 1) {
                    ToastUtils.showToast(data1.getData().getCode() + "");
                }
                getCode();
            }
        });
    }

    private void changePhone(String phone) {
        ViewLoading.show(this);
        LoginBean loginBean = new LoginBean();
        loginBean.phone = phone;
        loginBean.token = FastData.getToken();
        loginBean.wxapp_id = "10001";
        loginBean.code = edCode.getText().toString();
        dataRepository.changePhone(loginBean, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(ModifyNumberActivity.this);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(ModifyNumberActivity.this);
                StatusModel data1 = (StatusModel) data;
                if (data1.getCode() == 1) {
                    ToastUtils.showToast("修改成功");
                    FastData.clear();
                    Intent intent = new Intent(ModifyNumberActivity.this, LoginActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    AppManager.getInstance().killAllActivity();
                }
            }
        });
    }

    private void getCode() {
        CountDownTimerUtils countDownTimerUtils = new CountDownTimerUtils(tvGetCode, 60000, 1000);
        countDownTimerUtils.start();
    }

    @OnClick({R.id.iv_back, R.id.tv_get_code, R.id.tv_quit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_get_code:
                String telRegex = "[1][3456789]\\d{9}";
                boolean matches = edPhone.getText().toString().matches(telRegex);
                if (TextUtils.isEmpty(edPhone.getText().toString())) {
                    ToastUtils.showToast("请输入手机号码");
                } else if (matches == false) {
                    ToastUtils.showToast("请输入正确的手机号码");
                } else {
                    //获取验证码
                    sendMessages(edPhone.getText().toString());
                }
                break;
            case R.id.tv_quit:
                if (TextUtils.isEmpty(edPhone.getText().toString())) {
                    ToastUtils.showToast("请输入手机号");
                    return;
                }
                if (TextUtils.isEmpty(edCode.getText().toString())) {
                    ToastUtils.showToast("请输入验证码");
                    return;
                }
                changePhone(edPhone.getText().toString());
                break;
        }
    }
}