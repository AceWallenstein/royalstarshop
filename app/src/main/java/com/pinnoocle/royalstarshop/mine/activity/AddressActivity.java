package com.pinnoocle.royalstarshop.mine.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.TextureView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.adapter.AddressAdapter;
import com.pinnoocle.royalstarshop.bean.AddressListModel;
import com.pinnoocle.royalstarshop.bean.LoginBean;
import com.pinnoocle.royalstarshop.bean.ResultModel;
import com.pinnoocle.royalstarshop.common.BaseActivity;
import com.pinnoocle.royalstarshop.common.BaseAdapter;
import com.pinnoocle.royalstarshop.event.AddAddressEvent;
import com.pinnoocle.royalstarshop.nets.DataRepository;
import com.pinnoocle.royalstarshop.nets.Injection;
import com.pinnoocle.royalstarshop.nets.RemotDataSource;
import com.pinnoocle.royalstarshop.utils.FastData;
import com.pinnoocle.royalstarshop.utils.StatusBarUtil;
import com.timmy.tdialog.TDialog;
import com.timmy.tdialog.base.BindViewHolder;
import com.timmy.tdialog.listener.OnBindViewListener;
import com.timmy.tdialog.listener.OnViewClickListener;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddressActivity extends BaseActivity {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.tv_add_address)
    TextView tvAddAddress;
    private AddressAdapter adapter;
    //    private List<AddressBean> list;
    private DataRepository dataRepository;
    private AddressListModel addressListModel;

    protected void onCreate(Bundle savedInstanceState) {
        initWhite();
        StatusBarUtil.StatusBarLightMode(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_addresss);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    @Subscribe(threadMode = ThreadMode.MAIN, priority = 100, sticky = false) //在ui线程执行，优先级为100
    public void onEvent(AddAddressEvent event) {
        addressLists();
    }

    private void initView() {
        adapter = new AddressAdapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        adapter.setOnItemDataClickListener(new BaseAdapter.OnItemDataClickListener<AddressListModel.DataBean.ListBean>() {
            @Override
            public void onItemViewClick(View view, int position, AddressListModel.DataBean.ListBean dataBean) {
                switch (view.getId()) {
                    case R.id.ll_check:
                        setDefShip(dataBean.getAddress_id());
                        break;

                    case R.id.tv_del:
                        Intent intent = new Intent(AddressActivity.this, EditAddressActivity.class);
                        intent.putExtra("dataBean", dataBean);
                        if (dataBean.getAddress_id() == addressListModel.getData().getDefault_id()) {
                            intent.putExtra("default_id", 1);
                        } else {
                            intent.putExtra("default_id", 0);
                        }
                        startActivity(intent);
                        break;
                    case R.id.tv_delete:
                        showAddressDeleteDialog(dataBean.getAddress_id());
                        break;

                    default:
//                        if (!TextUtils.isEmpty(getIntent().getStringExtra("from"))) {
//                            setResult(RESULT_OK);
//                            finish();
//                        }

                        if (getIntent().getStringExtra("from") != null) {

                            if (getIntent().getStringExtra("from").equals("from")) {
                                //数据是使用Intent返回
                                Intent intent1 = new Intent();
                                //把返回数据存入Intent
                                intent1.putExtra("result", dataBean);
                                //设置返回数据
                                AddressActivity.this.setResult(RESULT_OK, intent1);
                                //关闭Activity
                                finish();
                            }
                            if (!TextUtils.isEmpty(getIntent().getStringExtra("from"))) {
                                setResult(RESULT_OK);
                                finish();
                            }
                        }
                        break;
                }
            }
        });
    }

    private void initData() {
        dataRepository = Injection.dataRepository(this);
        addressLists();
    }

    private void addressLists() {
        ViewLoading.show(this);
        LoginBean loginBean = new LoginBean();
        loginBean.token = FastData.getToken();
        loginBean.wxapp_id = "10001";
        dataRepository.addressLists(loginBean, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(AddressActivity.this);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(AddressActivity.this);
                addressListModel = (AddressListModel) data;
                if (addressListModel.getCode() == 1) {
                    List<AddressListModel.DataBean.ListBean> dataBeanList = addressListModel.getData().getList();
                    adapter.setDefaultId(addressListModel.getData().getDefault_id());
                    adapter.setData(dataBeanList);
                }


            }
        });
    }

    private void setDefShip(int id) {
        ViewLoading.show(this);
        LoginBean loginBean = new LoginBean();
        loginBean.token = FastData.getToken();
        loginBean.wxapp_id = "10001";
        loginBean.address_id = id + "";
        dataRepository.setDefault(loginBean, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(AddressActivity.this);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(AddressActivity.this);
                ResultModel resultModel = (ResultModel) data;
                if (resultModel.getCode() == 1) {
                    addressLists();
                }


            }
        });
    }

    //
    private void addressDelete(int id) {
        ViewLoading.show(this);
        LoginBean loginBean = new LoginBean();
        loginBean.token = FastData.getToken();
        loginBean.wxapp_id = "10001";
        loginBean.address_id = id + "";
        dataRepository.addressDelete(loginBean, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(AddressActivity.this);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(AddressActivity.this);
                ResultModel resultModel = (ResultModel) data;
                if (resultModel.getCode() == 1) {
                    addressLists();
                }
            }
        });
    }


    @Subscribe(threadMode = ThreadMode.MAIN, priority = 100, sticky = false) //在ui线程执行，优先级为100
    public void onEvent(String message) {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == 1 && requestCode == 1) {
//            if (data == null) {
//                return;
//            }
//            Serializable serializable = data.getSerializableExtra("addressBean");
//            AddressBean addressBean = (AddressBean) serializable;
//            list.add(addressBean);
//            adapter.setData(list);
    }

    @OnClick({R.id.iv_back, R.id.tv_add_address})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_add_address:
//                ActivityUtils.startActivity(this, AddAddressActivity.class);
                startActivity(new Intent(this, AddAddressActivity.class));
                break;
        }

    }

    private void showAddressDeleteDialog(int address_id) {
        new TDialog.Builder(getSupportFragmentManager())
                .setLayoutRes(R.layout.address_delete_dialog)
                .setScreenWidthAspect(this, 0.7f)
                .setGravity(Gravity.CENTER)
                .setCancelableOutside(false)
                .addOnClickListener(R.id.tv_cancel, R.id.tv_sure)
                .setOnBindViewListener(new OnBindViewListener() {
                    @Override
                    public void bindView(BindViewHolder viewHolder) {
                    }
                })
                .setOnViewClickListener(new OnViewClickListener() {
                    @Override
                    public void onViewClick(BindViewHolder viewHolder, View view, TDialog tDialog) {
                        switch (view.getId()) {
                            case R.id.tv_cancel:
                                tDialog.dismiss();
                                break;
                            case R.id.tv_sure:
                                addressDelete(address_id);
                                tDialog.dismiss();

                                break;
                        }
                    }
                })
                .create()
                .show();
    }


}
