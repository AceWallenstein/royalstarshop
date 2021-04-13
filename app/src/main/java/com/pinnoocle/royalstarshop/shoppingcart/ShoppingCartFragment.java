package com.pinnoocle.royalstarshop.shoppingcart;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pedaily.yc.ycdialoglib.toast.ToastUtils;
import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.adapter.ShoppingCartAdapter;
import com.pinnoocle.royalstarshop.bean.CartListsModel;
import com.pinnoocle.royalstarshop.bean.LoginBean;
import com.pinnoocle.royalstarshop.bean.OrderCartModel;
import com.pinnoocle.royalstarshop.bean.ResultModel;
import com.pinnoocle.royalstarshop.common.BaseFragment;
import com.pinnoocle.royalstarshop.event.CanSettlement;
import com.pinnoocle.royalstarshop.event.CartAllCheckedEvent;
import com.pinnoocle.royalstarshop.event.SetCartNums;
import com.pinnoocle.royalstarshop.event.ShopCartRefreshEvent;
import com.pinnoocle.royalstarshop.event.UpdateTotalPriceEvent;
import com.pinnoocle.royalstarshop.login.LoginActivity;
import com.pinnoocle.royalstarshop.mine.activity.OrderConfirmActivity;
import com.pinnoocle.royalstarshop.nets.DataRepository;
import com.pinnoocle.royalstarshop.nets.Injection;
import com.pinnoocle.royalstarshop.nets.RemotDataSource;
import com.pinnoocle.royalstarshop.utils.FastData;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

