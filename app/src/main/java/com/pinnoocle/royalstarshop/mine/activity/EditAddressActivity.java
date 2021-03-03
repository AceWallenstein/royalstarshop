package com.pinnoocle.royalstarshop.mine.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lljjcoder.Interface.OnCityItemClickListener;
import com.lljjcoder.bean.CityBean;
import com.lljjcoder.bean.DistrictBean;
import com.lljjcoder.bean.ProvinceBean;
import com.lljjcoder.citywheel.CityConfig;
import com.lljjcoder.style.citypickerview.CityPickerView;
import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pedaily.yc.ycdialoglib.toast.ToastUtils;
import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.bean.AddressListModel;
import com.pinnoocle.royalstarshop.bean.LoginBean;
import com.pinnoocle.royalstarshop.bean.ResultModel;
import com.pinnoocle.royalstarshop.common.BaseActivity;
import com.pinnoocle.royalstarshop.event.AddAddressEvent;
import com.pinnoocle.royalstarshop.nets.DataRepository;
import com.pinnoocle.royalstarshop.nets.Injection;
import com.pinnoocle.royalstarshop.nets.RemotDataSource;
import com.pinnoocle.royalstarshop.utils.FastData;
import com.pinnoocle.royalstarshop.utils.StatusBarUtil;

import org.greenrobot.eventbus.EventBus;

import java.io.Serializable;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EditAddressActivity  extends BaseActivity {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.ed_area)
    TextView edArea;
    @BindView(R.id.tv_save)
    TextView tvSave;
    @BindView(R.id.ed_name)
    EditText edName;
    @BindView(R.id.ed_phone)
    EditText edPhone;
    @BindView(R.id.ed_address)
    EditText edAddress;

    CityPickerView mPicker = new CityPickerView();
    String address_id;
    private String districtName;
    private String cityName;
    private String provinceName;
    private DataRepository dataRepository;
    private AddressListModel.DataBean.ListBean dataBean;

    protected void onCreate(Bundle savedInstanceState) {
        initWhite();
        StatusBarUtil.StatusBarLightMode(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_edit_addresss);
        ButterKnife.bind(this);
        initView();
        mPicker.init(this);
        initData();
    }


    private void initView() {
        Serializable serializableExtra = getIntent().getSerializableExtra("dataBean");
        dataBean = (AddressListModel.DataBean.ListBean) serializableExtra;
        edName.setText(dataBean.getName().trim());
        edPhone.setText(dataBean.getPhone().trim());
        edArea.setText(dataBean.getRegion().toString().trim());
        edAddress.setText(dataBean.getDetail().trim());
        address_id = String.valueOf(dataBean.getAddress_id());
    }

    private void initData() {
        dataRepository = Injection.dataRepository(this);
    }

    private void addressEdit() {
        if (TextUtils.isEmpty(address_id)) {
            return;
        }
        ViewLoading.show(this);
        LoginBean loginBean = new LoginBean();
        loginBean.wxapp_id = "10001";
        loginBean.token = FastData.getToken();
        loginBean.region =  provinceName+","+ cityName+","+ districtName;
        loginBean.name = edName.getText().toString().trim();
        loginBean.phone = edPhone.getText().toString().trim();
        loginBean.detail = edAddress.getText().toString().trim();
        loginBean.address_id = address_id;
        dataRepository.addressEdit(loginBean, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(EditAddressActivity.this);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(EditAddressActivity.this);
                ResultModel resultModel = (ResultModel) data;
                if (resultModel.getCode() == 1) {
                    EventBus.getDefault().post(new AddAddressEvent());
                    finish();
                }
                ToastUtils.showToast(resultModel.getMsg());


            }
        });
    }

    @OnClick({R.id.iv_back, R.id.ed_area, R.id.tv_save})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.ed_area:
                showCitiesDialog();
                break;
            case R.id.tv_save:
                if (edName.getText().toString().trim().equals("")) {
                    ToastUtils.showToast("请输入收货人姓名");
                } else if (edPhone.getText().toString().trim().equals("")) {
                    ToastUtils.showToast("请输入收货人联系电话");
                } else if (edArea.getText().toString().trim().equals("")) {
                    ToastUtils.showToast("请选择省市区");
                } else if (edAddress.getText().toString().trim().equals("")) {
                    ToastUtils.showToast("请输入街道小区楼层");
                } else {
                    String telRegex = "[1][3456789]\\d{9}";
                    boolean matches = edPhone.getText().toString().matches(telRegex);
                    if (matches == false) {
                        ToastUtils.showToast("手机号码格式不正确");
                    } else {
                        //保存地址到服务器
//                        getAreaId();
                        addressEdit();
                    }
                }
                break;
        }

    }

    private void showCitiesDialog() {
        CityConfig cityConfig = new CityConfig.Builder().build();
        mPicker.setConfig(cityConfig);

//监听选择点击事件及返回结果
        mPicker.setOnCityItemClickListener(new OnCityItemClickListener() {
            @Override
            public void onSelected(ProvinceBean province, CityBean city, DistrictBean district) {
                edArea.setText(province.getName() + " " + city.getName() + " " + district.getName());
                address_id = district.getId();
                provinceName = province.getName();
                cityName = city.getName();
                districtName = district.getName();
                //省份province
                //城市city
                //地区district
            }

            @Override
            public void onCancel() {

            }
        });

        //显示
        mPicker.showCityPicker();
    }

}
