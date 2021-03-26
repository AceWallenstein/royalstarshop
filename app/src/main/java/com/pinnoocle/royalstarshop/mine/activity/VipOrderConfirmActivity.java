package com.pinnoocle.royalstarshop.mine.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pedaily.yc.ycdialoglib.toast.ToastUtils;
import com.pinnoocle.royalstarshop.MyApp;
import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.adapter.OrderConfirmAdapter;
import com.pinnoocle.royalstarshop.adapter.VipOrderConfirmAdapter;
import com.pinnoocle.royalstarshop.bean.AddressDefaultModel;
import com.pinnoocle.royalstarshop.bean.AddressListModel;
import com.pinnoocle.royalstarshop.bean.LoginBean;
import com.pinnoocle.royalstarshop.bean.PayStatusModel;
import com.pinnoocle.royalstarshop.bean.StatusModel;
import com.pinnoocle.royalstarshop.bean.SureOrderModel;
import com.pinnoocle.royalstarshop.bean.WxPayResultModel;
import com.pinnoocle.royalstarshop.common.BaseActivity;
import com.pinnoocle.royalstarshop.common.BaseAdapter;
import com.pinnoocle.royalstarshop.event.ShopCartRefreshEvent;
import com.pinnoocle.royalstarshop.home.activity.GoodsDetailActivity;
import com.pinnoocle.royalstarshop.nets.DataRepository;
import com.pinnoocle.royalstarshop.nets.Injection;
import com.pinnoocle.royalstarshop.nets.RemotDataSource;
import com.pinnoocle.royalstarshop.utils.FastData;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.timmy.tdialog.TDialog;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class VipOrderConfirmActivity extends BaseActivity {


    @BindView(R.id.iv_bg)
    ImageView ivBg;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.tv_address)
    TextView tvAddress;
    @BindView(R.id.rl_address)
    RelativeLayout rlAddress;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.iv_weixin_pay)
    ImageView ivWeixinPay;
    @BindView(R.id.iv_alipay)
    ImageView ivAlipay;
    @BindView(R.id.scrollView)
    NestedScrollView scrollView;
    @BindView(R.id.tv_total)
    TextView tvTotal;
    @BindView(R.id.tv_total_price)
    TextView tvTotalPrice;
    @BindView(R.id.tv_discount)
    TextView tvDiscount;
    @BindView(R.id.tv_settlement)
    TextView tvSettlement;
    @BindView(R.id.rl_panel)
    RelativeLayout rlPanel;
    @BindView(R.id.iv_money)
    ImageView ivMoney;
    @BindView(R.id.tv_points_money)
    TextView tvPointsMoney;
    @BindView(R.id.iv_use_points)
    ImageView ivUsePoints;
    @BindView(R.id.rl_money)
    RelativeLayout rlMoney;
    private DataRepository dataRepository;

    private String address_id;
    private String pay_type = "20";
    private boolean flag = false;
    private String is_use_points = "1";
    private SureOrderModel.DataBean sureOrderData;
    private VipOrderConfirmAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initRed();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vip_order_confirm);
        ButterKnife.bind(this);
        initView();
        initData();
    }


    private void initView() {
        adapter = new VipOrderConfirmAdapter(mContext);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        recyclerView.setAdapter(adapter);
        adapter.setOnItemDataClickListener(new BaseAdapter.OnItemDataClickListener<SureOrderModel.DataBean.GoodsListBean>() {
            @Override
            public void onItemViewClick(View view, int position, SureOrderModel.DataBean.GoodsListBean o) {
                if(view.getId()==R.id.rl_item) {
                    Intent intent = new Intent(mContext, GoodsDetailActivity.class);
                    intent.putExtra("goods_id", o.getGoods_id() + "");
                    startActivity(intent);
                }else if(view.getId()==R.id.iv_question){
                    showTipDialog();
                }
            }
        });

    }
    private void showTipDialog() {
        TDialog tDialog = new TDialog.Builder(getSupportFragmentManager())
                .setLayoutRes(R.layout.dialog_tip)
                //设置弹窗展示的xml布局
                .setCancelableOutside(true)
                .setScreenWidthAspect(this, 0.7f)
                .setGravity(Gravity.CENTER)     //设置弹窗展示位置
                .create()   //创建TDialog
                .show();//展示

    }


    private void initData() {
        dataRepository = Injection.dataRepository(this);
        vipGoods();
        getAddressDefault();

    }

    private void getAddressDefault() {
        LoginBean loginBean = new LoginBean();
        loginBean.wxapp_id = "10001";
        loginBean.token = FastData.getToken();
        ViewLoading.show(this);
        dataRepository.getAddressDefault(loginBean, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(mContext);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(mContext);
                AddressDefaultModel addressDefaultModel = (AddressDefaultModel) data;
                if (addressDefaultModel.getCode() == 1) {
                    if (addressDefaultModel.getData() != null) {
                        tvName.setText(addressDefaultModel.getData().getName());
                        tvPhone.setText(addressDefaultModel.getData().getPhone());
                        tvAddress.setText(addressDefaultModel.getData().getRegion().toString());
                        address_id = addressDefaultModel.getData().getAddress_id() + "";
                    } else {
                        tvName.setText("暂无地址");
                        tvAddress.setText("请选择配送地址");
                        tvPhone.setText("");
                    }
                }
//                ToastUtils.showToast(wxPayResultModel.getMsg());
            }
        });
    }

    private void vipGoods() {
        Map<String, String> map = new HashMap<>();
        map.put("wxapp_id", "10001");
        map.put("token", FastData.getToken());
        map.put("is_use_points", is_use_points);
        ViewLoading.show(this);
        dataRepository.vipGoods(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(mContext);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(mContext);
                SureOrderModel sureOrderModel = (SureOrderModel) data;
                sureOrderData = sureOrderModel.getData();
                if (sureOrderModel.getCode() == 1) {
                    tvDiscount.setText("金豆抵扣" + sureOrderData.getPoints_money() + "元");
                    tvTotalPrice.setText(sureOrderData.getPoints_num()+"金豆");
                    tvPointsMoney.setText("剩余可用平台货币" + sureOrderData.getUser_points() + "元");

                    adapter.setData(sureOrderData.getGoods_list());
                    EventBus.getDefault().post(new ShopCartRefreshEvent());
//                ToastUtils.showToast(sureOrderModel.getMsg());
                }
            }
        });
    }


    private void buyVipGoods() {
        LoginBean loginBean = new LoginBean();
        loginBean.wxapp_id = "10001";
        loginBean.token = FastData.getToken();
        loginBean.address_id = address_id;
        loginBean.is_use_points = is_use_points;
        loginBean.pay_type = "10";
        ViewLoading.show(this);
        dataRepository.buyVipGoods(loginBean, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(mContext);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(mContext);
                PayStatusModel statusModel = (PayStatusModel) data;
                if (statusModel.getCode() == 1) {
                    startActivity(new Intent(mContext,VipPaySuccessActivity.class));
                    finish();
                    EventBus.getDefault().post("order_refresh");
                    EventBus.getDefault().post("4");
                }else {
                    ToastUtils.showToast(statusModel.getMsg());
                }
            }
        });
    }

    /**
     * prepay_id : wx11140431963012c5cb5a8cd613d3130000
     * nonceStr : ca39047264ad5a85a7f3c640289e48d4
     * timeStamp : 1615442671
     * paySign : 7DADAB91C216E61708420EF8F82ABEA8
     * mch_id : 1605495785
     * app_id : wx541630a0717a5007
     * package : Sign=WXPay
     *
     * @param payment
     */

    private void wxPay(WxPayResultModel.DataBean.PaymentBean payment) {
        PayReq req = new PayReq();
//        Gson gson = new Gson();
//        Map<String, String> map = new HashMap<>();
//        map = gson.fromJson(alipayRecord.getData(), map.getClass());
        req.appId = payment.getApp_id();
        req.nonceStr = payment.getNonceStr();
        req.packageValue = payment.getPackageX();
//        req.packageValue = "Sign=WXPay";
        req.partnerId = payment.getMch_id();
        req.prepayId = payment.getPrepay_id();
        req.sign = payment.getPaySign();
        req.timeStamp = payment.getTimeStamp();
        MyApp.mWxApi.sendReq(req);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 9 && resultCode == RESULT_OK) {

            if (data.getSerializableExtra("result") != null) {
                Serializable result = data.getSerializableExtra("result");
                AddressListModel.DataBean.ListBean userShipBean = (AddressListModel.DataBean.ListBean) result;
                if (userShipBean == null) {
                    getAddressDefault();

                }else {
                    address_id = userShipBean.getAddress_id() + "";
                    tvName.setText(userShipBean.getName());
                    String phone = userShipBean.getPhone().replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
                    tvPhone.setText(phone);
                    tvAddress.setText(userShipBean.getRegion().getProvince() + userShipBean.getRegion().getCity() + userShipBean.getRegion().getRegion());
                }

            }
        }
        if (requestCode == 9 && resultCode == 1001) {
            getAddressDefault();
        }
    }

    @OnClick({R.id.iv_back, R.id.rl_address, R.id.tv_settlement})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.rl_address:
                Intent intent = new Intent(this, AddressActivity.class);
                intent.putExtra("from", "from");
                startActivityForResult(intent, 9);

                break;
            case R.id.tv_settlement:
                if (TextUtils.isEmpty(address_id)) {
                    ToastUtils.showToast("请输入收货地址");
                    return;
                }

                buyVipGoods();

                break;

        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN, priority = 100, sticky = false) //在ui线程执行，优先级为100
    public void onEvent(String event) {
        if (event.equals("pay_success")) {
            Intent intent = new Intent(this, PaySuccessActivity.class);
            intent.putExtra("type", "1");
            startActivity(intent);
            finish();
        }
        if (event.equals("pay_cancel")) {
//            Intent intent = new Intent(mContext, OrderDetailActivity.class);
//            intent.putExtra("order_id",sureOrderData.get.getOrder_id());
//            startActivity(intent);
        }
    }
}