public class ShoppingCartFragment extends BaseFragment implements OnRefreshListener {
    @BindView(R.id.tv_edit)
    TextView tvEdit;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.checkbox)
    CheckBox checkbox;
    @BindView(R.id.tv_all_select_1)
    TextView tvAllSelect1;
    @BindView(R.id.ll_all_select)
    LinearLayout llAllSelect;
    @BindView(R.id.tv_total)
    TextView tvTotal;
    @BindView(R.id.tv_total_price)
    TextView tvTotalPrice;
    @BindView(R.id.tv_freight)
    TextView tvFreight;
    @BindView(R.id.tv_settlement)
    TextView tvSettlement;
    @BindView(R.id.rl_panel)
    RelativeLayout rlPanel;
    @BindView(R.id.iv_empty)
    ImageView ivEmpty;
    @BindView(R.id.tv_empty)
    TextView tvEmpty;
    @BindView(R.id.rl_empty)
    RelativeLayout rlEmpty;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
    private DataRepository dataRepository;
    private ShoppingCartAdapter adapter;
    private List<String> cartIdList;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
    }

    @Override
    protected int LayoutId() {
        return R.layout.fragment_shopping_cart;
    }

    @Override
    protected void initView() {
        tvEdit.setVisibility(View.VISIBLE);
        rlEmpty.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
        rlPanel.setVisibility(View.VISIBLE);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new ShoppingCartAdapter(getContext());
        recyclerView.setAdapter(adapter);
        refresh.setOnRefreshListener(this);

    }


    @Override
    protected void initData() {
        dataRepository = Injection.dataRepository(getContext());
        cartLists();
    }


    private void cartLists() {
        ViewLoading.show(getContext());
        LoginBean loginBean = new LoginBean();
        loginBean.wxapp_id = "10001";
        loginBean.token = FastData.getToken();
        dataRepository.cartLists(loginBean, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(getContext());
                refresh.finishRefresh();
            }

            @Override
            public void onSuccess(Object data) {
                refresh.finishRefresh();
                ViewLoading.dismiss(getContext());
                CartListsModel cartListsModel = (CartListsModel) data;
                if (cartListsModel.getCode() == 1) {
                    List<CartListsModel.DataBean.GoodsListBean> goods_list = cartListsModel.getData().getGoods_list();
                    if (goods_list == null || goods_list.size() == 0) {
                        EventBus.getDefault().post(new CartAllCheckedEvent(false));
                        EventBus.getDefault().post(new CanSettlement(false));
                    }
                    if (goods_list != null) {
                        adapter.setData(goods_list);
                        updateTotalPrice();
                    }
                }
            }
        });
    }

    private void setNum(String goods_id, String goods_sku_id, String num) {
        LoginBean loginBean = new LoginBean();
        loginBean.goods_id = goods_id + "";
        loginBean.wxapp_id = "10001";
        loginBean.token = FastData.getToken();
        loginBean.goods_sku_id = goods_sku_id;
        loginBean.type = 3 + "";  //1 减少 2增加 3直接修改数量
        loginBean.num = num + "";
        dataRepository.cartChangeNums(loginBean, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(getContext());
                ResultModel resultModel = (ResultModel) data;
                if (resultModel.getCode() == 1) {

                }
//                ToastUtils.showToast(resultModel.getMsg());
            }
        });
    }

    private void deleteCart(String goods_sku_id) {
        LoginBean loginBean = new LoginBean();
        loginBean.token = FastData.getToken();
        loginBean.wxapp_id = "10001";
        loginBean.goods_sku_id = goods_sku_id;
        dataRepository.cartDelete(loginBean, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(getContext());
                ResultModel resultModel = (ResultModel) data;
                if (resultModel.getCode() == 1) {
                    cartLists();
                }
                ToastUtils.showToast(resultModel.getMsg());
            }
        });
    }

    private void orderCart(String cart_ids) {
        Map<String, String> map = new HashMap<>();
        map.put("wxapp_id", "10001");
        map.put("token", FastData.getToken());
        map.put("cart_ids", cart_ids);
        ViewLoading.show(getContext());
        dataRepository.orderCart(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(getContext());
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(getContext());
                OrderCartModel orderCartModel = (OrderCartModel) data;
                if (orderCartModel.getCode() == 1) {
                    EventBus.getDefault().post(new ShopCartRefreshEvent());
                    Intent intent = new Intent(getContext(), OrderConfirmActivity.class);
                    intent.putExtra("sureOrderData", orderCartModel.getData());
                    intent.putExtra("cart_ids", cart_ids);
                    startActivity(intent);
                }
//                ToastUtils.showToast(sureOrderModel.getMsg());
            }
        });
    }


    private void updateTotalPrice() {
        double totalPrice = 0;
        double totalFreight = 0;
        for (CartListsModel.DataBean.GoodsListBean listBean :
                adapter.getData()) {
            if (listBean.isIs_select()) {
                totalPrice += listBean.getTotal_num() * Double.parseDouble(listBean.getGoods_price());
                tvTotalPrice.setText("￥" + totalPrice);
                totalFreight += listBean.getTotal_num() * Double.parseDouble(listBean.getFreight());
                tvFreight.setText("运费：￥" + doubleToString(totalFreight));

            }
        }
        tvTotalPrice.setText("   ￥" + doubleToString(totalPrice));
    }

    public static String doubleToString(double num) {
        //使用0.00不足位补0，#.##仅保留有效位
        return new DecimalFormat("0.00").format(num);
    }

    @Override
    public void onPause() {
        super.onPause();
        tvEdit.setText("编辑");
        tvTotal.setVisibility(View.VISIBLE);
        tvTotalPrice.setVisibility(View.VISIBLE);
        tvFreight.setVisibility(View.VISIBLE);
        tvSettlement.setText("去结算");
    }

    private void refreshEditStatus() {
        boolean isEditStatus = "编辑" == tvEdit.getText().toString();
        String text;
        if (isEditStatus) {
            tvTotal.setVisibility(View.GONE);
            tvTotalPrice.setVisibility(View.GONE);
            tvFreight.setVisibility(View.GONE);
            tvSettlement.setText("删 除");
            //删除按钮
            text = "完成";
        } else {
            text = "编辑";
            tvTotal.setVisibility(View.VISIBLE);
            tvTotalPrice.setVisibility(View.VISIBLE);
            tvFreight.setVisibility(View.VISIBLE);
            tvSettlement.setText("去结算");

        }
        tvEdit.setText(text);
    }

    private String dealCartIdList() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cartIdList.size(); i++) {
            if (i == cartIdList.size() - 1) {
                sb.append(cartIdList.get(i) + "");
            } else {
                sb.append(cartIdList.get(i) + ",");
            }
        }
        return sb.toString();
    }


    @Subscribe(threadMode = ThreadMode.MAIN, priority = 100, sticky = false) //在ui线程执行，优先级为100
    public void onEvent(CartAllCheckedEvent event) {
        checkbox.setChecked(event.getAllChecked());
        updateTotalPrice();
//        if (event.getAllChecked()) {
//            tvAllSelect.setTextColor(getResources().getColor(R.color.grey));
//            tvCancel.setTextColor(getResources().getColor(R.color.light_black));
//        } else {
//            tvAllSelect.setTextColor(getResources().getColor(R.color.light_black));
//            tvCancel.setTextColor(getResources().getColor(R.color.grey));

//        }
    }

    //
    @Subscribe(threadMode = ThreadMode.MAIN, priority = 100, sticky = false) //在ui线程执行，优先级为100
    public void onEvent(UpdateTotalPriceEvent event) {
        updateTotalPrice();
    }

    @Subscribe(threadMode = ThreadMode.MAIN, priority = 100, sticky = false) //在ui线程执行，优先级为100
    public void onEvent(CanSettlement event) {
        tvSettlement.setEnabled(event.canSettlement());
    }

    @Subscribe(threadMode = ThreadMode.MAIN, priority = 100, sticky = false) //在ui线程执行，优先级为100
    public void onEvent(SetCartNums event) {
        setNum(event.getGoods_id(), event.getGoods_sku_id(), event.getNum());
        updateTotalPrice();
    }

    //
    @Subscribe(threadMode = ThreadMode.MAIN, priority = 100, sticky = false) //在ui线程执行，优先级为100
    public void onEvent(ShopCartRefreshEvent event) {
        cartLists();
    }

    @Subscribe(threadMode = ThreadMode.MAIN, priority = 100, sticky = false) //在ui线程执行，优先级为100
    public void onEvent(String event) {
        if (event.equals("4")) {
            cartLists();
        }
        if (event.equals("7")) {
            tvEdit.setVisibility(View.GONE);
            rlEmpty.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
            rlPanel.setVisibility(View.GONE);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @OnClick({R.id.ll_all_select, R.id.tv_settlement, R.id.tv_edit,  R.id.tv_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_all_select:
                checkbox.setChecked(!checkbox.isChecked());
                for (CartListsModel.DataBean.GoodsListBean listBean :
                        adapter.getData()) {
                    listBean.setIs_select(checkbox.isChecked());
                }
                EventBus.getDefault().post(new CartAllCheckedEvent(checkbox.isChecked()));
                EventBus.getDefault().post(new CanSettlement(checkbox.isChecked()));
                adapter.notifyDataSetChanged();
                break;
            case R.id.tv_settlement:

                cartIdList = new ArrayList();
                List<CartListsModel.DataBean.GoodsListBean> adapterList = adapter.getData();
                for (int i = 0; i < adapterList.size(); i++) {
                    if (adapterList.get(i).isIs_select()) {
                        cartIdList.add(adapterList.get(i).getGoods_id() + "_" + adapterList.get(i).getGoods_sku_id());
                    }
                }
                if (tvSettlement.getText().toString().equals("删 除")) {
                    if (cartIdList.size() == 0) {
                        ToastUtils.showToast("请选择需要删除的商品");
                    } else {
                        String cartIds = dealCartIdList();
                        deleteCart(cartIds);
                    }
                } else {
                    if (cartIdList.size() == 0) {
                        ToastUtils.showToast("请选择需要购买的数据");
                    } else {
                        String cartIds = dealCartIdList();
                        orderCart(cartIds);
                    }
                }
                break;
            case R.id.tv_edit:
                refreshEditStatus();
                break;
            case R.id.tv_login:

                    Intent intent = new Intent(getContext(), LoginActivity.class);
                    intent.putExtra("pos",1);
                    startActivity(intent);

                break;

        }
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        cartLists();
    }
}
