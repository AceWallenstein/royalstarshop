package com.pinnoocle.royalstarshop.shoppingcart;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.adapter.ShoppingCartAdapter;
import com.pinnoocle.royalstarshop.bean.CartListsModel;
import com.pinnoocle.royalstarshop.bean.LoginBean;
import com.pinnoocle.royalstarshop.common.BaseFragment;
import com.pinnoocle.royalstarshop.event.CanSettlement;
import com.pinnoocle.royalstarshop.event.CartAllCheckedEvent;
import com.pinnoocle.royalstarshop.event.ShopCartRefreshEvent;
import com.pinnoocle.royalstarshop.event.UpdateTotalPriceEvent;
import com.pinnoocle.royalstarshop.nets.DataRepository;
import com.pinnoocle.royalstarshop.nets.Injection;
import com.pinnoocle.royalstarshop.nets.RemotDataSource;
import com.pinnoocle.royalstarshop.utils.FastData;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.text.DecimalFormat;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class ShoppingCartFragment extends BaseFragment {
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
    private DataRepository dataRepository;
    private ShoppingCartAdapter adapter;

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
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new ShoppingCartAdapter(getContext());
        recyclerView.setAdapter(adapter);
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
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(getContext());
                CartListsModel cartListsModel = (CartListsModel) data;
                if (cartListsModel.getCode() == 1) {
                    List<CartListsModel.DataBean.GoodsListBean> goods_list = cartListsModel.getData().getGoods_list();
                    adapter.setData(goods_list);
                }
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
                tvFreight.setText("运费：￥" + totalFreight);

            }
        }
        tvTotalPrice.setText("   ￥" + doubleToString(totalPrice));
    }

    public static String doubleToString(double num) {
        //使用0.00不足位补0，#.##仅保留有效位
        return new DecimalFormat("0.00").format(num);
    }

    private void refreshEditStatus() {
        boolean isEditStatus = "去结算".equals(tvSettlement.getText().toString());
        String text;
        if (isEditStatus) {
//            tvCancel.setVisibility(View.GONE);
//            tvAllSelect.setVisibility(View.GONE);
            llAllSelect.setVisibility(View.GONE);
            tvTotalPrice.setVisibility(View.GONE);
            tvSettlement.setVisibility(View.GONE);
            text = "完成";
        } else {
//            tvCancel.setVisibility(View.VISIBLE);
//            tvAllSelect.setVisibility(View.VISIBLE);
//            llAllSelect.setVisibility(View.VISIBLE);
            text = "编辑";
            tvTotalPrice.setVisibility(View.VISIBLE);
            tvSettlement.setVisibility(View.VISIBLE);
        }
        tvEdit.setText(text);
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

    //    @Subscribe(threadMode = ThreadMode.MAIN, priority = 100, sticky = false) //在ui线程执行，优先级为100
//    public void onEvent(SetCartNums event) {
//        setNum(event.getId(),event.getNums());
//    }
//
    @Subscribe(threadMode = ThreadMode.MAIN, priority = 100, sticky = false) //在ui线程执行，优先级为100
    public void onEvent(ShopCartRefreshEvent event) {
        cartLists();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @OnClick({R.id.ll_all_select, R.id.tv_settlement,R.id.tv_edit})
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
                break;
            case R.id.tv_edit:
                refreshEditStatus();
                break;
        }
    }
}
