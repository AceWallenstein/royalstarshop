package com.pinnoocle.royalstarshop.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.pedaily.yc.ycdialoglib.toast.ToastUtils;
import com.pinnoocle.royalstarshop.MyApp;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;


import org.greenrobot.eventbus.EventBus;

public class WXPayEntryActivity extends Activity implements IWXAPIEventHandler {
    private static String TAG = "WXPayEntryActivity";
//    CustomDialogLoading customDialogLoading = new CustomDialogLoading(this);


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //如果没回调onResp，八成是这句没有写
        MyApp.mWxApi.handleIntent(getIntent(), this);

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        setIntent(intent);
        MyApp.mWxApi.handleIntent(intent, this);
    }

    @Override
    public void onReq(BaseReq req) {
        switch (req.getType()) {
            case ConstantsAPI.COMMAND_GETMESSAGE_FROM_WX:
                break;
            case ConstantsAPI.COMMAND_SHOWMESSAGE_FROM_WX:
                break;
            default:
                break;
        }
        finish();
    }

    @Override
    public void onResp(BaseResp resp) {
        int result = 0;

        if (resp.getType() == ConstantsAPI.COMMAND_PAY_BY_WX) {
            //获取微信传回的code
            int code = resp.errCode;
            switch (code){
                case 0://支付成功后的界面
                    ToastUtils.showToast("支付成功");
                    EventBus.getDefault().post("pay_success");
//                    EventBus.getDefault().post(new EventCenter(EventCode.FAHUO_PAY_SUCCESS));
                    //返回主页面 然后在跳转至订单页面
                    finish();
                    break;
                case -1:
                    //ToastUtil.showToast(getApplicationContext(), "签名错误、未注册APPID、项目设置APPID不正确、注册的APPID与设置的不匹配、您的微信账号异常等。");
                    ToastUtils.showToast("支付失败");
                    EventBus.getDefault().post("pay_fail");
                    finish();
                    break;
                case -2://用户取消支付后的界面
                    ToastUtils.showToast("您已取消支付");
                    EventBus.getDefault().post("pay_cancel");
                    finish();
                    break;
            }
        }

    }


}