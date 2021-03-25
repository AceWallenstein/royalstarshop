package com.pinnoocle.royalstarshop.mine.activity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pedaily.yc.ycdialoglib.toast.ToastUtils;
import com.pinnoocle.royalstarshop.MyApp;
import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.bean.DataBean;
import com.pinnoocle.royalstarshop.bean.IsBindModel;
import com.pinnoocle.royalstarshop.bean.LoginBean;
import com.pinnoocle.royalstarshop.bean.StatusModel;
import com.pinnoocle.royalstarshop.bean.WithdrawSettingModel;
import com.pinnoocle.royalstarshop.common.BaseActivity;
import com.pinnoocle.royalstarshop.nets.DataRepository;
import com.pinnoocle.royalstarshop.nets.Injection;
import com.pinnoocle.royalstarshop.nets.RemotDataSource;
import com.pinnoocle.royalstarshop.utils.FastData;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import org.greenrobot.eventbus.EventBus;

import java.text.DecimalFormat;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WithdrawalActivity extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.ed_money)
    EditText edMoney;
    @BindView(R.id.tv_withdrawal_money)
    TextView tvWithdrawalMoney;
    @BindView(R.id.iv_weixin_pay)
    ImageView ivWeixinPay;
    @BindView(R.id.iv_alipay)
    ImageView ivAlipay;
    @BindView(R.id.tv_sure)
    TextView tvSure;
    @BindView(R.id.tv_service_charge)
    TextView tvServiceCharge;
    private DataRepository dataRepository;
    private IWXAPI api;
    private double rate;
    private double max;
    private double min;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initWhite();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_withdrawal);
        ButterKnife.bind(this);
        initView();
        initData();
    }


    private void initView() {
        edMoney.addTextChangedListener(new MoneyTextWatcher(edMoney));

    }

    public class MoneyTextWatcher implements TextWatcher {
        private EditText editText;
        private int digits = 2;

        public MoneyTextWatcher(EditText et) {
            editText = et;
        }

        public MoneyTextWatcher setDigits(int d) {
            digits = d;
            return this;
        }


        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (s.toString().length() > 0) {
                //删除“.”后面超过2位后的数据
                if (s.toString().contains(".")) {
                    if (s.length() - 1 - s.toString().indexOf(".") > digits) {
                        s = s.toString().subSequence(0,
                                s.toString().indexOf(".") + digits + 1);
                        editText.setText(s);
                        editText.setSelection(s.length()); //光标移到最后
                    }
                }
                //如果"."在起始位置,则起始位置自动补0
                if (s.toString().trim().substring(0).equals(".")) {
                    s = "0" + s;
                    editText.setText(s);
                    editText.setSelection(2);
                }

                //如果起始位置为0,且第二位跟的不是".",则无法后续输入
                if (s.toString().startsWith("0")
                        && s.toString().trim().length() > 1) {
                    if (!s.toString().substring(1, 2).equals(".")) {
                        editText.setText(s.subSequence(0, 1));
                        editText.setSelection(1);
                        return;
                    }
                }
                if (!TextUtils.isEmpty(s.toString()) && Double.parseDouble(s.toString()) >= 0.01) {
                    tvSure.setEnabled(true);
                } else {
                    tvSure.setEnabled(false);
                }
            } else {
                tvSure.setEnabled(false);
//                edMoney.setText("￥0.00");
            }
        }

        @Override
        public void afterTextChanged(Editable s) {
            if(!TextUtils.isEmpty(s)){
                DecimalFormat df = new DecimalFormat("#####0.00");
                double s1 = Double.parseDouble(s.toString()) * rate/100;
                tvServiceCharge.setText(df.format(s1) + "元");
            }else {
                tvServiceCharge.setText("0.00元");
            }
        }
    }

    private void initData() {
        dataRepository = Injection.dataRepository(this);
        withdrawSetting();
//        isBind();
    }


    private void isBind() {
        LoginBean loginBean = new LoginBean();
        loginBean.wxapp_id = "10001";
        loginBean.token = FastData.getToken();


        dataRepository.isBind(loginBean, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {

            }

            @Override
            public void onSuccess(Object data) {
                StatusModel statusModel = (StatusModel) data;
                if (statusModel.getCode() == 1) {
                    IsBindModel.DataBean dataBean = new Gson().fromJson(statusModel.getData(), IsBindModel.DataBean.class);
                    if (dataBean.getCode() == 1) {
                        DataBean dataBean1 = new DataBean(10, edMoney.getText().toString());
                        String toJson = new Gson().toJson(dataBean1);
                        withdraw(toJson);
                    } else {
                        weChatAuth();
                    }
                }

            }
        });
    }

    private void withdraw(String data) {
        ViewLoading.show(mContext);
        LoginBean loginBean = new LoginBean();
        loginBean.wxapp_id = "10001";
        loginBean.token = FastData.getToken();
        loginBean.data = data;
        dataRepository.withdraw(loginBean, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(mContext);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(mContext);
                StatusModel statusModel = (StatusModel) data;
                if (statusModel.getCode() == 1) {
                    EventBus.getDefault().post("4");
                }
                    ToastUtils.showToast(statusModel.getMsg());

            }
        });
    }

    private void withdrawSetting() {
        LoginBean loginBean = new LoginBean();
        loginBean.wxapp_id = "10001";
        loginBean.token = FastData.getToken();
        dataRepository.withdrawSetting(loginBean, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {

            }

            @Override
            public void onSuccess(Object data) {

                WithdrawSettingModel withdrawSettingModel = (WithdrawSettingModel) data;
                if (withdrawSettingModel.getCode() == 1) {
                    max = withdrawSettingModel.getData().getMax();
                    min = withdrawSettingModel.getData().getMin();
                    String money = withdrawSettingModel.getData().getMoney();
                    rate = withdrawSettingModel.getData().getRate();
                    tvWithdrawalMoney.setText("￥" + money);
                    edMoney.setHint("最低"+min+"元起提");

                }

            }
        });
    }


    private void weChatAuth() {
        if (!MyApp.mWxApi.isWXAppInstalled()) {
            ToastUtils.showToast("您还未安装微信客户端");
            return;
        }
        if (api == null) {
            api = WXAPIFactory.createWXAPI(this, MyApp.WX_APPID, true);
        }
        SendAuth.Req req = new SendAuth.Req();
        req.scope = "snsapi_userinfo";
        req.state = "wx_login_duzun";
        api.sendReq(req);
    }


    @OnClick({R.id.iv_back, R.id.tv_sure})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_sure:
                if (TextUtils.isEmpty(edMoney.getText().toString())) {
                    ToastUtils.showToast("请输入提现金额");
                    return;
                }
                if (Double.parseDouble(edMoney.getText().toString())<min) {
                    ToastUtils.showToast("最小提现金额为"+min+"元");
                    return;
                }
                if (Double.parseDouble(edMoney.getText().toString())>max) {
                    ToastUtils.showToast("超过最大金额"+max+"元");
                    return;
                }
                isBind();
                break;
        }
    }
}