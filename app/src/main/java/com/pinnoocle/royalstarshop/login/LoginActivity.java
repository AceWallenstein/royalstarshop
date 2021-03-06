package com.pinnoocle.royalstarshop.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pedaily.yc.ycdialoglib.toast.ToastUtils;
import com.pinnoocle.royalstarshop.MainActivity;
import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.bean.CodeModel;
import com.pinnoocle.royalstarshop.bean.LoginBean;
import com.pinnoocle.royalstarshop.bean.LoginModel;
import com.pinnoocle.royalstarshop.bean.StatusModel;
import com.pinnoocle.royalstarshop.common.BaseActivity;
import com.pinnoocle.royalstarshop.nets.DataRepository;
import com.pinnoocle.royalstarshop.nets.Injection;
import com.pinnoocle.royalstarshop.nets.RemotDataSource;
import com.pinnoocle.royalstarshop.utils.CountDownTimerUtils;
import com.pinnoocle.royalstarshop.utils.FastData;
import com.pinnoocle.royalstarshop.vip.InvitationCodeActivity;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {

    @BindView(R.id.ed_phone)
    EditText edPhone;
    @BindView(R.id.view)
    View view;
    @BindView(R.id.ed_code)
    EditText edCode;
    @BindView(R.id.view1)
    View view1;
    @BindView(R.id.tv_get_code)
    TextView tvGetCode;
    @BindView(R.id.rl_code)
    RelativeLayout rlCode;
    @BindView(R.id.view2)
    View view2;
    @BindView(R.id.tv_login)
    TextView tvLogin;
    @BindView(R.id.tv_adoption_agreement)
    TextView tvAdoptionAgreement;
    @BindView(R.id.rl_logo)
    RelativeLayout rlLogo;
    @BindView(R.id.checkbox)
    CheckBox checkbox;
    @BindView(R.id.ll_adoption_agreement)
    LinearLayout llAdoptionAgreement;
    private DataRepository dataRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initTransparent();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        if (!TextUtils.isEmpty(FastData.getToken())) {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }
        dataRepository = Injection.dataRepository(this);

        final String linkWord1 = "《用户协议》";
        String word = "注册/登录表示您同意广视优品" + linkWord1;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(word);
        int index1 = word.indexOf(linkWord1);
        spannableStringBuilder.setSpan(new ClickableSpan() {
            @Override
            public void onClick(View widget) {

//                ToastUtils.showToast("暂无用户协议");
                startActivity(new Intent(mContext,DisclaimerActivity.class));
            }

            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(0xffFF2329);       //设置文件颜色
                ds.setUnderlineText(false);
            }
        }, index1, index1 + linkWord1.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        tvAdoptionAgreement.setText(spannableStringBuilder);
        tvAdoptionAgreement.setMovementMethod(LinkMovementMethod.getInstance());
        tvAdoptionAgreement.setHighlightColor(getResources().getColor(R.color.transparent));
        checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    tvLogin.setEnabled(true);
                }else {
                    tvLogin.setEnabled(false);
                }
            }
        });
    }

    @OnClick({R.id.tv_get_code, R.id.tv_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
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
            case R.id.tv_login:
                if (TextUtils.isEmpty(edPhone.getText().toString())) {
                    ToastUtils.showToast("请输入手机号码");
                    return;
                }
                if (TextUtils.isEmpty(edCode.getText().toString())) {
                    ToastUtils.showToast("请输入验证码");
                    return;
                }
                login(edPhone.getText().toString(), edCode.getText().toString());
                break;
        }
    }

    private void login(String phone, String code) {
        ViewLoading.show(this);
        LoginBean loginBean = new LoginBean();
        loginBean.mobile = phone;
        loginBean.code = code;
        loginBean.wxapp_id = "10001";
        dataRepository.reg(loginBean, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(LoginActivity.this);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(LoginActivity.this);
                StatusModel statusModel = (StatusModel) data;
                if (statusModel.getCode() == 1) {
                    LoginModel.DataBean dataBean = new Gson().fromJson(statusModel.getData(), LoginModel.DataBean.class);
                    FastData.setUserId(dataBean.getUser().getUser_id());
                    FastData.setToken(dataBean.getToken());
                    if (dataBean.getIs_first() == 1) {
                        startActivity(new Intent(LoginActivity.this, InvitationCodeActivity.class));
                    }
                    else {
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    }
                    EventBus.getDefault().post("4");
                    finish();

                }
                ToastUtils.showToast(statusModel.getMsg());

            }
        });
    }

    private void sendMessages(String phone) {
        ViewLoading.show(this);
        LoginBean loginBean = new LoginBean();
        loginBean.mobile = phone;
        loginBean.type = "1";
        loginBean.wxapp_id = "10001";
        dataRepository.getCode(loginBean, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(LoginActivity.this);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(LoginActivity.this);
                CodeModel data1 = (CodeModel) data;
                if (data1.getCode() == 1) {
                    ToastUtils.showToast("验证码发送成功");
//                    ToastUtils.showToast(data1.getData().getCode() + "");
                    getCode();
                } else {
                    ToastUtils.showToast(data1.getMsg() + "");

                }
            }
        });
    }

    private void getCode() {
        CountDownTimerUtils countDownTimerUtils = new CountDownTimerUtils(tvGetCode, 60000, 1000);
        countDownTimerUtils.start();
    }

    @Override
    public void onBackPressed() {
        if (getIntent().getIntExtra("pos", -1) == 1) {
            finish();
        } else {
            EventBus.getDefault().post("6");
            finish();
        }
    }
}