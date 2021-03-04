package com.pinnoocle.royalstarshop.mine.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lxj.xpopup.XPopup;
import com.lxj.xpopupext.listener.TimePickerListener;
import com.lxj.xpopupext.popup.TimePickerPopup;
import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.common.BaseActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PersonalActivity extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.iv_right)
    ImageView ivRight;
    @BindView(R.id.rl_birth)
    RelativeLayout rlBirth;
    @BindView(R.id.tv_birth)
    TextView tvBirth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initWhite();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.iv_back, R.id.rl_birth})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.rl_birth:
                showTimerPickerPopup(tvBirth);
                break;
        }
    }

    private void showTimerPickerPopup(TextView textView) {
        TimePickerPopup popup = new TimePickerPopup(this)
                .setTimePickerListener(new TimePickerListener() {
                    @Override
                    public void onTimeChanged(Date date) {

                    }

                    @Override
                    public void onTimeConfirm(Date date, View view) {
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        textView.setText(simpleDateFormat.format(date));
                    }
                });

        new XPopup.Builder(this)
                .asCustom(popup)
                .show();
    }
}