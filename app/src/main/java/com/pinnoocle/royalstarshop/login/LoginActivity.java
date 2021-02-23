package com.pinnoocle.royalstarshop.login;

import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.pedaily.yc.ycdialoglib.toast.ToastUtils;
import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.common.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initTransparent();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        final String linkWord1 = "《用户协议》";
        String word = "注册/登录表示您同意广视优品" + linkWord1;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(word);
        int index1 = word.indexOf(linkWord1);
        spannableStringBuilder.setSpan(new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                ToastUtils.showToast("暂无用户协议");
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
    }
}